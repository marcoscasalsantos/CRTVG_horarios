package com.plexus.crtvgHorarios.dto.horarios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;

public class HorarioSemanaEmpleadoDto extends BaseDto implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 	
	private EmpleadoDto empleado;
	
	private String idHorarioSemanaEmpleado;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("d");
	private static SimpleDateFormat sdf_yearMonthWeek = new SimpleDateFormat("yyyyMMww");
	
	private static int[] diaSemana = {2,3,4,5,6,7,1}; // Contiene los dias de la semana tal como los representa java.util.Calendar
	
	// TODO: Refactorizar creando un tipo de objeto día que incluya los distintos atributos de los días;
	
	private List<HorasDiaDto> lunes;
	private List<HorasDiaDto> martes;
	private List<HorasDiaDto> miercoles;
	private List<HorasDiaDto> jueves;
	private List<HorasDiaDto> viernes;
	private List<HorasDiaDto> sabado;
	private List<HorasDiaDto> domingo;
	
	private Date fechaLunes;
	private Date fechaMartes;
	private Date fechaMiercoles;
	private Date fechaJueves;
	private Date fechaViernes;
	private Date fechaSabado;
	private Date fechaDomingo;
	
	/*
	private Integer tipoRangoHorarioLunes;
	private Integer tipoRangoHorarioMartes;
	private Integer tipoRangoHorarioMiercoles;
	private Integer tipoRangoHorarioJueves;
	private Integer tipoRangoHorarioViernes;
	private Integer tipoRangoHorarioSabado;
	private Integer tipoRangoHorarioDomingo;
	*/
	
	private Boolean lunesFestivo;
	private Boolean martesFestivo;
	private Boolean miercolesFestivo;
	private Boolean juevesFestivo;
	private Boolean viernesFestivo;
	private Boolean sabadoFestivo;
	private Boolean domingoFestivo;	
	
	private String colorHorarioLunes;
	private String colorHorarioMartes;
	private String colorHorarioMiercoles;
	private String colorHorarioJueves;
	private String colorHorarioViernes;
	private String colorHorarioSabado;
	private String colorHorarioDomingo;	
	
	public HorarioSemanaEmpleadoDto() {
		super();
	}
	
	
	public HorarioSemanaEmpleadoDto(EmpleadoDto empleado, String yearMonthWeek) {
		super();		
		this.setEmpleado(empleado);
		this.setIdHorarioSemanaEmpleado(yearMonthWeek + empleado.getIdEmpleado().toString());		
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
	
	
	public Date getFechaDiaSemana(int diaSemana) {
		
		switch (diaSemana) {		
			case Calendar.MONDAY: return fechaLunes;
			case Calendar.TUESDAY: return fechaMartes;
			case Calendar.WEDNESDAY: return fechaMiercoles;
			case Calendar.THURSDAY: return fechaJueves;
			case Calendar.FRIDAY: return fechaViernes;
			case Calendar.SATURDAY: return fechaSabado;
			case Calendar.SUNDAY: return fechaDomingo;
		}
		
		return null;		
	}	
	
	public void setFechaDiaSemana(int diaSemana, Date fecha) {
		
		switch (diaSemana) {		
			case Calendar.MONDAY: this.setFechaLunes(fecha); break;
			case Calendar.TUESDAY: this.setFechaMartes(fecha); break;
			case Calendar.WEDNESDAY: this.setFechaMiercoles(fecha); break;
			case Calendar.THURSDAY: this.setFechaJueves(fecha); break;
			case Calendar.FRIDAY: this.setFechaViernes(fecha); break;
			case Calendar.SATURDAY: this.setFechaSabado(fecha); break;
			case Calendar.SUNDAY: this.setFechaDomingo(fecha); break;
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
	
	
	public void setColorHorarioDia(int diaSemana, String color) {
		switch (diaSemana) {		
			case Calendar.MONDAY: this.setColorHorarioLunes(color); break;
			case Calendar.TUESDAY: this.setColorHorarioMartes(color); break;
			case Calendar.WEDNESDAY: this.setColorHorarioMiercoles(color); break;
			case Calendar.THURSDAY: this.setColorHorarioJueves(color); break;
			case Calendar.FRIDAY: this.setColorHorarioViernes(color); break;
			case Calendar.SATURDAY: this.setColorHorarioSabado(color); break;
			case Calendar.SUNDAY: this.setColorHorarioDomingo(color); break;
		}				
	}
	
	
	/**
	 * Devuelve la fecha del primer día de la semana que tenga fecha distinta de null
	 * @return
	 */
	public Date getFechaSemana() {
		
		for (int i=0; i<=6; i++) {
			Date fechaSemana = getFechaDiaSemana(diaSemana[i]); 
			if ( fechaSemana != null)
				return fechaSemana;
		}
		
		return null; // si no está definida la fecha para ningún día de la semana se devuelve null;
	}
	
	
	public List<List<HorasDiaDto>> getDiasSemana(){
		
		List<List<HorasDiaDto>> listaDiasSemana = new ArrayList<List<HorasDiaDto>>();
		
		for (int i=0; i<= 6; i++) {
			listaDiasSemana.add(this.getDiaSemana(diaSemana[i]));
		}
		
		return listaDiasSemana;
	}
	
	// Todas la semanas deberían contener almenos un día con fecha distinta de null
	public String getYearMonthWeek() {
		
		for (int i= 0; i<= 6; i++) {
			
			Date fecha = this.getFechaDiaSemana(diaSemana[i]); 
			if (fecha != null) {
				return sdf_yearMonthWeek.format(fecha);				
			}			
		}
		
		return null;		
	}	
	
	public EmpleadoDto getEmpleado() {
		return empleado;
	}


	public void setEmpleado(EmpleadoDto empleado) {
		this.empleado = empleado;
	}


	public String getIdHorarioSemanaEmpleado() {
		return idHorarioSemanaEmpleado;
	}


	public void setIdHorarioSemanaEmpleado(String idHorarioSemanaEmpleado) {
		this.idHorarioSemanaEmpleado = idHorarioSemanaEmpleado;
	}	

	public Date getFechaLunes() {
		return fechaLunes;
	}


	public void setFechaLunes(Date fechaLunes) {
		this.fechaLunes = fechaLunes;
	}


	public Date getFechaMartes() {
		return fechaMartes;
	}


	public void setFechaMartes(Date fechaMartes) {
		this.fechaMartes = fechaMartes;
	}


	public Date getFechaMiercoles() {
		return fechaMiercoles;
	}


	public void setFechaMiercoles(Date fechaMiercoles) {
		this.fechaMiercoles = fechaMiercoles;
	}


	public Date getFechaJueves() {
		return fechaJueves;
	}


	public void setFechaJueves(Date fechaJueves) {
		this.fechaJueves = fechaJueves;
	}


	public Date getFechaViernes() {
		return fechaViernes;
	}


	public void setFechaViernes(Date fechaViernes) {
		this.fechaViernes = fechaViernes;
	}


	public Date getFechaSabado() {
		return fechaSabado;
	}


	public void setFechaSabado(Date fechaSabado) {
		this.fechaSabado = fechaSabado;
	}


	public Date getFechaDomingo() {
		return fechaDomingo;
	}


	public void setFechaDomingo(Date fechaDomingo) {
		this.fechaDomingo = fechaDomingo;
	}

		
	public String getDiaLunes() {
				
		if (this.getFechaLunes() != null)			
			return sdf.format(this.getFechaLunes());
		else
			return "";
	}	


	public String getDiaMartes() {
		if (this.getFechaMartes() != null)			
			return sdf.format(this.getFechaMartes());
		else
			return "";	
	}	


	public String getDiaMiercoles() {
		if (this.getFechaMiercoles() != null)			
			return sdf.format(this.getFechaMiercoles());
		else
			return "";	
	}	

	public String getDiaJueves() {
		if (this.getFechaJueves() != null)			
			return sdf.format(this.getFechaJueves());
		else
			return "";	
	}	

	public String getDiaViernes() {
		if (this.getFechaViernes() != null)			
			return sdf.format(this.getFechaViernes());
		else
			return "";	
	}	

	public String getDiaSabado() {
		if (this.getFechaSabado() != null)			
			return sdf.format(this.getFechaSabado());
		else
			return "";	
	}	
	
	public String getDiaDomingo() {
		if (this.getFechaDomingo() != null)			
			return sdf.format(this.getFechaDomingo());
		else
			return "";	
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
		
	
	
	public String getColorHorarioLunes() {
		
		return this.colorHorarioLunes;
	}
	
	public String getColorHorarioMartes() {
		
		return this.colorHorarioMartes;
	}

	public String getColorHorarioMiercoles() {
		
		return this.colorHorarioMiercoles;
	}

	public String getColorHorarioJueves() {
		
		return this.colorHorarioJueves;
	}

	public String getColorHorarioViernes() {
		
		return this.colorHorarioViernes;
	}
	
	public String getColorHorarioSabado() {
		
		return this.colorHorarioSabado;
	}
	
	public String getColorHorarioDomingo() {
		
		return this.colorHorarioDomingo;
	}	
		


	public void setColorHorarioSabado(String colorHorarioSabado) {
		this.colorHorarioSabado = colorHorarioSabado;
	}


	public void setColorHorarioLunes(String colorHorarioLunes) {
		this.colorHorarioLunes = colorHorarioLunes;
	}


	public void setColorHorarioMartes(String colorHorarioMartes) {
		this.colorHorarioMartes = colorHorarioMartes;
	}


	public void setColorHorarioMiercoles(String colorHorarioMiercoles) {
		this.colorHorarioMiercoles = colorHorarioMiercoles;
	}


	public void setColorHorarioJueves(String colorHorarioJueves) {
		this.colorHorarioJueves = colorHorarioJueves;
	}


	public void setColorHorarioViernes(String colorHorarioViernes) {
		this.colorHorarioViernes = colorHorarioViernes;
	}


	public void setColorHorarioDomingo(String colorHorarioDomingo) {
		this.colorHorarioDomingo = colorHorarioDomingo;
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
	public HorarioSemanaEmpleadoDto clone() {
		
		//FIXME: Comprobar que los Tipos primitivos al asignarlos no se asigna la referencia sino el valor (por ejemplo los Strings) Despues de cancelar la edición
		// estos valores Strings deben de quedar como estaban
		
		HorarioSemanaEmpleadoDto horarioSemanaEmpleado = new HorarioSemanaEmpleadoDto();
			
		horarioSemanaEmpleado.setDomingo(cloneListHorasDia(this.getDomingo()));		
		horarioSemanaEmpleado.setDomingoFestivo(this.getDomingoFestivo());
				
		horarioSemanaEmpleado.setIdHorarioSemanaEmpleado(this.getIdHorarioSemanaEmpleado());
				
		horarioSemanaEmpleado.setJueves(cloneListHorasDia(this.getJueves()));
		horarioSemanaEmpleado.setJuevesFestivo(this.getJuevesFestivo());
		
		horarioSemanaEmpleado.setLunes(cloneListHorasDia(this.getLunes()));
		horarioSemanaEmpleado.setLunesFestivo(this.getLunesFestivo());
		
		horarioSemanaEmpleado.setMartes(cloneListHorasDia(this.getMartes()));
		horarioSemanaEmpleado.setMartesFestivo(this.getMartesFestivo());
		
		horarioSemanaEmpleado.setMiercoles(cloneListHorasDia(this.getMiercoles()));
		horarioSemanaEmpleado.setMiercolesFestivo(this.getMiercolesFestivo());
		
		horarioSemanaEmpleado.setSabado(cloneListHorasDia(this.getSabado()));
		horarioSemanaEmpleado.setSabadoFestivo(this.getSabadoFestivo());
			
		horarioSemanaEmpleado.setViernes(cloneListHorasDia(this.getViernes()));
		horarioSemanaEmpleado.setViernesFestivo(this.getViernesFestivo());
				
		return horarioSemanaEmpleado;		
	}

	
	// FIXME: En lugar de asignar un color "hardcodeado" según el tipo de horario debería obtener la lista de colores de las definicionesHorario del empleado
	/*
	private String getColorHorario(Integer tipoRangoHorario) {
		
		switch (tipoRangoHorario) {
		
		case 1:
			return "#8080ff"; // violeta
	
		case 2:
			return "#73d186"; // verde
			
		case 3:
			return "#c6d173"; // amarillo
			
		case 4:
			return "#d1ae73"; // naranja
			
		case 5:
			return "#d17373"; // rojo										
				
		default:
			return "73d1d1"; // cyan
			
		}
	}
	*/
	
	

	
	
	public String getHexColorHorarioLunes() {
		
		if (this.getColorHorarioLunes() == null) {			
			return "";
		}
		
		return "#" + this.colorHorarioLunes;
	}
	
	public String getHexColorHorarioMartes() {
		
		if (this.getColorHorarioMartes() == null) {			
			return "";
		}
		
		return "#" + this.colorHorarioMartes;
	}

	public String getHexColorHorarioMiercoles() {
		
		if (this.getColorHorarioMiercoles() == null) {			
			return "";
		}
		
		return "#" + this.colorHorarioMiercoles;
	}

	public String getHexColorHorarioJueves() {
		
		if (this.getColorHorarioJueves() == null) {			
			return "";
		}
		
		return "#" + this.colorHorarioJueves;
	}

	public String getHexColorHorarioViernes() {
		
		if (this.getColorHorarioViernes() == null) {			
			return "";
		}
		
		return "#" + this.colorHorarioViernes;
	}
	
	public String getHexColorHorarioSabado() {
		
		if (this.getColorHorarioSabado() == null) {			
			return "";
		}
		
		return "#" + this.colorHorarioSabado;
	}
	
	public String getHexColorHorarioDomingo() {
		
		if (this.getColorHorarioDomingo() == null) {			
			return "";
		}
		
		return "#" + this.colorHorarioDomingo;
	}		
	
			
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHorarioSemanaEmpleado == null) ? 0 : idHorarioSemanaEmpleado.hashCode());
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
		HorarioSemanaEmpleadoDto other = (HorarioSemanaEmpleadoDto) obj;
		if (idHorarioSemanaEmpleado == null) {
			if (other.idHorarioSemanaEmpleado != null)
				return false;
		} else if (!idHorarioSemanaEmpleado.equals(other.idHorarioSemanaEmpleado))
			return false;
		return true;
	}
	
	
	
}
