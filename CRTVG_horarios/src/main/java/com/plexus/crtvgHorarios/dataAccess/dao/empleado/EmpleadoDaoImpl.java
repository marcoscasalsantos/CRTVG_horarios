package com.plexus.crtvgHorarios.dataAccess.dao.empleado;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

import com.plexus.crtvgHorarios.dataAccess.dao.common.BaseDao;
import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.EmpleadoPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.ProduccionPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.SeccionPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UbicacionPojo;

@Repository
public class EmpleadoDaoImpl extends BaseDao implements EmpleadoDao {

    private static final Logger LOG = Logger.getLogger(EmpleadoDaoImpl.class.getName());
    
    private static final String SQL_SELECT_ALL_CATEGORIAS = 
    		" SELECT DISTINCT(categoria) FROM traballadores" +
    		" order by categoria asc "; 
    
    private static final String SQL_SELECT_ALL_SECCIONES = 
    		" SELECT id_seccion as idSeccion, nome_seccion as nombreSeccion FROM seccions" +
    		" order by nombreSeccion asc ";     
    
    private static final String SQL_SELECT_ALL_UBICACIONES = 
    		" select codigo as idUbicacion, descricion as nombreUbicacion, fase " +
    		" from ubicacions " +
    		" order by nombreUbicacion ";
    
    private static final String SQL_SELECT_ALL_PRODUCCIONES = 
    		" select codigo as idProduccion, descricion as nombreProduccion, familia as familiaProduccion " +
    		" from produccions " +
    		" order by nombreProduccion ";
    
    private static final String SQL_SELECT_ALL_EMPLEADOS =
    		" SELECT dni as idTraballador, nome as nombre, apelido1 as apellido1, apelido2 as apellido2, categoria as idCategoria " +
    		" FROM traballadores " + 
    		" order by nombre, apellido1, apellido2 ";
    
    private static final String SQL_SELECT_ALL_EMPLEADOS_BY_ID_CATEGORIA =
    		" SELECT dni as idEmpleado, nome as nombre, apelido1 as apellido1, apelido2 as apellido2, categoria as idCategoria " +
    		" FROM traballadores " + 
    		" where categoria = ? " +
    		" order by nombre, apellido1, apellido2 ";
    	
    private static final String SQL_SELECT_ANHO_INI_HORARIOS =
    		" select to_char(min(fecha_dia),'yyyy') as anho from horarios_horas where id_traballador = ? ";
    
    private static final String SQL_SELECT_ANHO_FIN_HORARIOS =
    		" select to_char(max(fecha_dia),'yyyy') as anho from horarios_horas where id_traballador = ? ";
    
    
    
    
	@Override
	public List<CategoriaPojo> getAllCategorias() {
		
		List<CategoriaPojo> categorias;
		
		categorias = super.jdbcTemplate.query(SQL_SELECT_ALL_CATEGORIAS, new CategoriaRowMapper());		
		
		return categorias;
	}
	
	
	@Override
	public List<SeccionPojo> getAllSecciones() {
		
		List<SeccionPojo> secciones;
		
		secciones = super.jdbcTemplate.query(SQL_SELECT_ALL_SECCIONES, new SeccionRowMapper());		
		
		return secciones;
	}	
	
	@Override
	public List<UbicacionPojo> getAllUbicaciones() {
		
		List<UbicacionPojo> ubicaciones;
		
		ubicaciones = super.jdbcTemplate.query(SQL_SELECT_ALL_UBICACIONES, new UbicacionRowMapper());		
		
		return ubicaciones;
	}	
	
	@Override
	public List<ProduccionPojo> getAllProducciones() {
		
		List<ProduccionPojo> producciones;
		
		producciones = super.jdbcTemplate.query(SQL_SELECT_ALL_PRODUCCIONES,  new ProduccionRowMapper());
		
		return producciones;
	}	
	

	@Override
	public List<EmpleadoPojo> getAllEmpleados() {
		List<EmpleadoPojo> empleados;
		
		empleados = super.jdbcTemplate.query(SQL_SELECT_ALL_EMPLEADOS, new EmpleadoRowMapper());		
		
		return empleados;
	}

	@Override
	public Integer getAnhoIniHorarios(String idEmpleado) {
			
		Object[] args = {idEmpleado};
		
		return (Integer) super.jdbcTemplate.queryForObject(SQL_SELECT_ANHO_INI_HORARIOS, args, Integer.class);
	}

	@Override
	public Integer getAnhoFinHorarios(String idEmpleado) {
		Object[] args = {idEmpleado};
		
		return (Integer) super.jdbcTemplate.queryForObject(SQL_SELECT_ANHO_FIN_HORARIOS, args, Integer.class);
	}

	@Override
	public List<EmpleadoPojo> getAllEmpleadosByIdCategoria(String idCategoria) {
		
		List<EmpleadoPojo> empleados;
		
		Object[] args = {idCategoria};
		
		empleados = super.jdbcTemplate.query(SQL_SELECT_ALL_EMPLEADOS_BY_ID_CATEGORIA, args, new EmpleadoRowMapper());		
		
		return empleados;
	}
	
	
    
}
