package com.plexus.crtvgHorarios.service.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;

import com.plexus.crtvgHorarios.dataAccess.dao.common.PaginatedDao;
import com.plexus.crtvgHorarios.dataAccess.dao.common.PaginatedListFilter;



public class PaginadorHelper<T, S> {

    public PaginatedListFilter<S> getPaginatedListFilter(PaginatedListWrapper<T> paginatedListWrapper, TransformadorGenerico<S, T> transformador, Mapper mapper, Map<String, String> camposBBDD) {
     // Obtengo los filtros de la consulta
        PaginatedListFilter<S> paginatedListFilter = new PaginatedListWrapper2PaginatedListFilter(mapper).transform(paginatedListWrapper);
        
        if (camposBBDD != null && StringUtils.isNotBlank(paginatedListFilter.getSortCriterion()) && camposBBDD.containsKey(paginatedListFilter.getSortCriterion())){
            paginatedListFilter.setSortCriterion(camposBBDD.get(paginatedListFilter.getSortCriterion()));
        }
        return paginatedListFilter;
    }
    
    public PaginatedListWrapper<T> busquedaPaginada(PaginatedListWrapper<T> paginatedListWrapper, PaginatedDao<S> paginatedDAO, TransformadorGenerico<S, T> transformador, Mapper mapper, Map<String, String> camposBBDD) {
        
        // Obtengo los filtros de la consulta
        PaginatedListFilter<S> paginatedListFilter = new PaginatedListWrapper2PaginatedListFilter(mapper).transform(paginatedListWrapper);
        
        if (camposBBDD != null && StringUtils.isNotBlank(paginatedListFilter.getSortCriterion()) && camposBBDD.containsKey(paginatedListFilter.getSortCriterion())){
            paginatedListFilter.setSortCriterion(camposBBDD.get(paginatedListFilter.getSortCriterion()));
        }
        
        // Hago la consulta a la base de datos
        paginatedListFilter = paginatedDAO.getPaginatedList(paginatedListFilter);
        
        // Transformo los elementos devueltos
        List<T> lista = new ArrayList<T>();
        for (S elemListaDao: paginatedListFilter.getPaginatedList()){
            lista.add(transformador.transform(elemListaDao));
        }
        
        // Asigno la nueva lista y el numero total de elementos en la consulta
        paginatedListWrapper.setList(lista);
        paginatedListWrapper.setFullListSize(paginatedListFilter.getFullListSize());
        
        return paginatedListWrapper;
    }
    
    
    
}
