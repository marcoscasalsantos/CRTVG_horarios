package com.plexus.crtvgHorarios.dataAccess.dao.horario;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

import com.plexus.crtvgHorarios.dataAccess.dao.common.BaseDao;
import com.plexus.crtvgHorarios.dataAccess.pojo.DefinicionHorarioPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.ExcepcionHorarioPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.horarios.DefinicionHorarioDto;

@Repository
public class HorarioDaoImpl extends BaseDao implements HorarioDao {

    //private static final Logger LOG = Logger.getLogger(HorarioDaoImpl.class.getName());
	
	
	/**
	 * 
	 * -- Devuelve los dias entre las fechas indicadas de comienzo y fin
	 * select to_date('01-01-2013','dd-MM-yyyy') + rownum -1
	 * from all_objects
	 * where rownum <= to_date('31-12-2013','dd-MM-yyyy')-to_date('01-01-2013','dd-MM-yyyy')+1
	 * 	
	 * 
	 *  Para H2:   " and concat(YEAR(hd.fecha_dia),WEEK(hd.fecha_dia)) = concat(YEAR(?),WEEK(?)) ) " +
	 */
	
	private static final String SQL_SELECT_BY_SECCION_AND_SEMANA =			
		" select " +				
		" t1.apelido1 as apellido1Empleado, " +							
		" t2.apelido1 as apellido1Sustituto, " +
		" t1.apelido2 as apellido2Empleado, " +		
		" t2.apelido2 as apellido2Sustituto, " +
		" t1.categoria, " +
		" dh.cor_horario as colorHorario, " +
		" e.descricion as descripcionEstado ," +
		" eh.descricion as descripcionExcepcion, " +
		" eh.estado_contrato as estadoContratoSustituto, " +
		" p.familia as familiaProduccion, " +
		" u.fase," +
		" fechas.fecha_dia as fechaDia, " +
		" fud.festividad, " +
		" h.hora_desde as horaDesde, " +
		" h.hora_ata as horaHasta, " +
		" dh.id_definicion as idDefinicionHorario, " +
		
		" dh.data_desde as fechaDefinicionDesde, " +
		" dh.data_ata as fechaDefinicionHasta, " +
		" dh.hora_desde as horaDefinicionDesde, " +
		" dh.hora_ata as horaDefinicionHasta, " +	
		" dh.id_ubicacion as idUbicacionDefinicion, " +
		" dh.id_produccion as idProduccionDefinicion, " +
		
		" h.id_traballador as idEmpleado, " +
		" eh.id_estado as idEstado, " +
		" eh.id_excepcion as idExcepcionHorario, " +
		" eh.cor_excepcion as colorExcepcion, " +
		" fud.id_festivo as idFestivo, " +
		" h.id_horas_dia as idHorasDia, " +
		" h.id_produccion as idProduccion, " +
		" eh.id_sustituto as idSustituto, " +
		" h.id_ubicacion as idUbicacion, " +
		" t1.nome as nombreEmpleado, " +
		" p.descricion as nombreProduccion, " +
		" t2.nome as nombreSustituto, " +
		" u.descricion as nombreUbicacion " + 
		" from  " +
		" (select (? + rownum - 1) as fecha_dia from all_objects where rownum <= ? - ? + 1) fechas " +
		" left join horarios_horas h on (fechas.fecha_dia = h.data_dia) " +
		" left join " +
		"   (select f.id_festivo as id_festivo, f.data as fecha_dia, f.festividade as festividad, fu.id_festivo_ubicacion as id_festivo_ubicacion, fu.id_ubicacion as id_ubicacion" +
		"   from festivos f " +
		"   inner join festivos_ubicacions fu on f.id_festivo = fu.id_festivo) fud on (h.data_dia = fud.fecha_dia and h.id_ubicacion = fud.id_ubicacion) " +
		" left join ubicacions u on (h.id_ubicacion = u.codigo) " +
		" left join seccions_ubicacions su on u.codigo = su.id_ubicacion " +
		" left join seccions s on su.id_seccion = s.id_seccion " +
		" left join traballadores t1 on (h.id_traballador = t1.dni) " +
		" left join definicions_horarios dh on (h.id_definicion = dh.id_definicion) " +
		" left join excepcions_horarios eh on h.id_excepcion = eh.id_excepcion " +
		" left join estados e on eh.id_estado = e.codigo " +
		" left join traballadores t2 on eh.id_sustituto = t2.dni " +
		" left join produccions p on h.id_produccion = p.codigo " +
		" where s.id_seccion = ? " +
		" order by h.id_ubicacion, h.data_dia, h.hora_desde asc, h.hora_desde asc ";
	
	
	private static final String SQL_SELECT_BY_MES_ANHO_AND_EMPLEADO =
		" select " + 	
		" h.apelido1 as apellido1Empleado, " +
		" h.apelido2 as apellido2Empleado, " +					
		" t2.apelido1 as apellido1Sustituto, " +					
		" t2.apelido2 as apellido2Sustituto, " +
		" h.categoria, " +
		" dh.cor_horario as colorHorario, " +
		" e.descricion as descripcionEstado , " +
		" eh.descricion as descripcionExcepcion, " +
		" eh.estado_contrato as estadoContratoSustituto, " +
		" p.familia as familiaProduccion, " +
		" u.fase, " +
		" fechas.fecha_dia as fechaDia, " + 
		" fud.festividad, " +
		" h.hora_desde as horaDesde, " + 
		" h.hora_ata as horaHasta, " +
		" dh.id_definicion as idDefinicionHorario, " +
		
		" dh.data_desde as fechaDefinicionDesde, " +
		" dh.data_ata as fechaDefinicionHasta, " +
		" dh.hora_desde as horaDefinicionDesde, " +
		" dh.hora_ata as horaDefinicionHasta, " +
		" dh.id_ubicacion as idUbicacionDefinicion, " +
		" dh.id_produccion as idProduccionDefinicion, " +		
		
		" h.id_traballador as idEmpleado, " +
		" eh.id_estado as idEstado, " +
		" eh.id_excepcion as idExcepcionHorario, " +
		" eh.cor_excepcion as colorExcepcion, " +		
		" fud.id_festivo as idFestivo, " +
		" h.id_horas_dia as idHorasDia, " +
		" h.id_produccion as idProduccion, " +
		" eh.id_sustituto as idSustituto, " +
		" h.id_ubicacion as idUbicacion, " +
		" h.nome as nombreEmpleado, " +
		" p.descricion as nombreProduccion, " + 
		" t2.nome as nombreSustituto, " +
		" u.descricion as nombreUbicacion " +  
		" from  " +
		" (select (? + rownum - 1) as fecha_dia from all_objects where rownum <= ? - ? + 1) fechas " + 
		" left join  " +
		"  (select * " +
		"   from horarios_horas hh " +
		"   inner join traballadores t1 on (hh.id_traballador = t1.dni and hh.id_traballador = ?) ) h on (fechas.fecha_dia = h.data_dia) " +
		" left join " +
		"  (select f.id_festivo as id_festivo, f.data as fecha_dia, f.festividade as festividad, fu.id_festivo_ubicacion as id_festivo_ubicacion, fu.id_ubicacion as id_ubicacion " +
		"   from festivos f " +
		"   inner join festivos_ubicacions fu on f.id_festivo = fu.id_festivo) fud on (h.data_dia = fud.fecha_dia and h.id_ubicacion = fud.id_ubicacion) " + 
		" left join ubicacions u on (h.id_ubicacion = u.codigo) " +
		" left join seccions_ubicacions su on u.codigo = su.id_ubicacion " +
		" left join seccions s on su.id_seccion = s.id_seccion " +
		" left join traballadores t1 on (h.id_traballador = t1.dni) " +
		" left join definicions_horarios dh on (h.id_definicion = dh.id_definicion) " +
		" left join excepcions_horarios eh on h.id_excepcion = eh.id_excepcion " +
		" left join estados e on eh.id_estado = e.codigo " +
		" left join traballadores t2 on eh.id_sustituto = t2.dni " +
		" left join produccions p on h.id_produccion = p.codigo " +
		" order by fechas.fecha_dia, h.hora_desde ";
			
	private static final String SQL_DELETE_ALL_UNIDADES_HORARIO_ANHO = " delete from horarios_horas where id_traballador = ? and extract (year from data_dia) = ? ";
	
	private static final String SQL_INSERT_UNIDADES_HORARIO = " insert into horarios_horas " +
		" (id_horas_dia, data_dia, id_ubicacion, hora_desde, hora_ata, id_traballador, id_definicion, id_excepcion, id_produccion, data_modificacion) " + 
		" values (SEQ_HORARIOS_HORAS.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp) " ;
	
	
	private static final String SQL_DELETE_ALL_DEFINICIONES_HORARIO_ANHO = " delete from definicions_horarios where id_traballador = ? and extract (year from data_desde) = ? ";

	private static final String SQL_DELETE_ALL_EXCEPCIONES_HORARIO_ANHO = 
		" delete from " +
		" excepcions_horarios where id_excepcion in " + 
		" (select id_excepcion " +
		" from " + 
		" horarios_horas h " +
		" inner join definicions_horarios d on h.id_definicion = d.id_definicion " +
		" where d.id_traballador = ? and extract (year from d.data_desde) = ? ) ";
	
	private static final String SQL_INSERT_DEFINICIONES_HORARIO = " insert into definicions_horarios " +
		" (id_definicion, id_traballador, data_desde, data_ata, aplica_luns, aplica_martes, aplica_mercores, aplica_xoves, aplica_venres, aplica_sabado, aplica_domingo, num_semanas_alternar, " +
		" hora_desde, hora_ata, id_produccion, id_ubicacion, cor_horario, data_modificacion) " + 
		" values (SEQ_DEFINICIONS_HORARIOS.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp) ";
	
	private static final String SQL_INSERT_EXCEPCIONES_HORARIO = " insert into excepcions_horarios " +
			" (id_excepcion, id_estado, descricion, id_sustituto, estado_contrato, cor_excepcion, data_modificacion) " +		 
			" values (SEQ_EXCEPCIONS_HORARIOS.NEXTVAL, ?, ?, ?, ?, ?, current_timestamp) ";			
	
	
	private static final String SQL_SELECT_DEFINICIONES_HORARIOS_BY_EMPLEADO_AND_ANHO = " select id_definicion as idDefinicionHorario, " +
		" id_traballador as idEmpleado, " +
		" data_desde as fechaDesde, " +
		" data_ata as fechaHasta, " +
		" aplica_luns as aplicarLunes, " +
		" aplica_martes as aplicarMartes, " +
		" aplica_mercores as aplicarMiercoles, " +
		" aplica_xoves as aplicarJueves, " +
		" aplica_venres as aplicarViernes, " +
		" aplica_sabado as aplicarSabado, " +
		" aplica_domingo as aplicarDomingo, " +
		" p.descricion as nombreProduccion, " +
		" u.descricion as nombreUbicacion, " +
		" num_semanas_alternar as numSemanasAlternancia, " +
		" hora_desde as horaDesde, " +
		" hora_ata as horaHasta, " + 
		" id_ubicacion as idUbicacion, " +
		" id_traballador as idEmpleado, " +
		" id_produccion as idProduccion, " +
		" cor_horario as colorHorario " +
		" from definicions_horarios d " +
		" left join produccions p on d.id_produccion = p.codigo " +
		" left join ubicacions u on d.id_ubicacion = u.codigo " +
		" where id_traballador = ? and extract (year from data_desde) = ? " +
		" order by fechaDesde asc, fechaHasta asc ";
	
	private static final String SQL_SELECT_EXCEPCIONES_HORARIOS_BY_EMPLEADO_AND_ANHO = 
		" select " + 
		" id_excepcion as idExcepcion, " + 
		" id_estado as idEstado, " + 
		" descricion as descripcionExcepcion, " + 
		" id_sustituto as idSustituto, " + 
		" estado_contrato as codigoEstadoContratoSustituto, " + 
		" cor_excepcion as colorExcepcion " +
		" from excepcions_horarios " + 
		" where id_excepcion in " + 
		"   (select id_excepcion " + 
		"   from horarios_horas h " + 
		"   inner join definicions_horarios d on h.id_definicion = d.id_definicion " + 
		"   where d.id_traballador = ? and extract (year from d.data_desde) = ? ) " +
		" order by idExcepcion "; // El ordenarlos por idExcepcion equivale a ordenarlos por fecha ya que al insertarlo se insertan por fecha	
	
	@Override
	public List<UnidadHorarioPojo> getUnidadesHorariosBySeccionSemana(Long idSeccion, Date semana) {
		
		List<UnidadHorarioPojo> unidadesHorarios = new ArrayList<UnidadHorarioPojo>();
				
		LocalDate localDate = new LocalDate(semana);
				
		Date fechaLunesSemana = localDate.withDayOfWeek(DateTimeConstants.MONDAY).toDate();		
		Date fechaDomingoSemana = localDate.withDayOfWeek(DateTimeConstants.SUNDAY).toDate();
		
		Object[] args = {new SqlParameterValue(Types.DATE,fechaLunesSemana), new SqlParameterValue(Types.DATE,fechaDomingoSemana), new SqlParameterValue(Types.DATE,fechaLunesSemana), idSeccion};
		
		unidadesHorarios = super.jdbcTemplate.query(SQL_SELECT_BY_SECCION_AND_SEMANA, args, new UnidadHorarioRowMapper());
		
		return unidadesHorarios;
	}


	@Override
	public List<UnidadHorarioPojo> getUnidadesHorariosByMesAnhoEmpleado(Date mesAnho, String idEmpleado) {
		List<UnidadHorarioPojo> unidadesHorarios = new ArrayList<UnidadHorarioPojo>();
		
		Date fechaPrimerDiaMes = new DateTime(mesAnho).dayOfMonth().withMinimumValue().toDate();		 
		Date fechaUltimoDiaMes = new DateTime(mesAnho).dayOfMonth().withMaximumValue().toDate();
		 		
		Object[] args = {new SqlParameterValue(Types.DATE,fechaPrimerDiaMes), new SqlParameterValue(Types.DATE,fechaUltimoDiaMes), new SqlParameterValue(Types.DATE,fechaPrimerDiaMes), idEmpleado};
		
		unidadesHorarios = super.jdbcTemplate.query(SQL_SELECT_BY_MES_ANHO_AND_EMPLEADO, args, new UnidadHorarioRowMapper());
		
		return unidadesHorarios;
	}


	@Override
	public void deleteAllUnidadesHorariosAnho(String idEmpleado, Integer anho) {
		
		super.jdbcTemplate.update(SQL_DELETE_ALL_UNIDADES_HORARIO_ANHO, idEmpleado, anho);
		
	}

	
	@Override
	public void insertUnidadesHorarios(final List<UnidadHorarioPojo> unidadesHorarios) {
		
		jdbcTemplate.batchUpdate(SQL_INSERT_UNIDADES_HORARIO, new BatchPreparedStatementSetter() {
			 			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				
				UnidadHorarioPojo unidadHorario = unidadesHorarios.get(i);
								
				if (unidadHorario.getFechaDia() != null)
					ps.setDate(1, new java.sql.Date(unidadHorario.getFechaDia().getTime()));
				
				ps.setString(2, unidadHorario.getIdUbicacion());
				
				if (unidadHorario.getHoraDesde() != null)
					ps.setTimestamp(3, new java.sql.Timestamp(unidadHorario.getHoraDesde().getTime()));
				
				if (unidadHorario.getHoraHasta() != null)
					ps.setTimestamp(4, new java.sql.Timestamp(unidadHorario.getHoraHasta().getTime()));
				
				ps.setString(5, unidadHorario.getIdEmpleado());
				
				if (unidadHorario.getIdDefinicionHorario() != null) {
					ps.setLong(6, unidadHorario.getIdDefinicionHorario());
				}
				else {
					ps.setNull(6, Types.NUMERIC);
				}
				
				if (unidadHorario.getIdExcepcionHorario() != null) {
					ps.setLong(7, unidadHorario.getIdExcepcionHorario());
				}
				else {
					ps.setNull(7, Types.NUMERIC);
				}
				
				if (unidadHorario.getIdProduccion() != null) {
					ps.setString(8, unidadHorario.getIdProduccion());
				}
				else {
					ps.setNull(8, Types.VARCHAR);
				}
				
			}
		 
			public int getBatchSize() {
				return unidadesHorarios.size();
			}
			
		});

	}


	@Override
	public void deleteAllDefinicionesHorariosAnho(String idEmpleado, Integer anho) {
		
		super.jdbcTemplate.update(SQL_DELETE_ALL_DEFINICIONES_HORARIO_ANHO, idEmpleado, anho);
		
	}
	
	
	@Override
	public void insertDefinicionesHorarios(final List<DefinicionHorarioPojo> definicionesHorarios) {
		
		
		// TODO: enviar al service la excepción y capturarla la excepción producida por la restriccion "definicion_traballador_unique" y enviarla al controlador para que muestre el mensaje correspondiente
		// ej. si se define un horario igual a otro en fechas, horas, ubicación y producción en la que solo difiere el patrón entonces ya se puede contener ampliando el patron de la definicion ya existente
		// y así se evita la creación de definiciones innecesarias

		jdbcTemplate.batchUpdate(SQL_INSERT_DEFINICIONES_HORARIO, new BatchPreparedStatementSetter() {
 			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				
				DefinicionHorarioPojo definicionHorario = definicionesHorarios.get(i);
								
				ps.setString(1, definicionHorario.getIdEmpleado());
				
				if (definicionHorario.getFechaDesde() != null)
					ps.setDate(2, new java.sql.Date(definicionHorario.getFechaDesde().getTime()));
				
				if (definicionHorario.getFechaHasta() != null)
					ps.setDate(3, new java.sql.Date(definicionHorario.getFechaHasta().getTime()));
								
				// TODO: probar si funciona: ps.setBoolean(4, definicionHorario.isAplicarLunes());
				ps.setString(4, definicionHorario.isAplicarLunes()?"1":"0");
				ps.setString(5, definicionHorario.isAplicarMartes()?"1":"0");
				ps.setString(6, definicionHorario.isAplicarMiercoles()?"1":"0");
				ps.setString(7, definicionHorario.isAplicarJueves()?"1":"0");
				ps.setString(8, definicionHorario.isAplicarViernes()?"1":"0");
				ps.setString(9, definicionHorario.isAplicarSabado()?"1":"0");
				ps.setString(10, definicionHorario.isAplicarDomingo()?"1":"0");	
				
				ps.setInt(11, definicionHorario.getNumSemanasAlternancia());
								
				if (definicionHorario.getHoraDesde() != null)
					ps.setTimestamp(12, new java.sql.Timestamp(definicionHorario.getHoraDesde().getTime()));
				
				if (definicionHorario.getHoraHasta() != null)
					ps.setTimestamp(13, new java.sql.Timestamp(definicionHorario.getHoraHasta().getTime()));
				
				if (definicionHorario.getIdProduccion() != null) {
					ps.setString(14, definicionHorario.getIdProduccion());
				}
				else {
					ps.setNull(14, Types.VARCHAR);
				}
				
				if (definicionHorario.getIdUbicacion() != null) {
					ps.setString(15, definicionHorario.getIdUbicacion());
				}
				else {
					ps.setNull(15, Types.VARCHAR);
				}
				
				ps.setString(16, definicionHorario.getColorHorario());
				
			}
		 
			public int getBatchSize() {
				return definicionesHorarios.size();
			}
			
		});
	}


	@Override
	public List<DefinicionHorarioPojo> getDefinicionesHorarios(String idEmpleado, Integer anho) {
		List<DefinicionHorarioPojo> definicionesHorarios = new ArrayList<DefinicionHorarioPojo>();
				 		
		Object[] args = {idEmpleado, anho};
		
		definicionesHorarios = super.jdbcTemplate.query(SQL_SELECT_DEFINICIONES_HORARIOS_BY_EMPLEADO_AND_ANHO, args, new DefinicionHorarioRowMapper());
		
		return definicionesHorarios;
	}

	@Override
	public List<ExcepcionHorarioPojo> getExcepcionesHorarios(String idEmpleado, Integer anho) {
		List<ExcepcionHorarioPojo> excepcionesHorarios = new ArrayList<ExcepcionHorarioPojo>();
				 		
		Object[] args = {idEmpleado, anho};
		
		excepcionesHorarios = super.jdbcTemplate.query(SQL_SELECT_EXCEPCIONES_HORARIOS_BY_EMPLEADO_AND_ANHO, args, new ExcepcionHorarioRowMapper());
		
		return excepcionesHorarios;
	}	
	

	@Override
	public void deleteAllExcepcionesHorariosAnho(String idEmpleado, Integer anho) {
		
		super.jdbcTemplate.update(SQL_DELETE_ALL_EXCEPCIONES_HORARIO_ANHO, idEmpleado, anho);
		
	}


	@Override
	public void insertExcepcionesHorarios(final List<ExcepcionHorarioPojo> excepcionesHorarios) {

		jdbcTemplate.batchUpdate(SQL_INSERT_EXCEPCIONES_HORARIO, new BatchPreparedStatementSetter() {
 			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				
				ExcepcionHorarioPojo excepcionHorario = excepcionesHorarios.get(i);
												
				ps.setString(1, excepcionHorario.getIdEstado());
				ps.setString(2, excepcionHorario.getDescripcionExcepcion());
				ps.setString(3, excepcionHorario.getIdSustituto());
				ps.setInt(4, excepcionHorario.getCodigoEstadoContratoSustituto());
				ps.setString(5, excepcionHorario.getColorExcepcion());								
			}
		 
			public int getBatchSize() {
				return excepcionesHorarios.size();
			}
			
		});
	}
	
		
}
