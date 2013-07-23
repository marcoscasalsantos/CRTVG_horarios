package com.plexus.crtvgHorarios.dto.categorias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.horarios.HorasDiaDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;

public class CategoriaDto extends BaseDto implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	
	private String idCategoria;
	private String nombreCategoria;
	
	
	public CategoriaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaDto(String idCategoria, String nombreCategoria) {
		super();
		this.setIdCategoria(idCategoria);
		this.setNombreCategoria(nombreCategoria);
	}	
	
	
	public CategoriaDto(UnidadHorarioPojo unidadHorarioPojo) {
		super();
		this.setIdCategoria(unidadHorarioPojo.getCategoria());
		this.setNombreCategoria(unidadHorarioPojo.getCategoria());		
	}


	
	
	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public CategoriaDto clone() {
		
		CategoriaDto categoria = new CategoriaDto();
		
		categoria.setIdCategoria(this.getIdCategoria());
		categoria.setNombreCategoria(this.getNombreCategoria());
				
		return categoria;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaDto other = (CategoriaDto) obj;
		if (idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!idCategoria.equals(other.idCategoria))
			return false;
		return true;
	}

	
	
	
}
