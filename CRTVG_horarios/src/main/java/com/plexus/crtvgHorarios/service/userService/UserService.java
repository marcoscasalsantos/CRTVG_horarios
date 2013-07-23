package com.plexus.crtvgHorarios.service.userService;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.plexus.crtvgHorarios.dto.users.RoleDto;
import com.plexus.crtvgHorarios.dto.users.UserDto;



public interface UserService {
	
	/****** USUARIO ********/
	
	public UserDto getUser(Long userId);
	
	public UserDto getUserByUsername(String username) throws UsernameNotFoundException;

	public UserDto insertUser(UserDto user);

	public void updateUser(UserDto user);
	
	/**
	 * Borra el usuario indicado eliminando adem#s las relaciones usuario-roles que tuviese
	 * @param userId
	 */
	public void deleteUserById(Long userId);
	
	public List<UserDto> getAllUsers();
	
	
	/****** ROLES ********/
	
	/**
	 * Devuelve todos los roles
	 * @return todos los roles de BD
	 */
	public List<RoleDto> getAllRoles();
	
	public List<RoleDto> getRolesByUserId(Long userId);
	
	/**
	 * Obtiene la lista de todos los roles disponibles en BD exceptuando los roles ya vinculados al usuario indicado
	 * @param userId
	 * @return lista de roles disponibles que no est#n vinculados al usuario
	 */
	public List<RoleDto> getAvaliableAndNotGrantedRoles(Long userId);
	
	
}