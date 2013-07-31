package com.plexus.crtvgHorarios.view.managedBeans.horarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import org.omnifaces.util.selectitems.SelectItemsBuilder;
import org.primefaces.event.RowEditEvent;

import com.plexus.crtvgHorarios.dto.categorias.CategoriaDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.DefinicionHorarioDto;
import com.plexus.crtvgHorarios.dto.horarios.HorarioAnualEmpleadoDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;
import com.plexus.crtvgHorarios.service.empleadoService.EmpleadoService;
import com.plexus.crtvgHorarios.service.horarioService.HorarioService;
import com.plexus.crtvgHorarios.view.common.FacesUtils;



@ManagedBean(name = "horarioAnualBean")
@ViewScoped
public class HorarioAnualBean implements Serializable {
 
	private static final long serialVersionUID = 1L; 
	
	private List<SelectItem> categoriasSelectItems;
	private CategoriaDto selectedCategoria;	
	
	private List<SelectItem> empleadosSelectItems;
	private EmpleadoDto selectedEmpleado;
	
	private List<SelectItem> anhosSelectItems;
	private Integer selectedAnho;

	private HorarioAnualEmpleadoDto horarioAnual;
		
	private List<SelectItem> ubicacionesSelectItems;
	private CategoriaDto selectedUbicacion;
	
	private boolean botonAplicarCambiosDefinicionHorarioVisible;	
	private boolean panelNuevaDefinicionHorarioVisible;
	private boolean botonGuardarVisible;
	
	private DefinicionHorarioDto definicionHorario;
	
	private List<SelectItem> produccionesSelectItems;
	private ProduccionDto selectedProduccion;
	
	private List<SelectItem> numSemanasAlternanciaSelectItems;
		
	private long idNuevaDefinicionHorario = 0; //Ese id se utilizará para identificar la definicionHorario mientras que no se persista en BD.
	
	private DefinicionHorarioDto selectedDefinicionHorario;
	
	@PostConstruct
	private void postConstrut(){

		panelNuevaDefinicionHorarioVisible = false;
		botonAplicarCambiosDefinicionHorarioVisible = false;
		botonGuardarVisible = true;
	
		SelectItem selectItem0 = new SelectItem(null, "Todas as semanas");
		SelectItem selectItem1 = new SelectItem(new Integer(2), "Semanas alternas");
		SelectItem selectItem2 = new SelectItem(new Integer(3), "Cada 3 semanas");
		SelectItem selectItem3 = new SelectItem(new Integer(4), "Cada 4 semanas");
		
		numSemanasAlternanciaSelectItems = new ArrayList<SelectItem>();
		numSemanasAlternanciaSelectItems.add(selectItem0);
		numSemanasAlternanciaSelectItems.add(selectItem1);
		numSemanasAlternanciaSelectItems.add(selectItem2);
		numSemanasAlternanciaSelectItems.add(selectItem3);
		
		
		// Crea los selectItems de categorias
		SelectItemsBuilder builder = new SelectItemsBuilder(); 
		
		EmpleadoService empleadoService = FacesUtils.getService("empleadoService", EmpleadoService.class);
	
		
		List<CategoriaDto> categorias = empleadoService.getAllCategorias();			
		for (CategoriaDto categoria: categorias) {
			builder.add(categoria, categoria.getNombreCategoria());
		}
		
		this.setCategoriasSelectItems(builder.buildList());
		
		// Crea los selectItems de empleados
		builder = new SelectItemsBuilder();

		List<EmpleadoDto> empleados = empleadoService.getAllEmpleados();
		for (EmpleadoDto empleado: empleados) {
			builder.add(empleado, empleado.getNombreCompleto());
		}
		
		this.setEmpleadosSelectItems(builder.buildList());
		this.setSelectedEmpleado(empleados.get(0));
		
				
		// Crea los selectItems de empleados
		builder = new SelectItemsBuilder();				
		
		Calendar cal = Calendar.getInstance();
		Integer anhoActual = cal.get(Calendar.YEAR);
				
		builder.add(anhoActual, anhoActual.toString());

		this.setAnhosSelectItems(builder.buildList());
		this.setSelectedAnho(anhoActual);

		// Crea los selectItems de ubicaciones
		builder = new SelectItemsBuilder();

		List<UbicacionDto> ubicaciones = empleadoService.getAllUbicaciones();
		for (UbicacionDto ubicacion: ubicaciones) {
			builder.add(ubicacion, ubicacion.getNombreUbicacion());
		}
		
		this.setUbicacionesSelectItems(builder.buildList());		
	}
	
		
	public HorarioAnualEmpleadoDto getHorarioAnual() {
		
		if (this.horarioAnual == null) {
			
			HorarioService horarioService = FacesUtils.getService("horarioService", HorarioService.class);
															
			this.setHorarioAnual(horarioService.getHorarioAnualEmpleado(this.getSelectedAnho(), this.getSelectedEmpleado()));
		}
		
		return horarioAnual;
	}


	public void setHorarioAnual(HorarioAnualEmpleadoDto horarioAnual) {
		this.horarioAnual = horarioAnual;
	}

	
	public void categoriaChangeListener(AjaxBehaviorEvent event) {		
		
		// Cuando se selecciona una nueva categoria se resetea el empleado anho y horarioAnual
		this.empleadosSelectItems = null; // Al resetear los anhosSelectItems ya se asigna selectedEmpleado al empleado inicial		
		this.anhosSelectItems = null; // Al resetear los anhosSelectItems ya se asigna selectedAnho al año actual		
		this.horarioAnual = null;
		this.setPanelNuevaDefinicionHorarioVisible(false);
		
	}		
	
	public void empleadoChangeListener(AjaxBehaviorEvent event) {
						
		//Se resetea anhosSelectItems, el selectedAnho y los definicionesHorarios
		// Cuando se selecciona una nuevo empleado se resetean los horariosMensuales para que se recalculen
		anhosSelectItems = null;						
		horarioAnual = null;
		this.setPanelNuevaDefinicionHorarioVisible(false);		
	}
	

	public void anhoChangeListener(AjaxBehaviorEvent event) {		
		
		// Cuando se selecciona una nuevo anho se resetean los horariosMensuales para que se recalculen
		horarioAnual = null;
		this.setPanelNuevaDefinicionHorarioVisible(false);
	}	
	
	public void definicionHorarioChangeListener(AjaxBehaviorEvent event) {		
		
		// Cuando se modifica una definiciónHorario se muestra el botón para aplicar cambios				
		setBotonAplicarCambiosDefinicionHorarioVisible(true);
	}		
	
	
	public void definicionHorarioRowEditListener(RowEditEvent event) {
		
		DefinicionHorarioDto definicionHorarioEdicion = (DefinicionHorarioDto) event.getObject();
		
		HorarioService horarioService = FacesUtils.getService("horarioService", HorarioService.class);		
		this.setHorarioAnual(horarioService.actualizarHorasAnhoPorCambiosEnDefinicionHorario(definicionHorarioEdicion, this.getHorarioAnual()));
				
		this.setBotonGuardarVisible(true);
	}
	
		
	public void eliminarDefinicionHorario() {
				
		HorarioService horarioService = FacesUtils.getService("horarioService", HorarioService.class);
		this.setHorarioAnual(horarioService.actualizarHorasAnhoPorEliminarDefinicionHorario(this.getSelectedDefinicionHorario(), this.getHorarioAnual()));		
		
		this.setBotonGuardarVisible(true);
	}
	
	
	public void nuevaDefinicionHorario() {
		
		setPanelNuevaDefinicionHorarioVisible(true);		
		setDefinicionHorario(new DefinicionHorarioDto(this.getSelectedEmpleado()));
	}
	
	
	public void cancelarNuevaDefinicionHorario() {
		this.setDefinicionHorario(null);
		this.setPanelNuevaDefinicionHorarioVisible(false);
	}			
	
	// inserta el nuevoRangoHorario actualizando los datos de los dias del calendario anual.
	public void anhadirDefinicionHorario() {
				
		HorarioService horarioService = FacesUtils.getService("horarioService", HorarioService.class);
		
		if (this.getHorarioAnual().getDefinicionesHorarios() == null) {
			this.getHorarioAnual().setDefinicionesHorarios(new ArrayList<DefinicionHorarioDto>());
		}
		
		// Mientras que no se persista en BD la nuevaDefinicionHorario se establece un idDefinicionHorario provisional para identificarlo para la edición (será negativo -1, -2, -3...)
		DefinicionHorarioDto nuevaDefinicionHorario = this.getDefinicionHorario();
		nuevaDefinicionHorario.setIdDefinicionHorario(idNuevaDefinicionHorario--);
		
		this.setHorarioAnual(horarioService.actualizarHorasAnhoPorNuevaDefinicionHorario(this.getDefinicionHorario(), this.getHorarioAnual()));
		
		this.setDefinicionHorario(null);
		this.setPanelNuevaDefinicionHorarioVisible(false);
		this.setBotonGuardarVisible(true);		
	}
	
	
	public void guardarCambiosHorarioEmpleado() {
		
		// TODO: Verificar los datos y guardar los cambios introducidos		
		
		HorarioService horarioService = FacesUtils.getService("horarioService", HorarioService.class);
		
		horarioService.saveHorarioAnualEmpleado(this.getHorarioAnual(), this.getSelectedEmpleado().getIdEmpleado());
		
		FacesUtils.setInfoMessage(null, "horarioAnualEmpleado_horarioGuardado", null);
		
		
	}
	
	
	

	public void lunesEneroListener(AjaxBehaviorEvent event) {
		// TODO:
		// Cuando se selecciona un día se marca como "seleccionado" para aplicar los cambios que le correspondan		
		// Obtener el día correspondiente al botón pulsado, actualizar el atributo seleccionado a true y actualizar el botón (actualizar el style del background color) mediante ajax. javascript.
		
	}	
	
	
	
	public List<SelectItem> getNumSemanasAlternanciaSelectItems() {
		return numSemanasAlternanciaSelectItems;
	}


	public void setNumSemanasAlternanciaSelectItems(List<SelectItem> numSemanasAlternanciaSelectItems) {
		this.numSemanasAlternanciaSelectItems = numSemanasAlternanciaSelectItems;
	}


	public List<SelectItem> getCategoriasSelectItems() {
		return categoriasSelectItems;
	}




	public void setCategoriasSelectItems(List<SelectItem> categoriasSelectItems) {
		this.categoriasSelectItems = categoriasSelectItems;
	}

	




	public CategoriaDto getSelectedCategoria() {
		return selectedCategoria;
	}




	public void setSelectedCategoria(CategoriaDto selectedCategoria) {
		this.selectedCategoria = selectedCategoria;
	}




	public List<SelectItem> getEmpleadosSelectItems() {
		
		if (empleadosSelectItems == null) {
						
			SelectItemsBuilder builder = new SelectItemsBuilder(); 
			
			EmpleadoService empleadoService = FacesUtils.getService("empleadoService", EmpleadoService.class);
			
			List<EmpleadoDto> empleados = null;
			if (this.getSelectedCategoria() != null) {
				empleados = empleadoService.getAllEmpleadosByIdCategoria(this.getSelectedCategoria().getIdCategoria());
			}
			else {
				empleados = empleadoService.getAllEmpleados();
			}
			
			for (EmpleadoDto empleado: empleados) {
				builder.add(empleado, empleado.getNombreCompleto());
			}
			
			this.setEmpleadosSelectItems(builder.buildList());			
			this.setSelectedEmpleado(empleados.get(0));
		}
		
		return empleadosSelectItems;
	}
	
	public void setEmpleadosSelectItems(List<SelectItem> empleadosSelectItems) {
		this.empleadosSelectItems = empleadosSelectItems;
	}


	public EmpleadoDto getSelectedEmpleado() {
		return selectedEmpleado;
	}


	public void setSelectedEmpleado(EmpleadoDto selectedEmpleado) {
		this.selectedEmpleado = selectedEmpleado;
	}


	public List<SelectItem> getAnhosSelectItems() {
		
		if (anhosSelectItems == null){
			
			SelectItemsBuilder builder = new SelectItemsBuilder();
			EmpleadoService empleadoService = FacesUtils.getService("empleadoService", EmpleadoService.class);
						
			Integer anhoIniHorarios = empleadoService.getAnhoIniHorarios(this.getSelectedEmpleado().getIdEmpleado());
			Integer anhoFinHorarios = empleadoService.getAnhoFinHorarios(this.getSelectedEmpleado().getIdEmpleado());				
			
			Calendar cal = Calendar.getInstance();
			Integer anhoActual = cal.get(Calendar.YEAR);
					
			if (anhoIniHorarios != null && anhoFinHorarios != null) {
				for (Integer anho = anhoIniHorarios; anho <= anhoFinHorarios; anho++) {
					builder.add(anho, anho.toString());
				}
				
				// Si el anhoActual no está en el periodo [anhoIniHorarios, anhoFinHorarios] se añade el anhoActual al builder de SelectItems
				if (!(anhoIniHorarios <= anhoActual && anhoActual <= anhoFinHorarios)) {
					builder.add(anhoActual, anhoActual.toString());
				}			
			}
			else {
				builder.add(anhoActual, anhoActual.toString());
			}		
			
			this.setAnhosSelectItems(builder.buildList());
			this.setSelectedAnho(anhoActual);
		}
		
		return anhosSelectItems;
	}


	public void setAnhosSelectItems(List<SelectItem> anhosSelectItems) {
		this.anhosSelectItems = anhosSelectItems;
	}


	public Integer getSelectedAnho() {
		return selectedAnho;
	}


	public void setSelectedAnho(Integer selectedAnho) {
		this.selectedAnho = selectedAnho;
	}



	public List<SelectItem> getUbicacionesSelectItems() {
		return ubicacionesSelectItems;
	}


	public void setUbicacionesSelectItems(List<SelectItem> ubicacionesSelectItems) {
		this.ubicacionesSelectItems = ubicacionesSelectItems;
	}


	public CategoriaDto getSelectedUbicacion() {
		return selectedUbicacion;
	}


	public void setSelectedUbicacion(CategoriaDto selectedUbicacion) {
		this.selectedUbicacion = selectedUbicacion;
	}


	public boolean isBotonAplicarCambiosDefinicionHorarioVisible() {
		return botonAplicarCambiosDefinicionHorarioVisible;
	}


	public void setBotonAplicarCambiosDefinicionHorarioVisible(boolean botonAplicarCambiosDefinicionHorarioVisible) {
		this.botonAplicarCambiosDefinicionHorarioVisible = botonAplicarCambiosDefinicionHorarioVisible;
	}


	public boolean isPanelNuevaDefinicionHorarioVisible() {
		return panelNuevaDefinicionHorarioVisible;
	}


	public void setPanelNuevaDefinicionHorarioVisible(boolean panelNuevaDefinicionHorarioVisible) {
		this.panelNuevaDefinicionHorarioVisible = panelNuevaDefinicionHorarioVisible;
	}	


	public boolean isBotonGuardarVisible() {
		return botonGuardarVisible;
	}




	public void setBotonGuardarVisible(boolean botonGuardarVisible) {
		this.botonGuardarVisible = botonGuardarVisible;
	}




	public DefinicionHorarioDto getDefinicionHorario() {
		return definicionHorario;
	}


	public void setDefinicionHorario(DefinicionHorarioDto definicionHorario) {
		this.definicionHorario = definicionHorario;
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




	public ProduccionDto getSelectedProduccion() {
		return selectedProduccion;
	}




	public void setSelectedProduccion(ProduccionDto selectedProduccion) {
		this.selectedProduccion = selectedProduccion;
	}


	public DefinicionHorarioDto getSelectedDefinicionHorario() {
		return selectedDefinicionHorario;
	}


	public void setSelectedDefinicionHorario(DefinicionHorarioDto selectedDefinicionHorario) {
		this.selectedDefinicionHorario = selectedDefinicionHorario;
	}

	
	
	
	
}
