package com.plexus.crtvgHorarios.service.userService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.RolePojo;
import com.plexus.crtvgHorarios.dto.users.RoleDto;

import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;



public class RoleDto2RolePojo  extends TransformadorGenerico<RoleDto, RolePojo> {

    public RoleDto2RolePojo(Mapper mapper) {
        super(mapper);
    }


    @Override
    protected void aplicaPropiedadesExtendidas(RoleDto origen, RolePojo destino) {
        super.aplicaPropiedadesExtendidas(origen, destino);
    }


}
