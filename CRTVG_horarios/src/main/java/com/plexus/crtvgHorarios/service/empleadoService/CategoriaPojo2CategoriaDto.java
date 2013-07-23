package com.plexus.crtvgHorarios.service.empleadoService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dto.categorias.CategoriaDto;
import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class CategoriaPojo2CategoriaDto  extends TransformadorGenerico<CategoriaPojo, CategoriaDto> {
    
    public CategoriaPojo2CategoriaDto(Mapper mapper) {    	
        super(mapper);
    }


}
