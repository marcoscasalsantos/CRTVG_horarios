package com.plexus.crtvgHorarios.view.managedBeans.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DualListModel;

import com.plexus.crtvgHorarios.dto.users.RoleDto;
import com.plexus.crtvgHorarios.dto.users.UserDto;
import com.plexus.crtvgHorarios.service.userService.UserService;
import com.plexus.crtvgHorarios.view.common.FacesUtils;

@ManagedBean(name = "userBean")
@SessionScoped
public class UsuarioBean implements Serializable {

	//TODO este bean deber#a tener ViewScoped, pero falta pasar el selectedUsuario entre las vistas de usuario y detalleUsuario 
	private static final long serialVersionUID = 1L;

	private List<UserDto> users;
	
	private UserDto selectedUser; // Al añadir un nuevo usuario el selectedUser será el nuevo usuario
	
	private DualListModel<RoleDto> avaliableAndSelectedRoles;

	private String repeatedPassword; //Password que debe repetir el usuario para evitar que lo introzca mal sin darse cuenta
	


	public List<UserDto> getUsers() {
		
		if (users == null) {
			UserService userService = FacesUtils.getService("userService", UserService.class);
			
			users = userService.getAllUsers();
		}
		
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}
	
	public UserDto getSelectedUser() {		
		return selectedUser;
	}

	public void setSelectedUser(UserDto selectedUser) {
		this.selectedUser = selectedUser;
	}

	public String goUserDetail() {
		
		//Resetea el atributo avaliableAndSelectedRoles para que se recalcule para el selectedUser
		avaliableAndSelectedRoles = null;
		this.repeatedPassword = selectedUser.getPassword();
		
		return "detalleUsuario";
	}
	
		
	public DualListModel<RoleDto> getAvaliableAndSelectedRoles() {
		
		if (selectedUser != null && avaliableAndSelectedRoles == null) {
						
			UserService userService = FacesUtils.getService("userService", UserService.class);
			
			List<RoleDto> avaliableAndNotGrantedRoles = userService.getAvaliableAndNotGrantedRoles(selectedUser.getUserId());
			
			selectedUser.setRoles(userService.getRolesByUserId(selectedUser.getUserId()));
			
			avaliableAndSelectedRoles = new DualListModel<RoleDto>(avaliableAndNotGrantedRoles, selectedUser.getRoles());					
		}

		return avaliableAndSelectedRoles;
	}
	
	public void setAvaliableAndSelectedRoles(DualListModel<RoleDto> avaliableAndSelectedRoles) {
		
		selectedUser.setRoles(avaliableAndSelectedRoles.getTarget());
		
		this.avaliableAndSelectedRoles = avaliableAndSelectedRoles;
	}
	
	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}	
	
	

	public void updateUser(ActionEvent event){
		
		UserService userService = FacesUtils.getService("userService", UserService.class);
		
		userService.updateUser(selectedUser);
		
		FacesUtils.setInfoMessage(null, "detalleUsurio_usuarioActualizado", null);
		
	}
	
	
	public String goMainMenu() {				
		return "menuPrincipal";
	}	
	
	
	public void deleteUser(ActionEvent event){
		
		UserService userService = FacesUtils.getService("userService", UserService.class);
		
		userService.deleteUserById(selectedUser.getUserId());
		users.remove(selectedUser);
		
	}	
	
	public String goNewUser() {
		
		selectedUser = new UserDto();		
		selectedUser.setRoles(new ArrayList<RoleDto>());
				
		UserService userService = FacesUtils.getService("userService", UserService.class);		
		avaliableAndSelectedRoles = new DualListModel<RoleDto>(userService.getAllRoles(), selectedUser.getRoles());
				
		return "nuevoUsuario";
	}
	
	public void insertUser(ActionEvent event){
		
		UserService userService = FacesUtils.getService("userService", UserService.class);
		
		selectedUser = userService.insertUser(selectedUser);
		users.add(selectedUser);
		
		FacesUtils.setInfoMessage(null, "detalleUsuario_usuarioInsertado", null);
		
		
		
		
	}	
	
}
