package com.plexus.crtvgHorarios.dataAccess.dao.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.plexus.crtvgHorarios.dataAccess.dao.common.BaseDao;
import com.plexus.crtvgHorarios.dataAccess.dao.horario.UnidadHorarioRowMapper;
import com.plexus.crtvgHorarios.dataAccess.pojo.RolePojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;

@Repository
public class RoleDaoImpl extends BaseDao implements RoleDao {
	
	
    private static final String SQL_SELECT_BY_USER_ID = 
    		" select * from users_roles rur " + 
    		" inner join roles r on rur.role_id = r.role_id and rur.user_id = ? ";
	

	@Override
	public List<RolePojo> getRolesByUserId(Long userId) {

		List<RolePojo> roles = new ArrayList<RolePojo>();
		
		Object[] parameters = {userId};
		
		roles = super.jdbcTemplate.query(SQL_SELECT_BY_USER_ID, parameters, new RoleRowMapper());		
				
		return roles;
	}

	@Override
	public List<RolePojo> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolePojo> getRolesNotGrantedToUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRolesbyUserId(Long userId, List<RolePojo> rolesPojos) {
		// TODO Auto-generated method stub
		
	}

    
	
}
