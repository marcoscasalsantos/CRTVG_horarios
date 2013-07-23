package com.plexus.crtvgHorarios.dataAccess.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.RolePojo;

public class RoleRowMapper implements RowMapper<RolePojo> {	
		
    public RolePojo mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
            RolePojo role = new RolePojo();
            
            role.setRoleId(rs.getLong("role_id"));
            if(rs.wasNull())role.setRoleId(null);
            
            role.setRolename(rs.getString("role_name"));
            
            return role;
    }    	

}
