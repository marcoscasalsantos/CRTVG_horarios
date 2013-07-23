package com.plexus.crtvgHorarios.service.empleadoService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.SeccionPojo;
import com.plexus.crtvgHorarios.dto.categorias.CategoriaDto;
import com.plexus.crtvgHorarios.dto.secciones.SeccionDto;
import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class SeccionPojo2SeccionDto  extends TransformadorGenerico<SeccionPojo, SeccionDto> {
    
    public SeccionPojo2SeccionDto(Mapper mapper) {    	
        super(mapper);
    }


}
