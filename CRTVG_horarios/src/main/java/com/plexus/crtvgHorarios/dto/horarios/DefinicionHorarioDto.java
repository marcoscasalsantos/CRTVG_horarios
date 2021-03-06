package com.plexus.crtvgHorarios.dto.horarios;

import java.util.Date;

import org.joda.time.DateTimeConstants;

import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;
import com.plexus.crtvgHorarios.dto.common.BaseDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;

public class DefinicionHorarioDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private Long idDefinicionHorario;
	
	private Date fechaDesde;

	private Date fechaHasta;
	
	private boolean aplicarLunes;
	private boolean aplicarMartes;
	private boolean aplicarMiercoles;
	private boolean aplicarJueves;
	private boolean aplicarViernes;
	private boolean aplicarSabado;
	private boolean aplicarDomingo;
	
	private Integer numSemanasAlternancia;
	
	private String colorHorario; // Color identificativo del rango horario
	
	private Date horaDesde;
	private Date horaHasta;
	
	private EmpleadoDto empleado;
	private UbicacionDto ubicacion;
	private ProduccionDto produccion;

	public DefinicionHorarioDto() {
		super();
		//this.rangoHorario = new RangoHorarioDto();
		// TODO Auto-generated constructor stub
	}
	
	public DefinicionHorarioDto(UnidadHorarioPojo unidadHorarioPojo) {
		this.setIdDefinicionHorario(unidadHorarioPojo.getIdDefinicionHorario());
		this.setFechaDesde(unidadHorarioPojo.getFechaDefinicionDesde());
		this.setFechaHasta(unidadHorarioPojo.getFechaDefinicionHasta());
		this.setHoraDesde(unidadHorarioPojo.getHoraDefinicionDesde());
		this.setHoraHasta(unidadHorarioPojo.getHoraDefinicionHasta());
		this.setUbicacion(new UbicacionDto(unidadHorarioPojo.getIdUbicacionDefinicion()));
		this.setProduccion(new ProduccionDto(unidadHorarioPojo.getIdProduccionDefinicion()));
	}

	
	public DefinicionHorarioDto(EmpleadoDto empleado) {
		super();
		this.empleado = empleado;
	}




	public boolean aplicarDiaSemana(int diaSemana) {
		
		// OJO! Usar las constantes de JodaTime en lugar de las de Calendar ya que empiezan la semana con el luenes en lugar del domingo
		switch (diaSemana) {		
			case DateTimeConstants.MONDAY: return aplicarLunes;
			case DateTimeConstants.TUESDAY: return aplicarMartes;
			case DateTimeConstants.WEDNESDAY: return aplicarMiercoles;
			case DateTimeConstants.THURSDAY: return aplicarJueves;
			case DateTimeConstants.FRIDAY: return aplicarViernes;
			case DateTimeConstants.SATURDAY: return aplicarSabado;
			case DateTimeConstants.SUNDAY: return aplicarDomingo;
		}		
		return false;
	}
	
	
	

	public Date getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public Date getFechaHasta() {
		return fechaHasta;
	}


	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	public boolean isAplicarLunes() {
		return aplicarLunes;
	}


	public void setAplicarLunes(boolean aplicarLunes) {
		this.aplicarLunes = aplicarLunes;
	}


	public boolean isAplicarMartes() {
		return aplicarMartes;
	}


	public void setAplicarMartes(boolean aplicarMartes) {
		this.aplicarMartes = aplicarMartes;
	}


	public boolean isAplicarMiercoles() {
		return aplicarMiercoles;
	}


	public void setAplicarMiercoles(boolean aplicarMiercoles) {
		this.aplicarMiercoles = aplicarMiercoles;
	}


	public boolean isAplicarJueves() {
		return aplicarJueves;
	}


	public void setAplicarJueves(boolean aplicarJueves) {
		this.aplicarJueves = aplicarJueves;
	}


	public boolean isAplicarViernes() {
		return aplicarViernes;
	}


	public void setAplicarViernes(boolean aplicarViernes) {
		this.aplicarViernes = aplicarViernes;
	}


	public boolean isAplicarSabado() {
		return aplicarSabado;
	}


	public void setAplicarSabado(boolean aplicarSabado) {
		this.aplicarSabado = aplicarSabado;
	}


	public boolean isAplicarDomingo() {
		return aplicarDomingo;
	}


	public void setAplicarDomingo(boolean aplicarDomingo) {
		this.aplicarDomingo = aplicarDomingo;
	}


	public Long getIdDefinicionHorario() {
		return idDefinicionHorario;
	}


	public void setIdDefinicionHorario(Long idDefinicionHorario) {
		this.idDefinicionHorario = idDefinicionHorario;
	}


	public String getColorHorario() {
		return colorHorario;
	}
	
	public String getHexColorHorario() {
		if (colorHorario == null)
			return "";
		
		return "#" + colorHorario;
	}


	public void setColorHorario(String colorHorario) {
		this.colorHorario = colorHorario;
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


	public EmpleadoDto getEmpleado() {
		return empleado;
	}


	public void setEmpleado(EmpleadoDto empleado) {
		this.empleado = empleado;
	}




	public Integer getNumSemanasAlternancia() {
		return numSemanasAlternancia;
	}




	public void setNumSemanasAlternancia(Integer numSemanasAlternancia) {
		this.numSemanasAlternancia = numSemanasAlternancia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDefinicionHorario == null) ? 0 : idDefinicionHorario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DefinicionHorarioDto))
			return false;
		DefinicionHorarioDto other = (DefinicionHorarioDto) obj;
		if (idDefinicionHorario == null) {
			if (other.idDefinicionHorario != null)
				return false;
		} else if (!idDefinicionHorario.equals(other.idDefinicionHorario))
			return false;
		return true;
	}

	

}
