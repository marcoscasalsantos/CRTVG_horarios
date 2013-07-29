package com.plexus.crtvgHorarios.dto.producciones;


import com.plexus.crtvgHorarios.dto.common.BaseDto;

public class ProduccionDto extends BaseDto implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idProduccion;
	private String nombreProduccion;
	private String familiaProduccion;
	
	
	public ProduccionDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProduccionDto(String idProduccion, String nombreProduccion) {
		super();
		this.idProduccion = idProduccion;
		this.nombreProduccion = nombreProduccion;
	}
	
	
	public String getIdProduccion() {
		return idProduccion;
	}
	public void setIdProduccion(String idProduccion) {
		this.idProduccion = idProduccion;
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
	
	@Override
	public ProduccionDto clone() {
		
		ProduccionDto produccion = new ProduccionDto();
		
		produccion.setFamiliaProduccion(this.getFamiliaProduccion());
		produccion.setIdProduccion(this.getIdProduccion());		
		produccion.setNombreProduccion(this.getNombreProduccion());
		
		return produccion;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduccion == null) ? 0 : idProduccion.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProduccionDto))
			return false;
		ProduccionDto other = (ProduccionDto) obj;
		if (idProduccion == null) {
			if (other.idProduccion != null)
				return false;
		} else if (!idProduccion.equals(other.idProduccion))
			return false;
		return true;
	}

	
	
}
