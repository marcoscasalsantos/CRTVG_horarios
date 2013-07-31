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
	
	
	public String goUsuarios() {
		
		//TODO: ir a donde tiene que ir
		return null;
	}	
	
	public String goPerfiles() {
		
		//TODO: ir a donde tiene que ir
		return null;
	}	
	
	public String goDatosMaestros() {
		
		//TODO: ir a donde tiene que ir
		return null;
	}	
	
	
}
