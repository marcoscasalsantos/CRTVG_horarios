package com.plexus.crtvgHorarios.dataAccess.dao.horario;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.jdbc.core.RowMapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.DefinicionHorarioPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;

public class DefinicionHorarioRowMapper implements RowMapper<DefinicionHorarioPojo> {	
		
    public DefinicionHorarioPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
            DefinicionHorarioPojo definicionHorario = new DefinicionHorarioPojo();
                        
            
            definicionHorario.setIdDefinicionHorario(rs.getLong("idDefinicionHorario"));
            if(rs.wasNull())
            	definicionHorario.setIdDefinicionHorario(null);
            
            definicionHorario.setIdEmpleado(rs.getString("idEmpleado"));            
                                    
            definicionHorario.setFechaDesde(rs.getDate("fechaDesde"));
            definicionHorario.setFechaHasta(rs.getDate("fechaHasta"));
            
            definicionHorario.setAplicarLunes(rs.getBoolean("aplicarLunes"));
            definicionHorario.setAplicarMartes(rs.getBoolean("aplicarMartes"));
            definicionHorario.setAplicarMiercoles(rs.getBoolean("aplicarMiercoles"));
            definicionHorario.setAplicarJueves(rs.getBoolean("aplicarJueves"));
            definicionHorario.setAplicarViernes(rs.getBoolean("aplicarViernes"));
            definicionHorario.setAplicarSabado(rs.getBoolean("aplicarSabado"));
            definicionHorario.setAplicarDomingo(rs.getBoolean("aplicarDomingo"));
            
            definicionHorario.setNombreProduccion(rs.getString("nombreProduccion"));
            if (!StringUtils.isEmpty(definicionHorario.getNombreProduccion())) {            	            	
            	definicionHorario.setNombreProduccion(WordUtils.capitalizeFully(definicionHorario.getNombreProduccion()));
            }            
            
            definicionHorario.setNombreUbicacion(rs.getString("nombreUbicacion"));
            if (!StringUtils.isEmpty(definicionHorario.getNombreUbicacion())) {            	            	
            	definicionHorario.setNombreUbicacion(WordUtils.capitalizeFully(definicionHorario.getNombreUbicacion()));
            }            
            
            definicionHorario.setNumSemanasAlternancia(rs.getInt("numSemanasAlternancia"));
            if(rs.wasNull())
            	definicionHorario.setNumSemanasAlternancia(null);
            
            definicionHorario.setHoraDesde(rs.getTime("horaDesde"));
            definicionHorario.setHoraHasta(rs.getTime("horaHasta"));
            
            definicionHorario.setIdUbicacion(rs.getString("idUbicacion"));
            definicionHorario.setIdProduccion(rs.getString("idProduccion"));
            
            definicionHorario.setColorHorario(rs.getString("colorHorario"));
                        
            return definicionHorario;
    }    	

}
