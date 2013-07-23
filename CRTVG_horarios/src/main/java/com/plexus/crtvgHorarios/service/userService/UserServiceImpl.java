package com.plexus.crtvgHorarios.service.userService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plexus.crtvgHorarios.dataAccess.dao.user.RoleDao;
import com.plexus.crtvgHorarios.dataAccess.dao.user.UserDao;
import com.plexus.crtvgHorarios.dataAccess.pojo.RolePojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UserPojo;
import com.plexus.crtvgHorarios.dto.users.RoleDto;
import com.plexus.crtvgHorarios.dto.users.UserDto;



/**
 * Implementaci#n de la interfaz {@link org.springframework.security.core.userdetails.UserDetailsService} 
 * de Spring-Security.
 */

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Resource
	private UserDao userDao;
	//No need of a setter anymore. Spring can inject the resorce.
	
	
	@Resource
	private RoleDao roleDao;	

	
	@Autowired
	private Mapper mapper;	
	
	
	

	@Transactional(readOnly = true)
	public UserDto getUser(Long userId) {
		
		UserPojo userPojo = userDao.getUser(userId);
		
		return new UserPojo2UserDto(mapper).transform(userPojo);
		
	}
	
	/**
	 * Implementación del método de la la interfaz {@link org.springframework.security.core.userdetails.UserDetailsService} 
	 * de Spring-Security.
	 * <p>
	 * Devuelve el user de BD indicado por <code>username</code> con los roles cargados.
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService
	 */	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Carga los datos del usuario 
		UserPojo userPojo = userDao.getUserByUsername(username);
		
		UserDto userDto = new UserPojo2UserDto(mapper).transform(userPojo);
		
		
		// Carga los roles asociados al usuario
		List<RolePojo> rolesPojos = roleDao.getRolesByUserId(userDto.getUserId());		
		List<RoleDto> rolesDtos = new ArrayList<RoleDto>();
		for (RolePojo rolePojo: rolesPojos){
	            rolesDtos.add(new RolePojo2RoleDto(mapper).transform(rolePojo));
	        }
		
		userDto.setRoles(rolesDtos);
						
		return userDto; 
	}	
	
	@Transactional(readOnly = true)
	public UserDto getUserByUsername(String username) throws UsernameNotFoundException {

		UserPojo userPojo = userDao.getUserByUsername(username);
		
		return new UserPojo2UserDto(mapper).transform(userPojo);
	}
	

	@Transactional
	public UserDto insertUser(UserDto userDto) {

		UserPojo userPojo = new UserDto2UserPojo(mapper).transform(userDto);
		
		
		// userPojo despues de insertar contendrá el attributo userId seteado
		userPojo = userDao.insertUser(userPojo); 
				
		return new UserPojo2UserDto(mapper).transform(userPojo); 
	}

	/**
	 * Actualiza en BD el usuario y sus relaciones usuario_roles
	 */
	@Transactional
	public void updateUser(UserDto userDto){
				
		UserPojo userPojo = new UserDto2UserPojo(mapper).transform(userDto);
				
		userDao.updateUser(userPojo);
		
		List<RoleDto> rolesDtos = userDto.getRoles();
		List<RolePojo> rolesPojos = new ArrayList<RolePojo>();
		for (RoleDto roleDto: rolesDtos) {			
			rolesPojos.add(new RoleDto2RolePojo(mapper).transform(roleDto));
		}
		
		roleDao.updateRolesbyUserId(userDto.getUserId(), rolesPojos);
	}

	@Transactional(readOnly = true)
	public List<UserDto> getAllUsers() {

		List<UserPojo> usersPojos = userDao.getAllUsers(); 
		List<UserDto> usersDtos = new ArrayList<UserDto>();
		for (UserPojo userPojo: usersPojos) {
			usersDtos.add(new UserPojo2UserDto(mapper).transform(userPojo));
		}
		
		return usersDtos;
	}

	
	/**
	 * borra el usuario y las relaciones usuario_rol pero no los roles
	 */
	@Transactional
	public void deleteUserById(Long userId){
		
		userDao.deleteUserById(userId);
		
	}

	@Transactional(readOnly = true)
	public List<RoleDto> getAllRoles() {

		 
		List<RolePojo> rolesPojos =  roleDao.getAllRoles();
		List<RoleDto> rolesDtos = new ArrayList<RoleDto>();		
		
		for (RolePojo rolePojo: rolesPojos) {
			rolesDtos.add(new RolePojo2RoleDto(mapper).transform(rolePojo));
		}
				
		return rolesDtos;
	}

	@Transactional(readOnly = true)
	public List<RoleDto> getAvaliableAndNotGrantedRoles(Long userId) {

		List<RolePojo> rolesPojos = roleDao.getRolesNotGrantedToUser(userId);
		
		List<RoleDto> rolesDtos = new ArrayList<RoleDto>();		
		
		for (RolePojo rolePojo: rolesPojos) {
			rolesDtos.add(new RolePojo2RoleDto(mapper).transform(rolePojo));
		}
				
		return rolesDtos;		
	}

	@Transactional(readOnly = true)
	public List<RoleDto> getRolesByUserId(Long userId) {

		List<RolePojo> rolesPojos = roleDao.getRolesByUserId(userId);
		
		List<RoleDto> rolesDtos = new ArrayList<RoleDto>();		
		
		for (RolePojo rolePojo: rolesPojos) {
			rolesDtos.add(new RolePojo2RoleDto(mapper).transform(rolePojo));
		}
				
		return rolesDtos;		
	}
		

}
