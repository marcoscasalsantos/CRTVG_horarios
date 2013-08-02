package com.plexus.crtvgHorarios.dto.horarios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTimeConstants;

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
		
		// OJO! Usar las constantes de JodaTime en lugar de las de Calendar ya que empiezan la semana con el luenes en lugar del domingo
		switch (diaSemana) {		
			case DateTimeConstants.MONDAY: return lunes;
			case DateTimeConstants.TUESDAY: return martes;
			case DateTimeConstants.WEDNESDAY: return miercoles;
			case DateTimeConstants.THURSDAY: return jueves;
			case DateTimeConstants.FRIDAY: return viernes;
			case DateTimeConstants.SATURDAY: return sabado;
			case DateTimeConstants.SUNDAY: return domingo;
		}
		
		return null;		
	}
	
	public void setDiaSemana(int diaSemana, List<HorasDiaDto> horariosDia) {

		// OJO! Usar las constantes de JodaTime en lugar de las de Calendar ya que empiezan la semana con el luenes en lugar del domingo
		switch (diaSemana) {		
			case DateTimeConstants.MONDAY: this.setLunes(horariosDia); break;
			case DateTimeConstants.TUESDAY: this.setMartes(horariosDia); break;
			case DateTimeConstants.WEDNESDAY: this.setMiercoles(horariosDia); break;
			case DateTimeConstants.THURSDAY: this.setJueves(horariosDia); break;
			case DateTimeConstants.FRIDAY: this.setViernes(horariosDia); break;
			case DateTimeConstants.SATURDAY: this.setSabado(horariosDia); break;
			case DateTimeConstants.SUNDAY: this.setDomingo(horariosDia); break;
		}
		
	}	
	
	
	public Boolean getFestivoDiaSemana(int diaSemana) {
		
		// OJO! Usar las constantes de JodaTime en lugar de las de Calendar ya que empiezan la semana con el luenes en lugar del domingo
		switch (diaSemana) {		
			case DateTimeConstants.MONDAY: return lunesFestivo;
			case DateTimeConstants.TUESDAY: return martesFestivo;
			case DateTimeConstants.WEDNESDAY: return miercolesFestivo;
			case DateTimeConstants.THURSDAY: return juevesFestivo;
			case DateTimeConstants.FRIDAY: return viernesFestivo;
			case DateTimeConstants.SATURDAY: return sabadoFestivo;
			case DateTimeConstants.SUNDAY: return domingoFestivo;
		}
		
		return null;		
	}	


	public void setFestivoDiaSemana(int diaSemana, boolean festivo) {
		
		// OJO! Usar las constantes de JodaTime en lugar de las de Calendar ya que empiezan la semana con el luenes en lugar del domingo
		switch (diaSemana) {		
			case DateTimeConstants.MONDAY: this.setLunesFestivo(festivo); break;
			case DateTimeConstants.TUESDAY: this.setMartesFestivo(festivo); break;
			case DateTimeConstants.WEDNESDAY: this.setMiercolesFestivo(festivo); break;
			case DateTimeConstants.THURSDAY: this.setJuevesFestivo(festivo); break;
			case DateTimeConstants.FRIDAY: this.setViernesFestivo(festivo); break;
			case DateTimeConstants.SATURDAY: this.setSabadoFestivo(festivo); break;
			case DateTimeConstants.SUNDAY: this.setDomingoFestivo(festivo); break;
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
