package com.plexus.crtvgHorarios.dto.horarios;

import java.util.Date;

import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;

public class RangoHorarioDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private Date horaDesde;
	private Date horaHasta;
	
	private UbicacionDto ubicacion;
	private ProduccionDto produccion;
	
	private String colorHorario; // Color identificativo del rango horario
		

	public RangoHorarioDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RangoHorarioDto(Date horaDesde, Date horaHasta) {
		super();
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
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

	public String getColorHorario() {
		return colorHorario;
	}


	public void setColorHorario(String colorHorario) {
		this.colorHorario = colorHorario;
	}
	
	public void setColorHorarioByTipoRangoHorario(Integer tipoRangoHorario) {
					
		// TODO: pasar a constantes los colores utilizados
	
		switch (tipoRangoHorario) {
		
			case 1:
				this.setColorHorario("8080ff"); // violeta
				break;
		
			case 2:
				this.setColorHorario("73d186"); // verde
				break;
				
			case 3:
				this.setColorHorario("c6d173"); // amarillo
				break;
				
			case 4:
				this.setColorHorario("d1ae73"); // naranja
				break;
				
			case 5:
				this.setColorHorario("d17373"); // rojo
				break;
					
			default:
				this.setColorHorario("73d1d1"); // cyan
				break;
		}
	}	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horaDesde == null) ? 0 : horaDesde.hashCode());
		result = prime * result + ((horaHasta == null) ? 0 : horaHasta.hashCode());
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
		
		RangoHorarioDto other = (RangoHorarioDto) obj;
		
		if (horaDesde == null) {
			if (other.horaDesde != null)
				return false;
			
		} else if (!horaDesde.equals(other.horaDesde))
			return false;
		
		if (horaHasta == null) {
			
			if (other.horaHasta != null)
				return false;
			
		} else if (!horaHasta.equals(other.horaHasta))
			return false;
		
		return true;
	}
	
	
	
	
	
}
