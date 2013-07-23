package com.plexus.crtvgHorarios.service.horarioService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plexus.crtvgHorarios.dataAccess.dao.horario.HorarioDao;
import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.DefinicionHorarioPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.categorias.CategoriaDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.DefinicionHorarioDto;
import com.plexus.crtvgHorarios.dto.horarios.HorarioAnualEmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.HorarioSemanaEmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.HorarioSemanaUbicacionDto;
import com.plexus.crtvgHorarios.dto.horarios.HorarioMesDto;
import com.plexus.crtvgHorarios.dto.horarios.HorasDiaDto;
//import com.plexus.crtvgHorarios.dto.horarios.RangoHorarioDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;
import com.plexus.crtvgHorarios.service.empleadoService.CategoriaPojo2CategoriaDto;


@Service("horarioService")
public class HorarioServiceImpl implements HorarioService {


	@Resource
	private HorarioDao horarioDao;
	
	@Autowired
	private Mapper mapper;	
	
	@Override
	public List<HorarioSemanaUbicacionDto> getHorariosSeccionSemana(Long idSeccion, Date semana) {
										
		// Obtener los horarios de horarioDao que cumplen el criterio de busqueda
		List<UnidadHorarioPojo> unidadesHorariosPojos = horarioDao.getUnidadesHorariosBySeccionSemana(idSeccion, semana);
		// las unidadesHorariosPojos deben estar ordenados por id_ubicacion, fecha y hora_desde para que el siguiente
		// algoritmo funcione correctamente.
		
		// Añade las UnidadHorarioPojos transformados en los HorarioSemanaUbicacionDto correspondientes a cada semana y ubicación 
		// correspondientes a las sección y semana indicadas.
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf_yearMonthWeek = new SimpleDateFormat("yyyyMMww");
		String yearMonthWeek = null;
		String idUbicacion  = null;
		HorarioSemanaUbicacionDto horarioSemanaUbicacionDto = null;
		HorasDiaDto horasDiaDto = null;
		 
		List<HorarioSemanaUbicacionDto> horariosSemanasUbicacionesDtos = new ArrayList<HorarioSemanaUbicacionDto>();
		
		if (!unidadesHorariosPojos.isEmpty()) {
			for(UnidadHorarioPojo unidadHorarioPojo: unidadesHorariosPojos) {
				
				
				if (unidadHorarioPojo.getIdHorasDia() != null) {
					
					// con el primer unidadHorarioPojo se instancia el horarioSemanaUbicacionDto con la ubicación que le corresponde (además de la categoria y semana)
					if (idUbicacion == null) {
						
						idUbicacion = unidadHorarioPojo.getIdUbicacion();
						yearMonthWeek = sdf_yearMonthWeek.format(unidadHorarioPojo.getFechaDia());
						UbicacionDto ubicacionDto = new UbicacionDto(unidadHorarioPojo);
							
						horarioSemanaUbicacionDto = new HorarioSemanaUbicacionDto(ubicacionDto, yearMonthWeek);
					}
						
					// Si la unidadHorarioPojo tratada pertenece a otra ubicación -> añadimos el horarioSemanaUbicacionDto a la lista y creamos un nuevo horarioSemanaUbicacionDto
					// (las unidadHorario están ordenadas por ubicación para que esto funcione correctamente)
					if (!unidadHorarioPojo.getIdUbicacion().equals(idUbicacion)) {
						
						horariosSemanasUbicacionesDtos.add(horarioSemanaUbicacionDto);
						
						idUbicacion = unidadHorarioPojo.getIdUbicacion();
						yearMonthWeek = sdf_yearMonthWeek.format(unidadHorarioPojo.getFechaDia());				
						UbicacionDto ubicacionDto = new UbicacionDto(unidadHorarioPojo);
							
						horarioSemanaUbicacionDto = new HorarioSemanaUbicacionDto(ubicacionDto, yearMonthWeek);
					}
				}
							
				// se mete la unidadHorario en el día que le corresponda del horarioSemanaDto tratado 							
				c.setTime(unidadHorarioPojo.getFechaDia());				
				int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // MONDAY = 2, TUESDAY = 3, WEDNESDAY = 4, THURSDAY = 5, FRIDAY = 6 ,SATURDAY = 7, SUNDAY = 1
				
				horasDiaDto = new HorasDiaDto(unidadHorarioPojo);
							
				if (horasDiaDto.getIdHorasDia() != null) {
					
					// si el día semana tratado aún no se ha inicializado se inicializa
					List<HorasDiaDto> diaSemana = horarioSemanaUbicacionDto.getDiaSemana(dayOfWeek);				
					if (diaSemana == null ){
						horarioSemanaUbicacionDto.setDiaSemana(dayOfWeek, new ArrayList<HorasDiaDto>());
					}
						 
					// inserta las horasDia en el díaSemana tratado
					horarioSemanaUbicacionDto.getDiaSemana(dayOfWeek).add(horasDiaDto);
				}
				 
				horarioSemanaUbicacionDto.setFestivoDiaSemana(dayOfWeek, horasDiaDto.getFestivo());
			
			}
			
			horariosSemanasUbicacionesDtos.add(horarioSemanaUbicacionDto);
		}
		return horariosSemanasUbicacionesDtos;		
	}


	private boolean perteneceAdefinicion(HorasDiaDto horasDia, DefinicionHorarioDto definicionHorario) {
		
		if (horasDia == null || definicionHorario == null) {
			return false;
		}
		
		if (!horasDia.getHoraDesde().equals(definicionHorario.getHoraDesde())) {
			return false;
		}
		
		if (!horasDia.getHoraHasta().equals(definicionHorario.getHoraHasta())) {
			return false;
		}
		
		if (!horasDia.getProduccion().equals(definicionHorario.getProduccion())) {
			return false;
		}
		
		if (!horasDia.getUbicacion().equals(definicionHorario.getUbicacion())) {
			return false;
		}
		
		return true;
		
	}
	

	@Override
	public HorarioMesDto getHorarioMesEmpleado(Date mesAnho, EmpleadoDto empleado, List<DefinicionHorarioDto> definicionesHorarios) {
		// Obtener los horarios de horarioDao que cumplen el criterio de busqueda
		List<UnidadHorarioPojo> unidadesHorariosPojos = horarioDao.getUnidadesHorariosByMesAnhoEmpleado(mesAnho, empleado.getIdEmpleado());
		// las unidadesHorariosPojos deben estar ordenados por fecha y hora_desde para que el siguiente
		// algoritmo funcione correctamente.
		
		// Añade las UnidadHorarioPojos transformados en los HorarioSemanaEmpleadoDto correspondientes a cada semana 

		Calendar c = Calendar.getInstance();
		
		SimpleDateFormat sdf_yearMonthWeek = new SimpleDateFormat("yyyyMMww");
		String yearMonthWeek = null;
		HorarioSemanaEmpleadoDto horarioSemanaEmpleadoDto = null;
		HorasDiaDto horasDiaDto = null;
			
		
		List<HorarioSemanaEmpleadoDto> horariosSemanasEmpleadoDtos = new ArrayList<HorarioSemanaEmpleadoDto>();
		for(UnidadHorarioPojo unidadHorarioPojo: unidadesHorariosPojos) {
						
			
			// si el día tratado pertenece a una semana distinta de la semana tratada se crea un nuevo horarioSemanaEmpleadoDto 
			if (!sdf_yearMonthWeek.format(unidadHorarioPojo.getFechaDia()).equals(yearMonthWeek)) {	
				
				if (yearMonthWeek != null)
					horariosSemanasEmpleadoDtos.add(horarioSemanaEmpleadoDto);
				
				// Crea un nuevo horarioSemanaEmpeadoDto para la nueva semana a tratar
				yearMonthWeek = sdf_yearMonthWeek.format(unidadHorarioPojo.getFechaDia());
				horarioSemanaEmpleadoDto = new HorarioSemanaEmpleadoDto(empleado, yearMonthWeek);
			}
				
			// se mete la unidadHorario en el día que le corresponda del horarioSemanaEmpleadoDto tratado
							
			c.setTime(unidadHorarioPojo.getFechaDia());				
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // MONDAY = 2, TUESDAY = 3, WEDNESDAY = 4, THURSDAY = 5, FRIDAY = 6 ,SATURDAY = 7, SUNDAY = 1
			
			horasDiaDto = new HorasDiaDto(unidadHorarioPojo);
				
			if (horasDiaDto.getIdHorasDia() != null) {
				 
				// si el diaSemana aún no se ha inicializado se inicializa
				List<HorasDiaDto> diaSemana = horarioSemanaEmpleadoDto.getDiaSemana(dayOfWeek);				
				if (diaSemana == null) {
					horarioSemanaEmpleadoDto.setDiaSemana(dayOfWeek, new ArrayList<HorasDiaDto>());
				}
					 
				horarioSemanaEmpleadoDto.getDiaSemana(dayOfWeek).add(horasDiaDto);
				
								 
				// FIXME: Cambiar en BD la tabla Horarios_horas para que guarde la relación de cada horario_hora con la definicionHorario y con el tipo de ausencia
				// o sustitución que pueda tener en ese día.				
				
				// Se comprueba si las horas del horasDiaDto tratado coincide con alguna de las definicionesHorarios y si es así se fija el color
				for(DefinicionHorarioDto definicionHorario: definicionesHorarios)
					if (perteneceAdefinicion(horasDiaDto, definicionHorario) ) {				 
					 horarioSemanaEmpleadoDto.setColorHorarioDia(dayOfWeek, definicionHorario.getColorHorario());						 
				}
				
				
			 }
				 
			 horarioSemanaEmpleadoDto.setFestivoDiaSemana(dayOfWeek, horasDiaDto.getFestivo());
			 horarioSemanaEmpleadoDto.setFechaDiaSemana(dayOfWeek, unidadHorarioPojo.getFechaDia());				 
		}
		
		horariosSemanasEmpleadoDtos.add(horarioSemanaEmpleadoDto);
				
		return new HorarioMesDto(horariosSemanasEmpleadoDtos);
	}

		
	@Override
	public HorarioAnualEmpleadoDto getHorarioAnualEmpleado(Integer anho, EmpleadoDto empleado) {

		HorarioAnualEmpleadoDto horarioAnual = new HorarioAnualEmpleadoDto(anho, empleado);	
				
		// Almacena los distintos rangos horarios encontrados para fijar el rangoHorario a asignar a cada día.
		// se va actualizando en cada llamada a los metodos this.getHorarioMes()
				
		List<DefinicionHorarioPojo> definicionesHorariosPojos = horarioDao.getDefinicionesHorarios(empleado.getIdEmpleado(), anho);
		List<DefinicionHorarioDto> definicionesHorariosDtos = new ArrayList<DefinicionHorarioDto>();
		for (DefinicionHorarioPojo definicionHorarioPojo: definicionesHorariosPojos) {
			definicionesHorariosDtos.add(new DefinicionHorarioPojo2DefinicionHorarioDto(mapper).transform(definicionHorarioPojo));
		}		
						
		horarioAnual.setDefinicionesHorarios(definicionesHorariosDtos);
		
		Calendar cal = Calendar.getInstance();
					
		//Rellena el horarioAnual empleado para cada mes del año
		for (int i = Calendar.JANUARY; i <= Calendar.DECEMBER; i++) {			
			cal.set(anho, i, 1);			
			horarioAnual.setMes(i, this.getHorarioMesEmpleado(cal.getTime(), empleado, definicionesHorariosDtos));			
		}						
		
		return horarioAnual;
		
	}



	@Override
	public HorarioAnualEmpleadoDto actualizarDefinicionHorario(DefinicionHorarioDto definicionHorario, HorarioAnualEmpleadoDto horarioAnual) {
		
		Calendar cal = Calendar.getInstance();
				
		cal.setTime(definicionHorario.getFechaDesde());		
		int mesIniRango = cal.get(Calendar.MONTH); 
		
		cal.clear();
		cal.setTime(definicionHorario.getFechaHasta());		
		int mesFinRango = cal.get(Calendar.MONTH);
		
		if (horarioAnual.getDefinicionesHorarios() == null) {
				horarioAnual.setDefinicionesHorarios(new ArrayList<DefinicionHorarioDto>());				
		}
			
		// TODO: si hay un rango horario ya definido con el mismo horario que se hace?				
				
		boolean esPrimerMes = true;
		boolean esUltimoMes = false;
				
		// desde mesIniRango hasta el mesFinRango inserta en los meses la nueva definicionHorario si no está ya entre los definiciones de horario ya definidas
		for  (int mes = mesIniRango; mes <= mesFinRango; mes++) {
			
			// Inserta en el mes correspondiente			
			HorarioMesDto horarioMes = horarioAnual.getMes(mes);							
			
			if (mesFinRango == mes )
				esUltimoMes = true;
			
			actualizarDefinicionHorarioEnMes(horarioAnual.getEmpleado(), definicionHorario, horarioMes, esPrimerMes, esUltimoMes, mes);				
			
			esPrimerMes = false;			
		}

		// anhade el nuevo rango horario en la lista de definicionesHorarios
		horarioAnual.getDefinicionesHorarios().add(definicionHorario);
				
		return horarioAnual;
	}
	
	
	/**
	 * 
	 * @param definicionHorario
	 * @param fechaSemana
	 * @return true si se ha de aplicar la definicion a la semana indicada según los criterios de alternancia
	 */
	private boolean aplicarDefinicionSegunAlternancias(DefinicionHorarioDto definicionHorario, Date fechaSemana) {
		
		// si no está definida ninguna alternancia entonces si se aplicará la definicion del horario a la semana tratada
		if (definicionHorario.getNumSemanasAlternancia() != null && definicionHorario.getNumSemanasAlternancia() !=0) {

			
			Calendar cal = Calendar.getInstance();			
			cal.setTime(definicionHorario.getFechaDesde());			
			int numSemanaInicioDefinicionRelativoAnho = cal.get(Calendar.WEEK_OF_YEAR);
			
			cal.setTime(fechaSemana);
			int numSemanaRelativoAnho = cal.get(Calendar.WEEK_OF_YEAR);
			
			// numSemanaRelativoDefinicion contiene el numero de la semana tomando como primera semana la primera semana indicada en la definicion del horario
			int numSemanaRelativoDefinicion = numSemanaRelativoAnho - numSemanaInicioDefinicionRelativoAnho + 1;
					
			if (numSemanaRelativoDefinicion % definicionHorario.getNumSemanasAlternancia() == 0) {
				return true;
			}
				return false;
				
		}		
		
		return true;		
	}
	
	
	/**
	 * Inserta el rangoHorarioDefinido en el mes a tratar
	 */
	private void actualizarDefinicionHorarioEnMes(EmpleadoDto empleado, DefinicionHorarioDto definicionHorario, 
			HorarioMesDto horarioMes, boolean esPrimerMes, boolean esUltimoMes, int mes) {
		
		Date horaDesde = definicionHorario.getHoraDesde();
		Date horaHasta = definicionHorario.getHoraHasta();
		UbicacionDto ubicacion = definicionHorario.getUbicacion();
		ProduccionDto produccion = definicionHorario.getProduccion();		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(definicionHorario.getFechaDesde());
		int dayOfWeek_fechaIniRango = cal.get(Calendar.DAY_OF_WEEK); // MONDAY = 2, TUESDAY = 3, WEDNESDAY = 4, THURSDAY = 5, FRIDAY = 6 ,SATURDAY = 7, SUNDAY = 1		
		
		boolean esPrimeraSemanaTratada= true;
		
		SimpleDateFormat sdf_yearMonthWeek = new SimpleDateFormat("yyyyMMww");
		String yearMonthWeek_semanaFinRango = sdf_yearMonthWeek.format(definicionHorario.getFechaHasta());
				
		cal.setTime(definicionHorario.getFechaHasta());
		int dayOfWeek_fechaFinRango = cal.get(Calendar.DAY_OF_WEEK);
				
		ArrayList<Integer> diasSemana = new ArrayList<Integer>(); // Contiene los dias de la semana tal como los representa java.util.Calendar
		diasSemana.add(2);
		diasSemana.add(3);
		diasSemana.add(4);
		diasSemana.add(5);
		diasSemana.add(6);
		diasSemana.add(7);
		diasSemana.add(1);		
		
		int[] diaSemana = {2,3,4,5,6,7,1}; // Contiene los dias de la semana tal como los representa java.util.Calendar
		
		// la variable yearMonthWeek se seteará con el valor de la semana cada horario que se inserte para poder finalizar la iteración sobre las semanas en cuanto se detecte que la
		// semanaTratada es igual que la semana del fin de rango.
		String yearMonthWeek = "";
				
		
		// si el horario se define para semanas alternas la primera semana se insertará y se omitirá insertar la siguiente y así sucesivamente
		
		// Para cada semana inserta el rango horario en el día correspondiente según el patron definido.
		for (HorarioSemanaEmpleadoDto semana: horarioMes.getSemanas()) {
						
			// para evitar comparar dias de la semana anteriores al día de la semana con la que comienza el rangoHorario definido
			// para la primera semana tratada del primer mes se empieza en el día en el día de la semana correspondiente al incicio del rango horario definido
			if (esPrimerMes && esPrimeraSemanaTratada) {
				
				for (int i= diasSemana.indexOf(dayOfWeek_fechaIniRango); i<= 6; i++)  {
					
					if (semana.getFechaDiaSemana(diaSemana[i]).compareTo(definicionHorario.getFechaDesde()) >= 0 && 
							semana.getFechaDiaSemana(diaSemana[i]).compareTo(definicionHorario.getFechaHasta()) <=0) {
						
						List<HorasDiaDto> horariosDia = new ArrayList<HorasDiaDto>();
						horariosDia= semana.getDiaSemana(diaSemana[i]);
						
						// Si el empleado no tenía horario horarioDia será null por lo que se inicializará a una lista vacía
						if (horariosDia == null) {
							horariosDia = new ArrayList<HorasDiaDto>();
							semana.setDiaSemana(diaSemana[i], horariosDia);
						}
						
						Boolean festivo = semana.getFestivoDiaSemana(diaSemana[i]);

						if (definicionHorario.aplicarDiaSemana(diaSemana[i])) {							
							horariosDia.add(new HorasDiaDto(empleado, semana.getFechaDiaSemana(diaSemana[i]), festivo, horaDesde, horaHasta, ubicacion, produccion));
							semana.setColorHorarioDia(diaSemana[i],definicionHorario.getColorHorario());
							yearMonthWeek = sdf_yearMonthWeek.format(semana.getFechaDiaSemana(diaSemana[i]));
						}
					}										
				}
				
				esPrimeraSemanaTratada = false;
			}
			else { // si no es la primera semana del rango
				
				if (aplicarDefinicionSegunAlternancias(definicionHorario, semana.getFechaSemana()) ) {
							
					// para evitar comparar días de la semana posteriores al día de la semana con el que finaliza el rangoHorario definido
					// para la última semana se finaliza la iteración en el día en el día de la semana correspondiente al fin del rango horario definido
					// si es últimoMes y la semana tratada es igual a la última semana del rango indicado..
					if (esUltimoMes && semana.getYearMonthWeek().equals(yearMonthWeek_semanaFinRango)) {  
											
						for (int i= 0; i <= 6; i++) {
	
							// Si el día no contiene fecha, por ejemplo por que es la primera semana de un mes que comienza en miercoles -> el lunes y martes 
							// tendrán fecha a null
							if (semana.getFechaDiaSemana(diaSemana[i]) == null) {
								continue;
							}
							
							// si la fecha del lunes es mayor o igual que la del inicio del rangoHorario y menor o igual que la fecha de fin del rango-> inserta el rango horario en el día			
							if (semana.getFechaDiaSemana(diaSemana[i]).compareTo(definicionHorario.getFechaDesde()) >= 0 && 
									semana.getFechaDiaSemana(diaSemana[i]).compareTo(definicionHorario.getFechaHasta()) <=0) {
								
								List<HorasDiaDto> horariosDia = new ArrayList<HorasDiaDto>();
								horariosDia = semana.getDiaSemana(diaSemana[i]);
								
								// Si el empleado no tenía horario horarioDia será null por lo que se inicializará a una lista vacía
								if (horariosDia == null) {
									horariosDia = new ArrayList<HorasDiaDto>();
									semana.setDiaSemana(diaSemana[i], horariosDia);
								}
								
								Boolean festivo = semana.getFestivoDiaSemana(diaSemana[i]);
								
								if (definicionHorario.aplicarDiaSemana(diaSemana[i])) {								
									horariosDia.add(new HorasDiaDto(empleado, semana.getFechaDiaSemana(diaSemana[i]), festivo, horaDesde, horaHasta, ubicacion, produccion));
									semana.setColorHorarioDia(diaSemana[i],definicionHorario.getColorHorario());
									yearMonthWeek = sdf_yearMonthWeek.format(semana.getFechaDiaSemana(diaSemana[i]));
								}
								
								if (diaSemana[i] == dayOfWeek_fechaFinRango)
									break;
	
							}
													
						}
						
					}
					else { // para aquellas semanas que no sean ni la primera del rango definido ni la última...
										
						
						for (int i= 0; i <= 6; i++) {
							
							
							//sí el día de la semana tratado es del siguiente mes salimos de la iteración
							// Aquellas semanas que acaban en el siguiente mes tienen las fechas de los días del mes siguiente a null
							if (semana.getFechaDiaSemana(diaSemana[i]) == null) continue;						 						
							//cal.setTime(semana.getFechaDiaSemana(diaSemana[i]));
							//if (cal.get(Calendar.MONTH) != mes) break;
							
						
							// si la fecha del lunes es mayor o igual que la del inicio del rangoHorario y menor o igual que la fecha de fin del rango-> inserta el rango horario en el día			
							if (semana.getFechaDiaSemana(diaSemana[i]).compareTo(definicionHorario.getFechaDesde()) >= 0 && 
									semana.getFechaDiaSemana(diaSemana[i]).compareTo(definicionHorario.getFechaHasta()) <=0) {
								
								List<HorasDiaDto> horariosDia = new ArrayList<HorasDiaDto>();
								horariosDia = semana.getDiaSemana(diaSemana[i]);
								
								// Si el empleado no tenía horario horarioDia será null por lo que se inicializará a una lista vacía
								if (horariosDia == null) {
									horariosDia = new ArrayList<HorasDiaDto>();
									semana.setDiaSemana(diaSemana[i], horariosDia);
								}							
								
								Boolean festivo = semana.getFestivoDiaSemana(diaSemana[i]);
												
								if (definicionHorario.aplicarDiaSemana(diaSemana[i])) {
									horariosDia.add(new HorasDiaDto(empleado, semana.getFechaDiaSemana(diaSemana[i]), festivo, horaDesde, horaHasta, ubicacion, produccion));
									semana.setColorHorarioDia(diaSemana[i],definicionHorario.getColorHorario());
									yearMonthWeek = sdf_yearMonthWeek.format(semana.getFechaDiaSemana(diaSemana[i]));
								}
							}
						}
			
					}
					
				} // si se aplica la definicion a semanas alternas y es una semana a aplicar
				
			} // else no es primera semana rango
			
			
			if (yearMonthWeek.equals(yearMonthWeek_semanaFinRango)) {
				break;
			}
			
		} // for para cada semana
	}



	@Override
	@Transactional
	public void saveHorarioAnualEmpleado(HorarioAnualEmpleadoDto horarioAnual, String idEmpleado) {
		
		// TODO posibles validaciones previas???
		
				
		// Guarda las nuevas definicionesHorario del empleado y año indicados
		
		horarioDao.deleteAllDefinicionesHorariosAnho(idEmpleado, horarioAnual.getAnho());
				
		List<DefinicionHorarioPojo> definicionesHorariosPojos = new ArrayList<DefinicionHorarioPojo>();
		for (DefinicionHorarioDto definicionHorarioDto: horarioAnual.getDefinicionesHorarios()) {
			definicionesHorariosPojos.add(new DefinicionHorarioDto2DefinicionHorarioPojo(mapper).transform(definicionHorarioDto));			
		}
				
		horarioDao.insertDefinicionesHorarios(definicionesHorariosPojos);
		
		// Guarda las nuevas unidadesHorarios del empleado y año indicados
		horarioDao.deleteAllUnidadesHorariosAnho(idEmpleado, horarioAnual.getAnho());
		
		List<UnidadHorarioPojo> unidadesHorariosPojos = new ArrayList<UnidadHorarioPojo>();
		
		for (HorarioMesDto horarioMes: horarioAnual.getMesesAnho()) {
			
			for (HorarioSemanaEmpleadoDto horarioSemanaEmpleado: horarioMes.getSemanas()) {
			
				/// bucle for horarioSemanaEmpleado.getDias()
				for (List<HorasDiaDto> horariosDia :horarioSemanaEmpleado.getDiasSemana()) {
					
					// los horariosDia puede ser null para los días no definidos del calendario, primeros días de 1era semana enero que pertenecen a diciembre del año anterior 
					// y últimos dias de última semana de diciembre que pertenecen a enero del siguiente año
					if (horariosDia != null) {
						for (HorasDiaDto horasDia: horariosDia) {
						
							UnidadHorarioPojo unidadHorarioPojo = (new HorasDiaDto2UnidadHorarioPojo(horasDia)).getUnidadHorarioPojo();												
							unidadesHorariosPojos.add(unidadHorarioPojo);
						}
					}										
				}								
			}			
		}
					
		horarioDao.insertUnidadesHorarios(unidadesHorariosPojos);	
		
	}
	
	
	
}
