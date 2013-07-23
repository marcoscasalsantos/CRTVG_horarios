package com.plexus.crtvgHorarios.service.common;


import org.apache.commons.collections15.Transformer;
import org.dozer.Mapper;


public abstract class BaseTransformador<S, D> implements Transformer<S, D> {

    private Mapper mapper;
    private EstrategiaCreacion<S, D> estrategiaCreacion;

    public BaseTransformador(Mapper mapper) {
        this.mapper = mapper;
    }

    protected abstract void aplicaPropiedadesExtendidas(S origen, D destino);

    public Mapper getMapper() {
        return mapper;
    }

    public void setEstrategiaCreacion(EstrategiaCreacion<S, D> estrategiaCreacion) {
        this.estrategiaCreacion = estrategiaCreacion;
    }

    public D transform(S origen) {

        if (this.estrategiaCreacion == null) {
            throw new IllegalStateException();
        }
        if (origen == null) {
            return null;
        }
        D destino = this.estrategiaCreacion.crea(origen);
        getMapper().map(origen, destino);
        aplicaPropiedadesExtendidas(origen, destino);
        return destino;
    }

}