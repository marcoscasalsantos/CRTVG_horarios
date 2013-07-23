package com.plexus.crtvgHorarios.service.empleadoService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.ProduccionPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UbicacionPojo;
import com.plexus.crtvgHorarios.dto.producciones.ProduccionDto;
import com.plexus.crtvgHorarios.dto.ubicaciones.UbicacionDto;
import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class ProduccionPojo2ProduccionDto  extends TransformadorGenerico<ProduccionPojo, ProduccionDto> {
    
    public ProduccionPojo2ProduccionDto(Mapper mapper) {
        super(mapper);
    }

}
