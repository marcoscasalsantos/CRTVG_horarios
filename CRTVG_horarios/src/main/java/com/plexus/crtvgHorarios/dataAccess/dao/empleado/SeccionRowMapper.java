package com.plexus.crtvgHorarios.dataAccess.dao.empleado;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.jdbc.core.RowMapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.SeccionPojo;

public class SeccionRowMapper implements RowMapper<SeccionPojo> {	
		
    public SeccionPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
            SeccionPojo seccion = new SeccionPojo();
                     
            seccion.setIdSeccion(rs.getLong("idSeccion"));
                                    
            seccion.setNombreSeccion(rs.getString("nombreSeccion"));
                                    
            return seccion;
    }    	

}