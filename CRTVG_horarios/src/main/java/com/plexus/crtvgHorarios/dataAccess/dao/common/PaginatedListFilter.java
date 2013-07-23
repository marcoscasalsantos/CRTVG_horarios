package com.plexus.crtvgHorarios.dataAccess.dao.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PaginatedListFilter<T> {

    public static final int MAX_OBJECT_PER_PAGE = Integer.MAX_VALUE;
    public static final int DEFAULT_OBJECTS_PER_PAGE = 10;
    public static final int DEFAULT_CURRENT_PAGE = 1;
    
    public static final String ASCENDING_DIR = "asc";
    public static final String DESCENDING_DIR = "desc";
    
    private int pageNumber;
    private int objectsPerPage;
    private int fullListSize;
    private String sortCriterion;
    private String sortDir;
    private List<T> paginatedList;
    
    private Map<String, String> filtros;
    
    public PaginatedListFilter(){
        pageNumber = DEFAULT_CURRENT_PAGE;
        objectsPerPage = DEFAULT_OBJECTS_PER_PAGE;
        fullListSize = 0;
        sortCriterion = "";
        sortDir = ASCENDING_DIR;
        paginatedList = new ArrayList<T>();
        
        filtros = new HashMap<String, String>();
    }

    public int calculaPrimerElemento(){
        
        if (pageNumber > 0 && objectsPerPage > 0){
            return (pageNumber - 1)*objectsPerPage;
        }
        return 0;
    }
    
    /*
     * Getters & Setters
     */ 
    
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getObjectsPerPage() {
        return objectsPerPage;
    }

    public void setObjectsPerPage(int objectsPerPage) {
        this.objectsPerPage = objectsPerPage;
    }

    public int getFullListSize() {
        return fullListSize;
    }

    public void setFullListSize(int fullListSize) {
        this.fullListSize = fullListSize;
    }

    public String getSortCriterion() {
        return sortCriterion;
    }

    public void setSortCriterion(String sortCriterion) {
        this.sortCriterion = sortCriterion;
    }

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    public List<T> getPaginatedList() {
        return paginatedList;
    }

    public void setPaginatedList(List<T> paginatedList) {
        this.paginatedList = paginatedList;
    }

    public Map<String, String> getFiltros() {
        return filtros;
    }

    public void setFiltros(Map<String, String> filtros) {
        this.filtros = filtros;
    }
    
    
}
