package com.plexus.crtvgHorarios.dto.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.plexus.crtvgHorarios.dto.common.BaseDto;

public class UserDto extends BaseDto implements UserDetails, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String name;
	private String surnames;

	private String username;
	private String password;
	private String nif;
		
	private List<RoleDto> roles;
	
	// Este atributo se utiliza para cachear los authorities mejorando la eficiencia
	// del método getAuthorities de la interfaz UserDetails.
	// los parámetros roles y authorities deben estar sincronizados.
	private ArrayList<GrantedAuthority> authorities;
	
	private Date birthDate;
	
	private boolean enabled;
	
	private boolean blocked;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurnames() {
		return surnames;
	}
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public List<RoleDto> getRoles() {
		return roles;
	}
	

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
		
		// Para que los atributos roles y auhorities est#n sincronizados
		// se resetea las suthorities con lo que se volver#n a generar 
		// a partir de los roles
		this.authorities = null;
	}	
	
	
		
	/********	METODOS DE LA INTERFAZ UserDetails usado por spring-security **************/
	
	/**
	 * Metodo de la interfaz UserDetails usado por spring-security
	 * 
	 * Devuelve la lista de authorities a partir de la transformaci#n de los roles para evitar inconsistencias
	 * 
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
			 
		if (authorities == null) {
		
			if (roles != null && !roles.isEmpty()) {
				authorities = new ArrayList<GrantedAuthority>();
				for (RoleDto role: roles) {
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRolename());
					authorities.add(grantedAuthority);
				}			
			}
		}
				
		return authorities;
	}

	/**
	 * Metodo de la interfaz UserDetails usado por spring-security
	 */
	public boolean isAccountNonExpired() {
		return true;
	}
	
	/**
	 * Metodo de la interfaz UserDetails usado por spring-security
	 */

	public boolean isAccountNonLocked() {
		return !blocked;
	}

	/**
	 * Metodo de la interfaz UserDetails usado por spring-security
	 */
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	/**
	 * Metodo de la interfaz UserDetails usado por spring-security
	 */
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getFullName() {
		
		String fullName = "";
		
		if (name != null)
			fullName = fullName.concat(name);
		
		if (surnames != null) {			
			fullName = fullName.concat((", " + surnames));
		}
		
		return fullName;
	}
	
}
