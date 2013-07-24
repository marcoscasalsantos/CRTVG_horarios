package com.plexus.crtvgHorarios.dataAccess.pojo;

import java.util.Date;
import java.util.Set;

import com.plexus.crtvgHorarios.dataAccess.pojo.common.BasePojo;

public class UnidadHorarioPojo extends BasePojo {
	
	/**
	 * Cada objeto UnidadHorarioPojo contiene una relación mínima "empleado-horas-ubicación" de un determinado día de un determinado
	 * horario_ubicacion.  
	 * 	 
	 */
	private static final long serialVersionUID = 1L;
			
	// Horarios_horas
	private Long idHorasDia;	
	private Date fechaDia;
	private Date horaDesde;
	private Date horaHasta;
	private String idUbicacion;
	private String idEmpleado;	
	private String idProduccion;
	private Long idSeccion;
	private Long idDefinicionHorario;
	private Long idExcepcionHorario;
		
	// Festivos
	private Long idFestivo;
	private Boolean festivo;
	private String festividad;	

	// Ubicaciones	
	private String nombreUbicacion;
	private String fase;
	
	// empleados
	private String nombreEmpleado;
	private String apellido1Empleado;
	private String apellido2Empleado;
	private String categoria;
	
	// sustituto
	private String nombreSustituto;
	private String apellido1Sustituto;
	private String apellido2Sustituto;
	
	// produccion
	private String nombreProduccion;
	private String familiaProduccion;
		
	// secciones
	private String nombreSeccion;
	
	// definiciones
	private String colorHorario;
	
	// excepciones
	private String idEstado;
	private String idSustituto;		
	private String descripcionExcepcion;
	private Integer estadoContrato;
	
	// Estado
	private String descripcionEstado; 
	
	
	public Long getIdHorasDia() {
		return idHorasDia;
	}
	public void setIdHorasDia(Long idHorasDia) {
		this.idHorasDia = idHorasDia;
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
	public String getIdSustituto() {
		return idSustituto;
	}
	public void setIdSustituto(String idSustituto) {
		this.idSustituto = idSustituto;
	}
	public String getIdProduccion() {
		return idProduccion;
	}
	public void setIdProduccion(String idProduccion) {
		this.idProduccion = idProduccion;
	}
	public Long getIdFestivo() {
		return idFestivo;
	}
	public void setIdFestivo(Long idFestivo) {
		this.idFestivo = idFestivo;
	}
	public Boolean getFestivo() {
		return festivo;
	}
	public void setFestivo(Boolean festivo) {
		this.festivo = festivo;
	}
	public String getFestividad() {
		return festividad;
	}
	public void setFestividad(String festividad) {
		this.festividad = festividad;
	}
	public String getNombreUbicacion() {
		return nombreUbicacion;
	}
	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNombreSustituto() {
		return nombreSustituto;
	}
	public void setNombreSustituto(String nombreSustituto) {
		this.nombreSustituto = nombreSustituto;
	}

	public String getApellido1Empleado() {
		return apellido1Empleado;
	}
	public void setApellido1Empleado(String apellido1Empleado) {
		this.apellido1Empleado = apellido1Empleado;
	}
	public String getApellido2Empleado() {
		return apellido2Empleado;
	}
	public void setApellido2Empleado(String apellido2Empleado) {
		this.apellido2Empleado = apellido2Empleado;
	}
	public String getApellido1Sustituto() {
		return apellido1Sustituto;
	}
	public void setApellido1Sustituto(String apellido1Sustituto) {
		this.apellido1Sustituto = apellido1Sustituto;
	}
	public String getApellido2Sustituto() {
		return apellido2Sustituto;
	}
	public void setApellido2Sustituto(String apellido2Sustituto) {
		this.apellido2Sustituto = apellido2Sustituto;
	}
	public String getNombreProduccion() {
		return nombreProduccion;
	}
	public void setNombreProduccion(String nombreProduccion) {
		this.nombreProduccion = nombreProduccion;
	}
	public String getFamiliaProduccion() {
		return familiaProduccion;
	}
	public void setFamiliaProduccion(String familiaProduccion) {
		this.familiaProduccion = familiaProduccion;
	}
	public Long getIdSeccion() {
		return idSeccion;
	}
	public void setIdSeccion(Long idSeccion) {
		this.idSeccion = idSeccion;
	}

	public String getNombreSeccion() {
		return nombreSeccion;
	}
	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}
	public String getColorHorario() {
		return colorHorario;
	}
	public void setColorHorario(String colorHorario) {
		this.colorHorario = colorHorario;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	public String getDescripcionExcepcion() {
		return descripcionExcepcion;
	}
	public void setDescripcionExcepcion(String descripcionExcepcion) {
		this.descripcionExcepcion = descripcionExcepcion;
	}
	public Integer getEstadoContrato() {
		return estadoContrato;
	}
	public void setEstadoContrato(Integer estadoContrato) {
		this.estadoContrato = estadoContrato;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	public Long getIdDefinicionHorario() {
		return idDefinicionHorario;
	}
	public void setIdDefinicionHorario(Long idDefinicionHorario) {
		this.idDefinicionHorario = idDefinicionHorario;
	}
	public Long getIdExcepcionHorario() {
		return idExcepcionHorario;
	}
	public void setIdExcepcionHorario(Long idExcepcionHorario) {
		this.idExcepcionHorario = idExcepcionHorario;
	}

	
	
}
