package com.plexus.crtvgHorarios.dto.secciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.horarios.HorasDiaDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;

public class SeccionDto extends BaseDto implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	
	private Long idSeccion;
	private String nombreSeccion;
	
	
	public SeccionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeccionDto(Long idSeccion, String nombreSeccion) {
		super();
		this.setIdSeccion(idSeccion);
		this.setNombreSeccion(nombreSeccion);
	}	
	
	
	public SeccionDto(UnidadHorarioPojo unidadHorarioPojo) {
		super();
		this.setIdSeccion(unidadHorarioPojo.getIdSeccion());
		this.setNombreSeccion(unidadHorarioPojo.getNombreSeccion());		
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

	@Override
	public SeccionDto clone() {
		
		SeccionDto seccion = new SeccionDto();
		
		seccion.setIdSeccion(this.getIdSeccion());
		seccion.setNombreSeccion(this.getNombreSeccion());
				
		return seccion;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSeccion == null) ? 0 : idSeccion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SeccionDto))
			return false;
		SeccionDto other = (SeccionDto) obj;
		if (idSeccion == null) {
			if (other.idSeccion != null)
				return false;
		} else if (!idSeccion.equals(other.idSeccion))
			return false;
		return true;
	}



	
	
	
}
