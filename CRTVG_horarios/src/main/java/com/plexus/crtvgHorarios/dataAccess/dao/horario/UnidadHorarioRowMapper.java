package com.plexus.crtvgHorarios.dataAccess.dao.horario;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.jdbc.core.RowMapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.UnidadHorarioPojo;

public class UnidadHorarioRowMapper implements RowMapper<UnidadHorarioPojo> {	
		
    public UnidadHorarioPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
            UnidadHorarioPojo unidadHorario = new UnidadHorarioPojo();
            
            unidadHorario.setApellido1Empleado(rs.getString("apellido1Empleado"));
            if (!StringUtils.isEmpty(unidadHorario.getApellido1Empleado())) {            	            	
            	 unidadHorario.setApellido1Empleado(WordUtils.capitalizeFully(unidadHorario.getApellido1Empleado()));            	
            }
            
            unidadHorario.setApellido2Empleado(rs.getString("apellido2Empleado"));
            if (!StringUtils.isEmpty(unidadHorario.getApellido2Empleado())) {            	            	
            	 unidadHorario.setApellido2Empleado(WordUtils.capitalizeFully(unidadHorario.getApellido2Empleado()));            	
            }
                       
            unidadHorario.setApellido1Sustituto(rs.getString("apellido1Sustituto"));
            if (!StringUtils.isEmpty(unidadHorario.getApellido1Sustituto())) {            	            	
            	unidadHorario.setApellido1Sustituto(WordUtils.capitalizeFully(unidadHorario.getApellido1Sustituto()));
            }
            
            unidadHorario.setApellido2Sustituto(rs.getString("apellido2Sustituto"));
            if (!StringUtils.isEmpty(unidadHorario.getApellido2Sustituto())) {            	            	
            	unidadHorario.setApellido2Sustituto(WordUtils.capitalizeFully(unidadHorario.getApellido2Sustituto()));
            }            
            
            unidadHorario.setCategoria(rs.getString("categoria"));
            
            unidadHorario.setColorExcepcion(rs.getString("colorExcepcion"));
            
            unidadHorario.setColorHorario(rs.getString("colorHorario"));
            
            unidadHorario.setDescripcionEstado(rs.getString("descripcionEstado"));
            
            unidadHorario.setDescripcionExcepcion(rs.getString("descripcionExcepcion"));            
            
            unidadHorario.setFamiliaProduccion(rs.getString("familiaProduccion"));
            unidadHorario.setFase(rs.getString("fase"));
            unidadHorario.setFechaDia(rs.getDate("fechaDia"));
            unidadHorario.setFestividad(rs.getString("festividad"));        
            
            //OJO!! Usar getTime para obtener la hora
            unidadHorario.setHoraDesde(rs.getTime("horaDesde"));
            unidadHorario.setHoraHasta(rs.getTime("horaHasta"));
            
            unidadHorario.setIdDefinicionHorario(rs.getLong("idDefinicionHorario"));
            if (rs.wasNull()){
            	unidadHorario.setIdDefinicionHorario(null);
            }
            
            unidadHorario.setIdUbicacionDefinicion(rs.getString("idUbicacionDefinicion"));            
            
            unidadHorario.setFechaDefinicionDesde(rs.getDate("fechaDefinicionDesde"));            
            unidadHorario.setFechaDefinicionHasta(rs.getDate("fechaDefinicionHasta"));            
            //OJO!! Usar getTime para obtener la hora
            unidadHorario.setHoraDefinicionDesde(rs.getTime("horaDefinicionDesde"));
            unidadHorario.setHoraDefinicionHasta(rs.getTime("horaDefinicionHasta"));            
                        
            unidadHorario.setIdEmpleado(rs.getString("idEmpleado"));
            
            unidadHorario.setIdEstado(rs.getString("idEstado"));
            
            unidadHorario.setIdExcepcionHorario(rs.getLong("idExcepcionHorario"));
            if (rs.wasNull()){
            	unidadHorario.setIdExcepcionHorario(null);
            }

            unidadHorario.setIdFestivo(rs.getLong("idFestivo"));
            if (rs.wasNull()){
            	unidadHorario.setIdFestivo(null);
            	unidadHorario.setFestivo(new Boolean(false));
            }
            else {
            	unidadHorario.setFestivo(new Boolean(true));
            }
                        
            unidadHorario.setIdHorasDia(rs.getLong("idHorasDia"));
            if(rs.wasNull())
            	unidadHorario.setIdHorasDia(null);
            
            unidadHorario.setIdProduccion(rs.getString("idProduccion"));
            
            unidadHorario.setIdProduccionDefinicion(rs.getString("idProduccionDefinicion"));
            
            unidadHorario.setIdSustituto(rs.getString("idSustituto"));                        
            unidadHorario.setIdUbicacion(rs.getString("idUbicacion"));
            unidadHorario.setNombreEmpleado(rs.getString("nombreEmpleado")); 
            if (!StringUtils.isEmpty(unidadHorario.getNombreEmpleado())) {            	            	
            	unidadHorario.setNombreEmpleado(WordUtils.capitalizeFully(unidadHorario.getNombreEmpleado()));
            }
                        
            unidadHorario.setNombreProduccion(rs.getString("nombreProduccion")); 
            if (!StringUtils.isEmpty(unidadHorario.getNombreProduccion())) {            	            	
            	unidadHorario.setNombreProduccion(WordUtils.capitalizeFully(unidadHorario.getNombreProduccion()));
            }
                        
            
            unidadHorario.setNombreSustituto(rs.getString("nombreSustituto"));
            if (!StringUtils.isEmpty(unidadHorario.getNombreSustituto())) {            	            	
            	unidadHorario.setNombreSustituto(WordUtils.capitalizeFully(unidadHorario.getNombreSustituto()));
            }
            
            unidadHorario.setNombreUbicacion(rs.getString("nombreUbicacion"));
            if (!StringUtils.isEmpty(unidadHorario.getNombreUbicacion())) {            	            	
            	unidadHorario.setNombreUbicacion(WordUtils.capitalizeFully(unidadHorario.getNombreUbicacion()));
            }
            
            return unidadHorario;
    }    	

}
