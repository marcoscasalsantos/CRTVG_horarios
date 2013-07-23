package com.plexus.crtvgHorarios.dataAccess.dao.empleado;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.jdbc.core.RowMapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.ProduccionPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UbicacionPojo;

public class ProduccionRowMapper implements RowMapper<ProduccionPojo> {	
		
    public ProduccionPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
            ProduccionPojo produccion = new ProduccionPojo();
             
            produccion.setFamiliaProduccion(rs.getString("familiaProduccion"));
            produccion.setIdProduccion(rs.getString("idProduccion"));
            
            produccion.setNombreProduccion(rs.getString("nombreProduccion"));
            if (!StringUtils.isEmpty(produccion.getNombreProduccion())) {            	            	
            	produccion.setNombreProduccion(WordUtils.capitalizeFully(produccion.getNombreProduccion()));           	 
            }
                                                
            return produccion;
    }    	

}