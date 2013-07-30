package com.plexus.crtvgHorarios.dto.horarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;

public class HorasDiaDto extends BaseDto implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private DiaSemanaEnum diaSemana; // no hace falta
	
	private Long idHorasDia;
	
	private EmpleadoDto empleado;
	private EmpleadoDto empleadoSustituto;
	
	private Date fechaDia;
	private Boolean festivo;
	
	private Date horaDesde;
	private Date horaHasta;
	
	private ProduccionDto produccion;
	private UbicacionDto ubicacion;
	private DefinicionHorarioDto definicionHorario;
	private ExcepcionHorarioDto excepcionHorario;
	
	public HorasDiaDto() {
		super();
	}
	
	
	
	public HorasDiaDto(UnidadHorarioPojo unidadHorarioPojo) {
		super();
		
		this.setIdHorasDia(unidadHorarioPojo.getIdHorasDia());
		
		EmpleadoDto empleadoDto = new EmpleadoDto();
		empleadoDto.setIdEmpleado(unidadHorarioPojo.getIdEmpleado());
		empleadoDto.setNombre(unidadHorarioPojo.getNombreEmpleado());
		empleadoDto.setApellido1(unidadHorarioPojo.getApellido1Empleado());				
		empleadoDto.setApellido2(unidadHorarioPojo.getApellido2Empleado());
		this.setEmpleado(empleadoDto);
		
		if (unidadHorarioPojo.getIdSustituto() != null) {
			EmpleadoDto sustitutoDto = new EmpleadoDto();
			sustitutoDto.setIdEmpleado(unidadHorarioPojo.getIdSustituto());
			sustitutoDto.setNombre(unidadHorarioPojo.getNombreSustituto());
			sustitutoDto.setApellido1(unidadHorarioPojo.getApellido1Sustituto());				
			sustitutoDto.setApellido2(unidadHorarioPojo.getApellido2Sustituto());
			this.setEmpleadoSustituto(sustitutoDto);
		}
		
		this.setFechaDia(unidadHorarioPojo.getFechaDia());
		this.setFestivo(unidadHorarioPojo.getFestivo());
		
		this.setHoraDesde(unidadHorarioPojo.getHoraDesde());
		this.setHoraHasta(unidadHorarioPojo.getHoraHasta());
						
		ProduccionDto produccionDto = new ProduccionDto();
		produccionDto.setIdProduccion(unidadHorarioPojo.getIdProduccion());
		produccionDto.setNombreProduccion(unidadHorarioPojo.getNombreProduccion());
		this.setProduccion(produccionDto);
		
		UbicacionDto ubicacionDto = new UbicacionDto();
		ubicacionDto.setFase(unidadHorarioPojo.getFase());
		ubicacionDto.setIdUbicacion(unidadHorarioPojo.getIdUbicacion());
		ubicacionDto.setNombreUbicacion(unidadHorarioPojo.getNombreUbicacion());
		this.setUbicacion(ubicacionDto);
		
		if (unidadHorarioPojo.getIdDefinicionHorario() != null) {
			DefinicionHorarioDto definicionHorario = new DefinicionHorarioDto(unidadHorarioPojo); 
			this.setDefinicionHorario(definicionHorario);
		}
		
		if (unidadHorarioPojo.getIdExcepcionHorario() != null) {
			ExcepcionHorarioDto excepcionHorario = new ExcepcionHorarioDto(unidadHorarioPojo);
			this.setExcepcionHorario(excepcionHorario);
		}
	}

	public HorasDiaDto(EmpleadoDto empleado, Date fechaDia, Boolean festivo, Date horaDesde, Date horaHasta, UbicacionDto ubicacion, ProduccionDto produccion, DefinicionHorarioDto definicionHorario) {
		this.setEmpleado(empleado);
		this.setFechaDia(fechaDia);
		this.setHoraDesde(horaDesde);
		this.setHoraHasta(horaHasta);
		this.setUbicacion(ubicacion);
		this.setProduccion(produccion);
		this.setFestivo(festivo);
		this.setDefinicionHorario(definicionHorario);
	}
	
	
	public int getDiaSemana() {		
		Calendar c = Calendar.getInstance();
		c.setTime(this.getFechaDia());
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}
	
	public Long getIdHorasDia() {
		return idHorasDia;
	}

	public void setIdHorasDia(Long idHorasDia) {
		this.idHorasDia = idHorasDia;
	}

	public EmpleadoDto getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoDto empleado) {
		this.empleado = empleado;
	}

	public EmpleadoDto getEmpleadoSustituto() {
		return empleadoSustituto;
	}

	public void setEmpleadoSustituto(EmpleadoDto empleadoSustituto) {
		this.empleadoSustituto = empleadoSustituto;
	}

	public Date getFechaDia() {
		return fechaDia;
	}

	public void setFechaDia(Date fechaDia) {
		this.fechaDia = fechaDia;
	}

	public Date getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(Date horaDesde) {
		this.horaDesde = horaDesde;
	}

	public Date getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(Date horaHasta) {
		this.horaHasta = horaHasta;
	}

	public ProduccionDto getProduccion() {
		return produccion;
	}

	public void setProduccion(ProduccionDto produccion) {
		this.produccion = produccion;
	}


	public Boolean getFestivo() {
		return festivo;
	}


	public void setFestivo(Boolean festivo) {
		this.festivo = festivo;
	}	
	

	
	
	public UbicacionDto getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(UbicacionDto ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	public ExcepcionHorarioDto getExcepcionHorario() {
		return excepcionHorario;
	}



	public DefinicionHorarioDto getDefinicionHorario() {
		return definicionHorario;
	}



	public void setDefinicionHorario(DefinicionHorarioDto definicionHorario) {
		this.definicionHorario = definicionHorario;
	}



	public void setExcepcionHorario(ExcepcionHorarioDto excepcionHorario) {
		this.excepcionHorario = excepcionHorario;
	}


	@Override
	public HorasDiaDto clone() {		
		HorasDiaDto horasDia = new HorasDiaDto();
		
		if (this.getEmpleado() != null)
			horasDia.setEmpleado(this.getEmpleado().clone());
		
		if (this.getEmpleadoSustituto() != null)
			horasDia.setEmpleadoSustituto(this.getEmpleadoSustituto().clone());
		
		if (this.getFechaDia() != null)
			horasDia.setFechaDia((Date) this.getFechaDia().clone());
		
		horasDia.setFestivo(this.getFestivo());
		
		if (this.getHoraDesde() != null)
			horasDia.setHoraDesde((Date) this.getHoraDesde().clone());
		
		if (this.getHoraHasta() != null)
			horasDia.setHoraHasta((Date) this.getHoraHasta().clone());
		
		horasDia.setIdHorasDia(this.getIdHorasDia());
		
		if (this.getProduccion() != null)
			horasDia.setProduccion(this.getProduccion().clone());
		
		if (this.getUbicacion() != null)
			horasDia.setUbicacion(this.getUbicacion().clone());
		
		if (this.getExcepcionHorario() != null)
			horasDia.setExcepcionHorario(this.getExcepcionHorario().clone());
				
		return horasDia;
	}
	
}
