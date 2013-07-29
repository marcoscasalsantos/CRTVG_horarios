package com.plexus.crtvgHorarios.service.horarioService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.DefinicionHorarioPojo;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.DefinicionHorarioDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;
import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class DefinicionHorarioPojo2DefinicionHorarioDto  extends TransformadorGenerico<DefinicionHorarioPojo, DefinicionHorarioDto> {
    

    public DefinicionHorarioPojo2DefinicionHorarioDto(Mapper mapper) {    	
        super(mapper);
    }
    
    
    @Override
    protected void aplicaPropiedadesExtendidas(DefinicionHorarioPojo origen,  DefinicionHorarioDto destino) {   
    	
    	// OJO!!! Los objetos EmpleadoDto, UbicacionDto y ProduccionDto solo tienen el correspondiente id y nombre seteado
    	    	    	
    	destino.setEmpleado(new EmpleadoDto(origen.getIdEmpleado()));
    	destino.setUbicacion(new UbicacionDto(origen.getIdUbicacion(), origen.getNombreUbicacion()));
    	destino.setProduccion(new ProduccionDto(origen.getIdProduccion(), origen.getNombreProduccion()));
    	
    }

}
