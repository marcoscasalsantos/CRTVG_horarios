package com.plexus.crtvgHorarios.dataAccess.dao.empleado;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.jdbc.core.RowMapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.EmpleadoPojo;

public class EmpleadoRowMapper implements RowMapper<EmpleadoPojo> {	
		
    public EmpleadoPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
            EmpleadoPojo empleado = new EmpleadoPojo();
                     
            empleado.setApellido1(rs.getString("apellido1"));
            if (!StringUtils.isEmpty(empleado.getApellido1())) {            	            	
            	empleado.setApellido1(WordUtils.capitalizeFully(empleado.getApellido1()));           	 
            }

            
            empleado.setApellido2(rs.getString("apellido2"));
            if (!StringUtils.isEmpty(empleado.getApellido2())) {            	            	
            	empleado.setApellido2(WordUtils.capitalizeFully(empleado.getApellido2()));           	 
            }

            
            empleado.setIdCategoria(rs.getString("idCategoria"));            
            empleado.setIdEmpleado(rs.getString("idEmpleado"));
            
            empleado.setNombre(rs.getString("nombre"));
            if (!StringUtils.isEmpty(empleado.getNombre())) {            	            	
            	empleado.setNombre(WordUtils.capitalizeFully(empleado.getNombre()));           	 
            }
                                    
            return empleado;
    }    	

}