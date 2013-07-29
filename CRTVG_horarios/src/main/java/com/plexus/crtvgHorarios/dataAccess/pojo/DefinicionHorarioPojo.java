package com.plexus.crtvgHorarios.dataAccess.pojo;

import java.util.Date;

import com.plexus.crtvgHorarios.dataAccess.pojo.common.BasePojo;

public class DefinicionHorarioPojo extends BasePojo {
	
	/**
	 * Cada objeto DefinicionHorarioPojo contiene la definición de un horario para un perido de tiempo (normalmente dentro de un año)  
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
	
	private Date horaDesde;
	private Date horaHasta;
	private String idUbicacion;
	private String idEmpleado;
	private String idProduccion;
	private String colorHorario;
	
	private String nombreUbicacion;
	private String nombreProduccion;
	
	public Long getIdDefinicionHorario() {
		return idDefinicionHorario;
	}
	public void setIdDefinicionHorario(Long idDefinicionHorario) {
		this.idDefinicionHorario = idDefinicionHorario;
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
	public String getColorHorario() {
		return colorHorario;
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
	public String getIdUbicacion() {
		return idUbicacion;
	}
	public void setIdUbicacion(String idUbicacion) {
		this.idUbicacion = idUbicacion;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getIdProduccion() {
		return idProduccion;
	}
	public void setIdProduccion(String idProduccion) {
		this.idProduccion = idProduccion;
	}
	public Integer getNumSemanasAlternancia() {
		return numSemanasAlternancia;
	}
	public void setNumSemanasAlternancia(Integer numSemanasAlternancia) {
		this.numSemanasAlternancia = numSemanasAlternancia;
	}
	public String getNombreUbicacion() {
		return nombreUbicacion;
	}
	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}
	public String getNombreProduccion() {
		return nombreProduccion;
	}
	public void setNombreProduccion(String nombreProduccion) {
		this.nombreProduccion = nombreProduccion;
	}

	
	
}
