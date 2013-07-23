package com.plexus.crtvgHorarios.dataAccess.pojo;

import com.plexus.crtvgHorarios.dataAccess.pojo.common.BasePojo;

public class EmpleadoPojo extends BasePojo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idEmpleado; // Es el dni del empleado, pues si!!	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String idCategoria; // el id de la categoría tb es el nombre de la categoría
	
	
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
		
	
}
