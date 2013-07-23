package com.plexus.crtvgHorarios.service.common;

import java.lang.reflect.ParameterizedType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EstrategiaCreacionNuevo<S, D> implements EstrategiaCreacion<S, D> {
    private static final Logger log = LoggerFactory.getLogger(EstrategiaCreacionNuevo.class);

    private Class<D> clasePrototipo;

    public EstrategiaCreacionNuevo(Class<D> clasePrototipo) {
        this.clasePrototipo = clasePrototipo;
    }

    public EstrategiaCreacionNuevo(Object objetoBuscaPrototipo) {
        this.clasePrototipo = averiguaClasePrototipo(objetoBuscaPrototipo);
    }

    private Class<D> averiguaClasePrototipo(Object objetoBuscaPrototipo) {
        Class<?> clazz = objetoBuscaPrototipo.getClass();

        while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
            clazz = clazz.getSuperclass();
        }

        return (Class) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public final D crea(S s) {
        return getNuevaInstancia();
    }

    private D getNuevaInstancia() {
        try {
            return this.clasePrototipo.newInstance();
        } catch (Exception ex) {
            log.debug("Error creando Dto", ex);
            return null;
        }
    }
}
