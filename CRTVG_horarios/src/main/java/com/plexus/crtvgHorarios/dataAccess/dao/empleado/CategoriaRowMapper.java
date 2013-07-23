package com.plexus.crtvgHorarios.dataAccess.dao.empleado;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.jdbc.core.RowMapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;

public class CategoriaRowMapper implements RowMapper<CategoriaPojo> {	
		
    public CategoriaPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
            CategoriaPojo categoria = new CategoriaPojo();
                     
            categoria.setIdCategoria(rs.getString("categoria"));
                                    
            categoria.setNombreCategoria(rs.getString("categoria"));
            if (!StringUtils.isEmpty(categoria.getNombreCategoria())) {            	            	
            	categoria.setNombreCategoria(WordUtils.capitalizeFully(categoria.getNombreCategoria()));           	 
            }
                                    
            return categoria;
    }    	

}