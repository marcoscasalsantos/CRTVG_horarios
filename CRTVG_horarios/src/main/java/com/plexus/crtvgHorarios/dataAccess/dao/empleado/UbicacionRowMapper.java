package com.plexus.crtvgHorarios.dataAccess.dao.empleado;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.jdbc.core.RowMapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UbicacionPojo;

public class UbicacionRowMapper implements RowMapper<UbicacionPojo> {	
		
    public UbicacionPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
            UbicacionPojo ubicacion = new UbicacionPojo();
             
            ubicacion.setFase(rs.getString("fase"));
            ubicacion.setIdUbicacion(rs.getString("idUbicacion"));
                                    
            ubicacion.setNombreUbicacion(rs.getString("nombreUbicacion"));
            if (!StringUtils.isEmpty(ubicacion.getNombreUbicacion())) {            	            	
            	ubicacion.setNombreUbicacion(WordUtils.capitalizeFully(ubicacion.getNombreUbicacion()));           	 
            }            
                                    
            return ubicacion;
    }    	

}