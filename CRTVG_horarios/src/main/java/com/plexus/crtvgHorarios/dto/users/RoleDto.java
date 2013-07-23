package com.plexus.crtvgHorarios.dto.users;

import java.io.Serializable;

import com.plexus.crtvgHorarios.dto.common.BaseDto;

public class RoleDto extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long roleId;
	private String rolename;
	private Long parentId;

	
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
}
