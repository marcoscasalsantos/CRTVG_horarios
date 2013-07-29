package com.plexus.crtvgHorarios.dataAccess.dao.horario;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.jdbc.core.RowMapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.DefinicionHorarioPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.ExcepcionHorarioPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;

public class ExcepcionHorarioRowMapper implements RowMapper<ExcepcionHorarioPojo> {	
		
    public ExcepcionHorarioPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
            ExcepcionHorarioPojo excepcionHorario = new ExcepcionHorarioPojo();
                        
            excepcionHorario.setCodigoEstadoContratoSustituto(rs.getInt("codigoEstadoContratoSustituto"));
            if(rs.wasNull())
            	excepcionHorario.setCodigoEstadoContratoSustituto(null);
                        
            excepcionHorario.setColorExcepcion(rs.getString("colorExcepcion"));
            excepcionHorario.setDescripcionExcepcion(rs.getString("descripcionExcepcion"));
            excepcionHorario.setIdEstado(rs.getString("idEstado"));
            
            excepcionHorario.setIdExcepcionHorario(rs.getLong("idExcepcionHorario"));
            if(rs.wasNull())
            	excepcionHorario.setIdExcepcionHorario(null);
            
            excepcionHorario.setIdSustituto(rs.getString("idSustituto"));
                                    
            return excepcionHorario;
    }    	

}
