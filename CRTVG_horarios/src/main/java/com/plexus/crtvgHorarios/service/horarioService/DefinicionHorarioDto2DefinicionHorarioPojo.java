package com.plexus.crtvgHorarios.service.horarioService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.DefinicionHorarioPojo;
import com.plexus.crtvgHorarios.dto.horarios.DefinicionHorarioDto;
import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class DefinicionHorarioDto2DefinicionHorarioPojo  extends TransformadorGenerico<DefinicionHorarioDto, DefinicionHorarioPojo> {
    

    public DefinicionHorarioDto2DefinicionHorarioPojo(Mapper mapper) {    	
        super(mapper);        
    }
    
    
    @Override
    protected void aplicaPropiedadesExtendidas(DefinicionHorarioDto origen, DefinicionHorarioPojo destino) {
        
    		if (origen.getEmpleado() != null) {
    			destino.setIdEmpleado(origen.getEmpleado().getIdEmpleado());
    		}
    		
    		if (origen.getProduccion() != null) {
    			destino.setIdProduccion(origen.getProduccion().getIdProduccion());
    		}

    		if (origen.getUbicacion() != null) {
    			destino.setIdUbicacion(origen.getUbicacion().getIdUbicacion());
    		}
                
    }

}
