package com.plexus.crtvgHorarios.view.managedBeans.horarios;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.omnifaces.util.selectitems.SelectItemsBuilder;

import com.plexus.crtvgHorarios.dto.categorias.CategoriaDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.HorarioSemanaUbicacionDto;
import com.plexus.crtvgHorarios.dto.horarios.HorasDiaDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.secciones.SeccionDto;
import com.plexus.crtvgHorarios.service.empleadoService.EmpleadoService;
import com.plexus.crtvgHorarios.service.horarioService.HorarioService;
import com.plexus.crtvgHorarios.view.common.FacesUtils;


@ManagedBean(name = "horariosBean")
@ViewScoped
public class HorariosBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	//private LazyDataModel<CambioCdto> lazyModel; 
	
	private List<HorarioSemanaUbicacionDto> horariosSemanasUbicaciones; 
	
	private List<SelectItem> seccionesSelectItems;
	private SeccionDto selectedSeccion;
	
	private Date selectedSemana;
	
	private HorasDiaDto selectedHorasDia;
	private HorasDiaDto horasDiaEdicion;
	
	private List<SelectItem> sustitutosSelectItems;	
	private List<SelectItem> produccionesSelectItems;
	
	private boolean dialogoEdicionHorarioVisible;
			
	@PostConstruct
	private void postConstrut(){

		SelectItemsBuilder builder = new SelectItemsBuilder();
		
		EmpleadoService empleadoService = FacesUtils.getService("empleadoService", EmpleadoService.class);
		
		List<SeccionDto> secciones = empleadoService.getAllSecciones();			
		for (SeccionDto seccion: secciones) {
			builder.add(seccion, seccion.getNombreSeccion());
		}
		
		this.setSeccionesSelectItems(builder.buildList());

		this.setSelectedSeccion(secciones.get(0));
				
		this.setSelectedSemana(Calendar.getInstance().getTime());
		
		this.setDialogoEdicionHorarioVisible(false);
		
	}
	
	
	public List<HorarioSemanaUbicacionDto> getHorariosSemanasUbicaciones() throws ParseException {
		
		HorarioService horarioService = FacesUtils.getService("horarioService", HorarioService.class);
		
		// Si no hay una semana seleccionada se muestra la semana actual
		if (this.getSelectedSemana() == null){			
			this.setSelectedSemana(Calendar.getInstance().getTime());			
		}

		if (horariosSemanasUbicaciones == null) {			
			horariosSemanasUbicaciones = horarioService.getHorariosSeccionSemana(this.getSelectedSeccion().getIdSeccion(), this.getSelectedSemana());
		}		
		
		return horariosSemanasUbicaciones;
	}

	public void setHorariosSemanasUbicaciones(List<HorarioSemanaUbicacionDto> horariosSemanasUbicaciones) {
		this.horariosSemanasUbicaciones = horariosSemanasUbicaciones;
	}	
	
	
	


	public List<SelectItem> getSeccionesSelectItems() {
		return seccionesSelectItems;
	}


	public void setSeccionesSelectItems(List<SelectItem> seccionesSelectItems) {
		this.seccionesSelectItems = seccionesSelectItems;
	}
	

	public SeccionDto getSelectedSeccion() {
		return selectedSeccion;
	}


	public void setSelectedSeccion(SeccionDto selectedSeccion) {
		this.selectedSeccion = selectedSeccion;
	}


	public void seccionChangeListener(AjaxBehaviorEvent event) {		
		
		// Cuando se selecciona una nueva seccion se resetean los horariosSemanasUbicaciones para que se recalculen
		horariosSemanasUbicaciones = null;
	}
	

	public void semanaChangeListener(AjaxBehaviorEvent event) {		
		
		// Cuando se selecciona una nueva semana se resetean los horariosSemanasUbicaciones para que se recalculen
		horariosSemanasUbicaciones = null;
	}	
	
	public void mostrarSemanaAnterior() {
				
		LocalDate previusWeek = (new LocalDate(getSelectedSemana())).minusWeeks(1).withDayOfWeek(DateTimeConstants.MONDAY);		
		this.setSelectedSemana(previusWeek.toDate());
		
		horariosSemanasUbicaciones = null;
		
	}
	
	public void mostrarSemanaSiguiente() {
		
		LocalDate previusWeek = (new LocalDate(getSelectedSemana())).plusWeeks(1).withDayOfWeek(DateTimeConstants.MONDAY);		
		this.setSelectedSemana(previusWeek.toDate());
		
		horariosSemanasUbicaciones = null;
		
	}	
	
	
	public HorasDiaDto getSelectedHorasDia() {
		return selectedHorasDia;
	}

	public void setSelectedHorasDia(HorasDiaDto selectedHorasDia) {
		this.selectedHorasDia = selectedHorasDia;
	}
	

	public HorasDiaDto getHorasDiaEdicion() {
		
		if (horasDiaEdicion == null)
			horasDiaEdicion = new HorasDiaDto();
		
		return horasDiaEdicion;
	}


	public void setHorasDiaEdicion(HorasDiaDto horasDiaEdicion) {
		this.horasDiaEdicion = horasDiaEdicion;
	}


	public void rowSelectListener(AjaxBehaviorEvent event) {

		//Clona el selecteHorarioDia para crear el HorarioDiaEdicion para editar en el dialog.
		this.setHorasDiaEdicion(this.getSelectedHorasDia().clone());
		this.setDialogoEdicionHorarioVisible(true);
	}		
	
	
	public void aceptarHorarioDiaEdicion() {
		
		// TODO:Guarda los cambios del horarioDiaEdicion en BD
		
		this.setSelectedHorasDia(horasDiaEdicion);
	}
	
	
	
	
	public Date getSelectedSemana() {
		
		return selectedSemana;
	}


	public void setSelectedSemana(Date selectedSemana) {
		this.selectedSemana = selectedSemana;
	}





	public Date getDiaInicioSemana() throws ParseException {		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getSelectedSemana());
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		
		return cal.getTime();		
	}
	
	
	public Date getDiaFinSemana() throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getSelectedSemana());
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()+6);
				
		return cal.getTime();
	}
	

	public void updateCambio(ActionEvent event){
		
		//CambioService cambioService = FacesUtils.getService("cambioService", CambioService.class);
		
		//cambioService.updateMunicipio(selectedMunicipio);		
		
		FacesUtils.setInfoMessage(null, "detalleCambio_cambioActualizado", null);
	}




	public List<SelectItem> getSustitutosSelectItems() {
			
		
		if (sustitutosSelectItems == null) {
			
			// Crea los selectItems de categorias
			SelectItemsBuilder builder = new SelectItemsBuilder(); 
			
			EmpleadoService empleadoService = FacesUtils.getService("empleadoService", EmpleadoService.class);
			
			List<EmpleadoDto> empleadosSustitutos = empleadoService.getAllEmpleados();
			for (EmpleadoDto sustituto: empleadosSustitutos) {
				builder.add(sustituto, sustituto.getNombreCompleto());
			}
			
			this.setSustitutosSelectItems(builder.buildList());
	
		}
		
		return sustitutosSelectItems;
	}


	public void setSustitutosSelectItems(List<SelectItem> sustitutosSelectItems) {
		this.sustitutosSelectItems = sustitutosSelectItems;
	}
	

	public List<SelectItem> getProduccionesSelectItems() {
		
		if (this.produccionesSelectItems == null) {
			SelectItemsBuilder builder = new SelectItemsBuilder();
			 
			EmpleadoService empleadoService = FacesUtils.getService("empleadoService", EmpleadoService.class);
	
	
			List<ProduccionDto> producciones = empleadoService.getAllProducciones();			
			for (ProduccionDto produccion: producciones) {
				builder.add(produccion, produccion.getNombreProduccion());
			}
			
			this.setProduccionesSelectItems(builder.buildList());
		}		
		
		return produccionesSelectItems;
	}




	public void setProduccionesSelectItems(List<SelectItem> produccionesSelectItems) {
		this.produccionesSelectItems = produccionesSelectItems;
	}


	public boolean isDialogoEdicionHorarioVisible() {
		return dialogoEdicionHorarioVisible;
	}


	public void setDialogoEdicionHorarioVisible(boolean dialogoEdicionHorarioVisible) {
		this.dialogoEdicionHorarioVisible = dialogoEdicionHorarioVisible;
	}	

	
	
	
}
