package com.plexus.crtvgHorarios.dataAccess.dao.user;

import java.util.List;

import com.plexus.crtvgHorarios.dataAccess.pojo.RolePojo;



public interface RoleDao {

	public List<RolePojo> getRolesByUserId(Long userId);
	
	public List<RolePojo> getAllRoles();

	public List<RolePojo> getRolesNotGrantedToUser(Long userId);

	public void updateRolesbyUserId(Long userId, List<RolePojo> rolesPojos);
	   	
}
