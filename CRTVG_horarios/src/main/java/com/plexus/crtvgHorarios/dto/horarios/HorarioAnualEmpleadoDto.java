package com.plexus.crtvgHorarios.dto.horarios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTimeConstants;

import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.view.common.dataModel.HorariosSemanasEmpleadoDataModel;

public class HorarioAnualEmpleadoDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			
	
	private Integer anho;
	
	private EmpleadoDto empleado;
	
	private HorarioMesDto enero;
	private HorarioMesDto febrero;
	private HorarioMesDto marzo;
	
	private HorarioMesDto abril;
	private HorarioMesDto mayo;
	private HorarioMesDto junio;
	
	private HorarioMesDto julio;
	private HorarioMesDto agosto;
	private HorarioMesDto septiembre;
	
	private HorarioMesDto octubre;
	private HorarioMesDto noviembre;
	private HorarioMesDto diciembre;
	
	private List<DefinicionHorarioDto> definicionesHorarios; // Lista con los definicionesHorarios para el empleado
	private List<ExcepcionHorarioDto> excepcionesHorarios; // Lista con las excepciones a los horarios definidos para el empleado: Vacaciones, ausencias...
	
	public HorarioAnualEmpleadoDto(Integer anho, EmpleadoDto empleado) {
		super();
		this.anho = anho;
		this.empleado = empleado;
	}

	public Integer getAnho() {
		return anho;
	}

	public void setAnho(Integer anho) {
		this.anho = anho;
	}
	

	public HorarioMesDto getMes(int mes) {
		
		// OJO! Usar las constantes de JodaTime en lugar de las de Calendar ya que los meses van de 1 a 12 en lugar de 0 a 11
		switch (mes) {		
			case DateTimeConstants.JANUARY: return enero;
			case DateTimeConstants.FEBRUARY: return febrero;
			case DateTimeConstants.MARCH: return marzo;
			case DateTimeConstants.APRIL: return abril;
			case DateTimeConstants.MAY: return mayo;
			case DateTimeConstants.JUNE: return junio;
			case DateTimeConstants.JULY: return julio;
			case DateTimeConstants.AUGUST: return agosto;
			case DateTimeConstants.SEPTEMBER: return septiembre;
			case DateTimeConstants.OCTOBER: return octubre;
			case DateTimeConstants.NOVEMBER: return noviembre;
			case DateTimeConstants.DECEMBER: return diciembre;		
		}
		
		return null;
				
	}

	public void setMes(int mes, HorarioMesDto horarioMes) {
		
		switch (mes) {		
			case DateTimeConstants.JANUARY: this.setEnero(horarioMes); break;
			case DateTimeConstants.FEBRUARY: this.setFebrero(horarioMes); break;
			case DateTimeConstants.MARCH: this.setMarzo(horarioMes); break;
			case DateTimeConstants.APRIL: this.setAbril(horarioMes); break;
			case DateTimeConstants.MAY: this.setMayo(horarioMes); break;
			case DateTimeConstants.JUNE: this.setJunio(horarioMes); break;
			case DateTimeConstants.JULY: this.setJulio(horarioMes); break;
			case DateTimeConstants.AUGUST: this.setAgosto(horarioMes); break;
			case DateTimeConstants.SEPTEMBER: this.setSeptiembre(horarioMes); break;
			case DateTimeConstants.OCTOBER: this.setOctubre(horarioMes); break;
			case DateTimeConstants.NOVEMBER: this.setNoviembre(horarioMes); break;
			case DateTimeConstants.DECEMBER: this.setDiciembre(horarioMes); break;
		}
	}
	
	public List<HorarioMesDto> getMesesAnho() {
		
		List<HorarioMesDto> mesesAnho = new ArrayList<HorarioMesDto>();
		
		for (int mes = DateTimeConstants.JANUARY; mes <= DateTimeConstants.DECEMBER; mes++) {			
			mesesAnho.add(this.getMes(mes));			
		}
		
		return mesesAnho;
	}
	
	
	public HorarioMesDto getEnero() {
		return enero;
	}


	public void setEnero(HorarioMesDto enero) {
		this.enero = enero;
	}


	public HorarioMesDto getFebrero() {
		return febrero;
	}


	public void setFebrero(HorarioMesDto febrero) {
		this.febrero = febrero;
	}


	public HorarioMesDto getMarzo() {
		return marzo;
	}


	public void setMarzo(HorarioMesDto marzo) {
		this.marzo = marzo;
	}


	public HorarioMesDto getAbril() {
		return abril;
	}


	public void setAbril(HorarioMesDto abril) {
		this.abril = abril;
	}


	public HorarioMesDto getMayo() {
		return mayo;
	}


	public void setMayo(HorarioMesDto mayo) {
		this.mayo = mayo;
	}


	public HorarioMesDto getJunio() {
		return junio;
	}


	public void setJunio(HorarioMesDto junio) {
		this.junio = junio;
	}


	public HorarioMesDto getJulio() {
		return julio;
	}


	public void setJulio(HorarioMesDto julio) {
		this.julio = julio;
	}


	public HorarioMesDto getAgosto() {
		return agosto;
	}


	public void setAgosto(HorarioMesDto agosto) {
		this.agosto = agosto;
	}


	public HorarioMesDto getSeptiembre() {
		return septiembre;
	}


	public void setSeptiembre(HorarioMesDto septiembre) {
		this.septiembre = septiembre;
	}


	public HorarioMesDto getOctubre() {
		return octubre;
	}


	public void setOctubre(HorarioMesDto octubre) {
		this.octubre = octubre;
	}


	public HorarioMesDto getNoviembre() {
		return noviembre;
	}


	public void setNoviembre(HorarioMesDto noviembre) {
		this.noviembre = noviembre;
	}


	public HorarioMesDto getDiciembre() {
		return diciembre;
	}


	public void setDiciembre(HorarioMesDto diciembre) {
		this.diciembre = diciembre;
	}


	public List<DefinicionHorarioDto> getDefinicionesHorarios() {
				
		return definicionesHorarios;
	}

	public void setDefinicionesHorarios(List<DefinicionHorarioDto> definicionesHorarios) {
		this.definicionesHorarios = definicionesHorarios;
	}

	public EmpleadoDto getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoDto empleado) {
		this.empleado = empleado;
	}

	public List<ExcepcionHorarioDto> getExcepcionesHorarios() {
		return excepcionesHorarios;
	}

	public void setExcepcionesHorarios(List<ExcepcionHorarioDto> excepcionesHorarios) {
		this.excepcionesHorarios = excepcionesHorarios;
	}	
	
}
