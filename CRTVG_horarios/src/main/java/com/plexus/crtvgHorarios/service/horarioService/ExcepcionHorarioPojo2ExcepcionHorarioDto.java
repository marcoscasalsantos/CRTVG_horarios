package com.plexus.crtvgHorarios.service.horarioService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.DefinicionHorarioPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.ExcepcionHorarioPojo;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.dto.horarios.DefinicionHorarioDto;
import com.plexus.crtvgHorarios.dto.horarios.ExcepcionHorarioDto;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;
import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class ExcepcionHorarioPojo2ExcepcionHorarioDto  extends TransformadorGenerico<ExcepcionHorarioPojo, ExcepcionHorarioDto> {
    

    public ExcepcionHorarioPojo2ExcepcionHorarioDto(Mapper mapper) {    	
        super(mapper);
    }
    
    
    @Override
    protected void aplicaPropiedadesExtendidas(ExcepcionHorarioPojo origen,  ExcepcionHorarioDto destino) {   
    	
    	// OJO!!! Los objetos SustitutoDto solo tienen el correspondiente id seteado
    	
    	destino.setSustituto(new EmpleadoDto(origen.getIdSustituto()));	                
    }

}
