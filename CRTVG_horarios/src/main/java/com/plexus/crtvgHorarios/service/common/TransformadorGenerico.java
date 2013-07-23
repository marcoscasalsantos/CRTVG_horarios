package com.plexus.crtvgHorarios.service.common;

import org.dozer.Mapper;

public class TransformadorGenerico<E, D> extends BaseTransformador<E, D> {

    public TransformadorGenerico(Mapper mapper) {
        super(mapper);
        setEstrategiaCreacion(new EstrategiaCreacionNuevo(this));
    }


    @Override
    protected void aplicaPropiedadesExtendidas(E origen, D destino) {
    }

}
