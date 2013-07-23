package com.plexus.crtvgHorarios.dto.empleados;


import com.plexus.crtvgHorarios.dto.categorias.CategoriaDto;
import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.profesiones.ProfesionDto;

public class EmpleadoDto extends BaseDto implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idEmpleado;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private CategoriaDto categoria;	
	
	public EmpleadoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpleadoDto(String idEmpleado) {
		super();
		this.idEmpleado = idEmpleado;
	}
	
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
	public CategoriaDto getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDto categoria) {
		this.categoria = categoria;
	}
		
	public String getApellidos() {
		
		if (!this.getApellido2().isEmpty()) {
			return this.getApellido1() + " " + this.getApellido2();
		}
		
		return this.getApellido1();	
		
	}
	
	public String getNombreCompleto() {
		
		if (!this.getApellidos().isEmpty()) {
			return this.getNombre() + " " + this.getApellidos();
		}
		
		return this.getNombre();
		
	}
	
	@Override
	public EmpleadoDto clone() {
		
		EmpleadoDto empleado = new EmpleadoDto();
		
		empleado.setApellido1(this.getApellido1());
		empleado.setApellido2(this.getApellido2());
		empleado.setIdEmpleado(this.getIdEmpleado());
		empleado.setNombre(this.getNombre());
		
		if (this.getCategoria() != null)
			empleado.setCategoria(this.getCategoria().clone());
		
		return empleado;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmpleado == null) ? 0 : idEmpleado.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EmpleadoDto))
			return false;
		EmpleadoDto other = (EmpleadoDto) obj;
		if (idEmpleado == null) {
			if (other.idEmpleado != null)
				return false;
		} else if (!idEmpleado.equals(other.idEmpleado))
			return false;
		return true;
	}
	
	
	
}
