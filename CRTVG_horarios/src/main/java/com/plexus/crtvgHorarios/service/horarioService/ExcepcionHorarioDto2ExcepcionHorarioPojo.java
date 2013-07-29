package com.plexus.crtvgHorarios.service.horarioService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.ExcepcionHorarioPojo;
import com.plexus.crtvgHorarios.dto.horarios.ExcepcionHorarioDto;
import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class ExcepcionHorarioDto2ExcepcionHorarioPojo  extends TransformadorGenerico<ExcepcionHorarioDto, ExcepcionHorarioPojo> {
    

    public ExcepcionHorarioDto2ExcepcionHorarioPojo(Mapper mapper) {    	
        super(mapper);        
    }    
    
    @Override
    protected void aplicaPropiedadesExtendidas(ExcepcionHorarioDto origen, ExcepcionHorarioPojo destino) {
        
		if (origen.getSustituto() != null) {
			destino.setIdSustituto(origen.getSustituto().getIdEmpleado());
		}
    }

}
