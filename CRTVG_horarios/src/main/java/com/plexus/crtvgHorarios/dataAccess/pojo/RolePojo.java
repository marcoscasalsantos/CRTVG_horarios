package com.plexus.crtvgHorarios.dataAccess.pojo;

import com.plexus.crtvgHorarios.dataAccess.pojo.common.BasePojo;


/*
		name = "getRolesByUserId",
		
		query = " SELECT R.* " +
				" FROM ROLE R, R_USER_ROLE RUR" +
				" WHERE R.ROLE_ID = RUR.ROLE_ID " +
				" AND RUR.USER_ID = :userId ",
				
		resultClass = RolePojo.class
	),
		
	@NamedNativeQuery(
		name = "getRolesNotGrantedToUser",
		
		
		query = " SELECT ROLE.* FROM ROLE " +
				" WHERE ROLE_ID NOT IN " +
				" (SELECT DISTINCT ROLE_ID FROM R_USER_ROLE WHERE USER_ID = :userId) ",
				
		resultClass = RolePojo.class

*/

public class RolePojo extends BasePojo{
	
	
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
