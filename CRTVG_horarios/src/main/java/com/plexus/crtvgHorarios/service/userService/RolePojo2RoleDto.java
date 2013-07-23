package com.plexus.crtvgHorarios.service.userService;

import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.pojo.RolePojo;
import com.plexus.crtvgHorarios.dataAccess.pojo.UserPojo;
import com.plexus.crtvgHorarios.dto.users.RoleDto;

import com.plexus.crtvgHorarios.service.common.TransformadorGenerico;

public class RolePojo2RoleDto  extends TransformadorGenerico<RolePojo, RoleDto> {
    
    public RolePojo2RoleDto(Mapper mapper) {
        super(mapper);
    }


}
