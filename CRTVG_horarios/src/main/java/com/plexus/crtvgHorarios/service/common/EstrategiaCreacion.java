package com.plexus.crtvgHorarios.service.common;

public abstract interface EstrategiaCreacion<S, D> {
    public abstract D crea(S paramS);
}