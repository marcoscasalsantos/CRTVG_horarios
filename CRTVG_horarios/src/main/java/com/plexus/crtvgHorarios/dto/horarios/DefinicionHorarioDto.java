package com.plexus.crtvgHorarios.dto.horarios;

import java.util.Calendar;
import java.util.Date;

import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;

public class DefinicionHorarioDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private Long idDefinicionHorario;
	
	private Date fechaDesde;

	private Date fechaHasta;
	
	private boolean aplicarLunes;
	private boolean aplicarMartes;
	private boolean aplicarMiercoles;
	private boolean aplicarJueves;
	private boolean aplicarViernes;
	private boolean aplicarSabado;
	private boolean aplicarDomingo;
	
	private Integer numSemanasAlternancia;
	
	private String colorHorario; // Color identificativo del rango horario
	
	private Date horaDesde;
	private Date horaHasta;
	
	private EmpleadoDto empleado;
	private UbicacionDto ubicacion;
	private ProduccionDto produccion;

	public DefinicionHorarioDto() {
		super();
		//this.rangoHorario = new RangoHorarioDto();
		// TODO Auto-generated constructor stub
	}
	
	public DefinicionHorarioDto(UnidadHorarioPojo unidadHorarioPojo) {
		this.setIdDefinicionHorario(unidadHorarioPojo.getIdDefinicionHorario());
	}

	
	public DefinicionHorarioDto(EmpleadoDto empleado) {
		super();
		this.empleado = empleado;
	}




	public boolean aplicarDiaSemana(int diaSemana) {
		
		switch (diaSemana) {		
			case Calendar.MONDAY: return aplicarLunes;
			case Calendar.TUESDAY: return aplicarMartes;
			case Calendar.WEDNESDAY: return aplicarMiercoles;
			case Calendar.THURSDAY: return aplicarJueves;
			case Calendar.FRIDAY: return aplicarViernes;
			case Calendar.SATURDAY: return aplicarSabado;
			case Calendar.SUNDAY: return aplicarDomingo;
		}		
		return false;
	}
	
	
	

	public Date getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public Date getFechaHasta() {
		return fechaHasta;
	}


	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	public boolean isAplicarLunes() {
		return aplicarLunes;
	}


	public void setAplicarLunes(boolean aplicarLunes) {
		this.aplicarLunes = aplicarLunes;
	}


	public boolean isAplicarMartes() {
		return aplicarMartes;
	}


	public void setAplicarMartes(boolean aplicarMartes) {
		this.aplicarMartes = aplicarMartes;
	}


	public boolean isAplicarMiercoles() {
		return aplicarMiercoles;
	}


	public void setAplicarMiercoles(boolean aplicarMiercoles) {
		this.aplicarMiercoles = aplicarMiercoles;
	}


	public boolean isAplicarJueves() {
		return aplicarJueves;
	}


	public void setAplicarJueves(boolean aplicarJueves) {
		this.aplicarJueves = aplicarJueves;
	}


	public boolean isAplicarViernes() {
		return aplicarViernes;
	}


	public void setAplicarViernes(boolean aplicarViernes) {
		this.aplicarViernes = aplicarViernes;
	}


	public boolean isAplicarSabado() {
		return aplicarSabado;
	}


	public void setAplicarSabado(boolean aplicarSabado) {
		this.aplicarSabado = aplicarSabado;
	}


	public boolean isAplicarDomingo() {
		return aplicarDomingo;
	}


	public void setAplicarDomingo(boolean aplicarDomingo) {
		this.aplicarDomingo = aplicarDomingo;
	}


	public Long getIdDefinicionHorario() {
		return idDefinicionHorario;
	}


	public void setIdDefinicionHorario(Long idDefinicionHorario) {
		this.idDefinicionHorario = idDefinicionHorario;
	}


	public String getColorHorario() {
		return colorHorario;
	}
	
	public String getHexColorHorario() {
		if (colorHorario == null)
			return "";
		
		return "#" + colorHorario;
	}


	public void setColorHorario(String colorHorario) {
		this.colorHorario = colorHorario;
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


	public UbicacionDto getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(UbicacionDto ubicacion) {
		this.ubicacion = ubicacion;
	}

	public ProduccionDto getProduccion() {
		return produccion;
	}

	public void setProduccion(ProduccionDto produccion) {
		this.produccion = produccion;
	}


	public EmpleadoDto getEmpleado() {
		return empleado;
	}


	public void setEmpleado(EmpleadoDto empleado) {
		this.empleado = empleado;
	}




	public Integer getNumSemanasAlternancia() {
		return numSemanasAlternancia;
	}




	public void setNumSemanasAlternancia(Integer numSemanasAlternancia) {
		this.numSemanasAlternancia = numSemanasAlternancia;
	}

	

}
