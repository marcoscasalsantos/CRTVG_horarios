package com.plexus.crtvgHorarios.view.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "menuBarBean")
@SessionScoped
public class MenuBarBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public String goHorariosUbicacionesSeccion() {
		return "horariosUbicacionesSeccion";
	}	
	
	public String goHorarioAnualEmpleado() {
		return "horarioAnualEmpleado";
	}	
	
}
