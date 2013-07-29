package com.plexus.crtvgHorarios.dto.ubicaciones;

import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.common.BaseDto;

public class UbicacionDto extends BaseDto implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idUbicacion;
	private String nombreUbicacion;
	private String fase;
	
	public UbicacionDto() {
		super();	
	}
	
	
	
	public UbicacionDto(String idUbicacion, String nombreUbicacion) {
		super();
		this.idUbicacion = idUbicacion;
		this.nombreUbicacion = nombreUbicacion;
	}



	public UbicacionDto(UnidadHorarioPojo unidadHorarioPojo) {
		super();
		this.setIdUbicacion(unidadHorarioPojo.getIdUbicacion());
		this.setNombreUbicacion(unidadHorarioPojo.getNombreUbicacion());
		this.setFase(unidadHorarioPojo.getFase());
	}		
	

	
	public String getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(String idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public String getNombreUbicacion() {
		return nombreUbicacion;
	}
	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}	
	
	
	@Override
	public UbicacionDto clone() {
		
		UbicacionDto ubicacion = new UbicacionDto();
		
		ubicacion.setIdUbicacion(this.getIdUbicacion());		
		ubicacion.setNombreUbicacion(this.getNombreUbicacion());
		ubicacion.setFase(this.getFase());		
		
		return ubicacion;				
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUbicacion == null) ? 0 : idUbicacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UbicacionDto))
			return false;
		UbicacionDto other = (UbicacionDto) obj;
		if (idUbicacion == null) {
			if (other.idUbicacion != null)
				return false;
		} else if (!idUbicacion.equals(other.idUbicacion))
			return false;
		return true;
	}
	
	
	
	
}
