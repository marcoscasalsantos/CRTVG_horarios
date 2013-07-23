package com.plexus.crtvgHorarios.service.userService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.UserPojo;
import com.plexus.crtvgHorarios.dto.users.UserDto;

import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;



public class UserDto2UserPojo  extends TransformadorGenerico<UserDto, UserPojo> {

    public UserDto2UserPojo(Mapper mapper) {
        super(mapper);
    }


    @Override
    protected void aplicaPropiedadesExtendidas(UserDto origen, UserPojo destino) {
        super.aplicaPropiedadesExtendidas(origen, destino);
    }


}
