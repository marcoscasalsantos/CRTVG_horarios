package com.plexus.crtvgHorarios.dataAccess.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.UserPojo;

public class UserRowMapper implements RowMapper<UserPojo> {	
		
    public UserPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
            UserPojo user = new UserPojo();
                        
            user.setBirthDate(rs.getDate("birth_date"));
            user.setBlocked(rs.getBoolean("blocked"));
            user.setEnabled(rs.getBoolean("enabled"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            
            user.setUserId(rs.getLong("user_id"));
            if(rs.wasNull())user.setUserId(null);
            
            user.setUsername(rs.getString("username"));
            user.setSurnames(rs.getString("surnames"));
                        
            return user;
    }    	

}