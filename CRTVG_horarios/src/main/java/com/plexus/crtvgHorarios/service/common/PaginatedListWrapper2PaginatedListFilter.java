package com.plexus.crtvgHorarios.service.common;

import java.util.HashMap;
import java.util.Map;

import org.primefaces.model.SortOrder;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.dao.common.PaginatedListFilter;


public class PaginatedListWrapper2PaginatedListFilter extends TransformadorGenerico<PaginatedListWrapper, PaginatedListFilter> {

    public PaginatedListWrapper2PaginatedListFilter(Mapper mapper) {
        super(mapper);
    }

    @Override
    protected void aplicaPropiedadesExtendidas(PaginatedListWrapper origen, PaginatedListFilter destino) {
        super.aplicaPropiedadesExtendidas(origen, destino);
        
        destino.setFiltros(new HashMap<String, String>());
        if (origen.getFiltros() != null){
            Map<String, String> filtros = origen.getFiltros();
            for (String filtro: filtros.keySet()){
                destino.getFiltros().put(StringUtils.substringAfter(filtro, origen.getPrefijo()), filtros.get(filtro));
            }
        }
        
        if (SortOrder.ASCENDING.equals(origen.getSortDirection())){
            destino.setSortDir(PaginatedListFilter.ASCENDING_DIR);
        }else{
            destino.setSortDir(PaginatedListFilter.DESCENDING_DIR);
        }
        
    }
}
