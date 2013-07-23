package com.plexus.crtvgHorarios.service.empleadoService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.UbicacionPojo;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;
import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class UbicacionPojo2UbicacionDto  extends TransformadorGenerico<UbicacionPojo, UbicacionDto> {
    
    public UbicacionPojo2UbicacionDto(Mapper mapper) {    	
        super(mapper);
    }


}
