package com.plexus.crtvgHorarios.service.userService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.UserPojo;
import com.plexus.crtvgHorarios.dto.users.UserDto;

import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class UserPojo2UserDto  extends TransformadorGenerico<UserPojo, UserDto> {
    
    public UserPojo2UserDto(Mapper mapper) {
        super(mapper);
    }


}
