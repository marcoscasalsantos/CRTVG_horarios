package com.plexus.crtvgHorarios.dto.horarios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.plexus.crtvgHorarios.dto.categorias.CategoriaDto;
import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;

public class HorarioSemanaUbicacionDto extends BaseDto implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 	
	private CategoriaDto categoria;
	
	private UbicacionDto ubicacion;
	
	private String idHorarioSemanaUbicacion;
	
	private List<HorasDiaDto> lunes;
	private List<HorasDiaDto> martes;
	private List<HorasDiaDto> miercoles;
	private List<HorasDiaDto> jueves;
	private List<HorasDiaDto> viernes;
	private List<HorasDiaDto> sabado;
	private List<HorasDiaDto> domingo;
	
	private Boolean lunesFestivo;
	private Boolean martesFestivo;
	private Boolean miercolesFestivo;
	private Boolean juevesFestivo;
	private Boolean viernesFestivo;
	private Boolean sabadoFestivo;
	private Boolean domingoFestivo;
	
	
	public HorarioSemanaUbicacionDto() {
		super();
	}
	
	
	public HorarioSemanaUbicacionDto(UbicacionDto ubicacion, String yearMonthWeek) {
		super();		
		this.setUbicacion(ubicacion);
		this.setIdHorarioSemanaUbicacion(yearMonthWeek + ubicacion.getIdUbicacion().toString());		
	}
	
	
	public List<HorasDiaDto> getDiaSemana(int diaSemana) {
		
		switch (diaSemana) {		
			case Calendar.MONDAY: return lunes;
			case Calendar.TUESDAY: return martes;
			case Calendar.WEDNESDAY: return miercoles;
			case Calendar.THURSDAY: return jueves;
			case Calendar.FRIDAY: return viernes;
			case Calendar.SATURDAY: return sabado;
			case Calendar.SUNDAY: return domingo;
		}
		
		return null;		
	}
	
	public void setDiaSemana(int diaSemana, List<HorasDiaDto> horariosDia) {

		switch (diaSemana) {		
			case Calendar.MONDAY: this.setLunes(horariosDia); break;
			case Calendar.TUESDAY: this.setMartes(horariosDia); break;
			case Calendar.WEDNESDAY: this.setMiercoles(horariosDia); break;
			case Calendar.THURSDAY: this.setJueves(horariosDia); break;
			case Calendar.FRIDAY: this.setViernes(horariosDia); break;
			case Calendar.SATURDAY: this.setSabado(horariosDia); break;
			case Calendar.SUNDAY: this.setDomingo(horariosDia); break;
		}
		
	}	
	
	
	public Boolean getFestivoDiaSemana(int diaSemana) {
		
		switch (diaSemana) {		
			case Calendar.MONDAY: return lunesFestivo;
			case Calendar.TUESDAY: return martesFestivo;
			case Calendar.WEDNESDAY: return miercolesFestivo;
			case Calendar.THURSDAY: return juevesFestivo;
			case Calendar.FRIDAY: return viernesFestivo;
			case Calendar.SATURDAY: return sabadoFestivo;
			case Calendar.SUNDAY: return domingoFestivo;
		}
		
		return null;		
	}	


	public void setFestivoDiaSemana(int diaSemana, boolean festivo) {
		
		switch (diaSemana) {		
			case Calendar.MONDAY: this.setLunesFestivo(festivo); break;
			case Calendar.TUESDAY: this.setMartesFestivo(festivo); break;
			case Calendar.WEDNESDAY: this.setMiercolesFestivo(festivo); break;
			case Calendar.THURSDAY: this.setJuevesFestivo(festivo); break;
			case Calendar.FRIDAY: this.setViernesFestivo(festivo); break;
			case Calendar.SATURDAY: this.setSabadoFestivo(festivo); break;
			case Calendar.SUNDAY: this.setDomingoFestivo(festivo); break;
		}
	}	
	
	
	public String getIdHorarioSemanaUbicacion() {
		return idHorarioSemanaUbicacion;
	}





	public void setIdHorarioSemanaUbicacion(String idHorarioSemanaUbicacion) {
		this.idHorarioSemanaUbicacion = idHorarioSemanaUbicacion;
	}




	
	public CategoriaDto getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaDto categoria) {
		this.categoria = categoria;
	}


	public UbicacionDto getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(UbicacionDto ubicacion) {
		this.ubicacion = ubicacion;
	}

	
	public List<HorasDiaDto> getLunes() {

		if (lunes == null)
			lunes = new ArrayList<HorasDiaDto>();
		
		return lunes;
	}
	public void setLunes(List<HorasDiaDto> lunes) {
		this.lunes = lunes;
	}
	public List<HorasDiaDto> getMartes() {
		
		if (martes == null)
			martes = new ArrayList<HorasDiaDto>();		
		
		return martes;
	}
	public void setMartes(List<HorasDiaDto> martes) {
		this.martes = martes;
	}
	public List<HorasDiaDto> getMiercoles() {
		
		if (miercoles == null)
			miercoles = new ArrayList<HorasDiaDto>();		
		
		return miercoles;
	}
	public void setMiercoles(List<HorasDiaDto> miercoles) {
		this.miercoles = miercoles;
	}
	public List<HorasDiaDto> getJueves() {
		
		if (jueves == null)
			jueves = new ArrayList<HorasDiaDto>();
		
		
		return jueves;
	}
	public void setJueves(List<HorasDiaDto> jueves) {
		this.jueves = jueves;
	}
	public List<HorasDiaDto> getViernes() {

		if (viernes == null)
			viernes = new ArrayList<HorasDiaDto>();
		
		return viernes;
	}
	public void setViernes(List<HorasDiaDto> viernes) {		
		this.viernes = viernes;
	}
	public List<HorasDiaDto> getSabado() {
		
		if (sabado == null)
			sabado = new ArrayList<HorasDiaDto>();
		
		return sabado;
	}
	public void setSabado(List<HorasDiaDto> sabado) {
		this.sabado = sabado;
	}
	public List<HorasDiaDto> getDomingo() {
		
		if (domingo == null)
			domingo = new ArrayList<HorasDiaDto>();
			
		return domingo;
	}
	public void setDomingo(List<HorasDiaDto> domingo) {
		this.domingo = domingo;
	}





	public Boolean getLunesFestivo() {
		return lunesFestivo;
	}





	public void setLunesFestivo(Boolean lunesFestivo) {
		this.lunesFestivo = lunesFestivo;
	}







	public Boolean getMartesFestivo() {
		return martesFestivo;
	}





	public void setMartesFestivo(Boolean martesFestivo) {
		this.martesFestivo = martesFestivo;
	}





	public Boolean getMiercolesFestivo() {
		return miercolesFestivo;
	}





	public void setMiercolesFestivo(Boolean miercolesFestivo) {
		this.miercolesFestivo = miercolesFestivo;
	}





	public Boolean getJuevesFestivo() {
		return juevesFestivo;
	}





	public void setJuevesFestivo(Boolean juevesFestivo) {
		this.juevesFestivo = juevesFestivo;
	}





	public Boolean getViernesFestivo() {
		return viernesFestivo;
	}





	public void setViernesFestivo(Boolean viernesFestivo) {
		this.viernesFestivo = viernesFestivo;
	}





	public Boolean getSabadoFestivo() {
		return sabadoFestivo;
	}





	public void setSabadoFestivo(Boolean sabadoFestivo) {
		this.sabadoFestivo = sabadoFestivo;
	}





	public Boolean getDomingoFestivo() {
		return domingoFestivo;
	}





	public void setDomingoFestivo(Boolean domingoFestivo) {
		this.domingoFestivo = domingoFestivo;
	}
		
	
	private List<HorasDiaDto> cloneListHorasDia(List<HorasDiaDto> listaHorasDia) {
		
		ArrayList<HorasDiaDto> copiaListaHorasDia = new ArrayList<HorasDiaDto>();	
		
		for (HorasDiaDto horaDiaClonar: listaHorasDia) {
			HorasDiaDto horaDia = horaDiaClonar.clone();
			copiaListaHorasDia.add(horaDia);
		}
	
		return copiaListaHorasDia;
	}	
	
	
	@Override
	public HorarioSemanaUbicacionDto clone() {
		
		//FIXME: Comprobar que los Tipos primitivos al asignarlos no se asigna la referencia sino el valor (por ejemplo los Strings) Despues de cancelar la edición
		// estos valores Strings deben de quedar como estaban
		
		HorarioSemanaUbicacionDto horarioSemanaUbicacion = new HorarioSemanaUbicacionDto();
			
		horarioSemanaUbicacion.setDomingo(cloneListHorasDia(this.getDomingo()));		
		horarioSemanaUbicacion.setDomingoFestivo(this.getDomingoFestivo());
				
		horarioSemanaUbicacion.setIdHorarioSemanaUbicacion(this.getIdHorarioSemanaUbicacion());
				
		horarioSemanaUbicacion.setJueves(cloneListHorasDia(this.getJueves()));
		horarioSemanaUbicacion.setJuevesFestivo(this.getJuevesFestivo());
		
		horarioSemanaUbicacion.setLunes(cloneListHorasDia(this.getLunes()));
		horarioSemanaUbicacion.setLunesFestivo(this.getLunesFestivo());
		
		horarioSemanaUbicacion.setMartes(cloneListHorasDia(this.getMartes()));
		horarioSemanaUbicacion.setMartesFestivo(this.getMartesFestivo());
		
		horarioSemanaUbicacion.setMiercoles(cloneListHorasDia(this.getMiercoles()));
		horarioSemanaUbicacion.setMiercolesFestivo(this.getMiercolesFestivo());
		
		horarioSemanaUbicacion.setSabado(cloneListHorasDia(this.getSabado()));
		horarioSemanaUbicacion.setSabadoFestivo(this.getSabadoFestivo());
		
		horarioSemanaUbicacion.setCategoria(this.getCategoria().clone());
		horarioSemanaUbicacion.setUbicacion(this.getUbicacion().clone());
		
		horarioSemanaUbicacion.setViernes(cloneListHorasDia(this.getViernes()));
		horarioSemanaUbicacion.setViernesFestivo(this.getViernesFestivo());
				
		return horarioSemanaUbicacion;		
	}
	
}
