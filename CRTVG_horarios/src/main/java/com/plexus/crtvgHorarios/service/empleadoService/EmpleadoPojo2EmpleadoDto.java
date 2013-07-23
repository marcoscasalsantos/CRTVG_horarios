package com.plexus.crtvgHorarios.service.empleadoService;

import org.apache.commons.lang3.text.WordUtils;
import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.CategoriaPojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.EmpleadoPojo;
import com.plexus.crtvgHorarios.dto.categorias.CategoriaDto;
import com.plexus.crtvgHorarios.dto.empleados.EmpleadoDto;
import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class EmpleadoPojo2EmpleadoDto  extends TransformadorGenerico<EmpleadoPojo, EmpleadoDto> {
    

    public EmpleadoPojo2EmpleadoDto(Mapper mapper) {    	
        super(mapper);        
    }
    
    
    @Override
    protected void aplicaPropiedadesExtendidas(EmpleadoPojo origen,  EmpleadoDto destino) {
        
    	if (!origen.getIdCategoria().isEmpty()) {
    		destino.setCategoria(new CategoriaDto(origen.getIdCategoria(), WordUtils.capitalizeFully(origen.getIdCategoria())));
    	}
                
    }

}
