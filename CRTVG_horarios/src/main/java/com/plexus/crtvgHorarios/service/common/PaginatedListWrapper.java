package com.plexus.crtvgHorarios.service.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

//FIXME cambiar esto para adaptarlo al lazyLoadObject de primefaces en lugar de PaginatedList de displayTag
public class PaginatedListWrapper<T> extends LazyDataModel<T> {

    public static final int MAX_OBJECT_PER_PAGE = Integer.MAX_VALUE;
    public static final int DEFAULT_OBJECTS_PER_PAGE = 10;
    public static final int DEFAULT_CURRENT_PAGE = 1;
    public static final String ASCENDING_DIR = "asc";
    public static final String DESCENDING_DIR = "desc";
    public static final int[] DEFAULT_PAGINATED_OPTIONS = { 10, 25, 50, 100 };
    public static final String DEFAULT_PREFIX = "plw_";


    private List<T> list;
    private int objectsPerPage;
    private int pageNumber;
    private int fullListSize;
    private SortOrder sortDirection;
    private String sortCriterion;
    private int[] paginatedOptions;

    private String prefijo;
    private Map<String, String> filtros;


    public PaginatedListWrapper() {
        list = new ArrayList<T>();
        fullListSize = 0;
        objectsPerPage = DEFAULT_OBJECTS_PER_PAGE;
        pageNumber = DEFAULT_CURRENT_PAGE;
        sortDirection = SortOrder.ASCENDING;
        sortCriterion = "";
        paginatedOptions = DEFAULT_PAGINATED_OPTIONS;
        prefijo = DEFAULT_PREFIX;
        filtros = new HashMap<String, String>();
    }


    public String getUrlFilterParams(){
        String urlFilterParams = "";
        
        for (String paramName: filtros.keySet()){
            if (StringUtils.isNotBlank(urlFilterParams)){
                urlFilterParams += "&";
            }
            urlFilterParams += paramName + "=" + filtros.get(paramName); 
        }
        
        return "?" + urlFilterParams;
    }
    
    
    /*
     * Getters & Setters
     */

    public int getFullListSize() {
        return fullListSize;
    }

    public List<T> getList() {
        return list;
    }

    public int getObjectsPerPage() {
        return objectsPerPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getSearchId() {
        return null;
    }

    public String getSortCriterion() {
        return sortCriterion;
    }

    public SortOrder getSortDirection() {
        return sortDirection;
        // if (ASCENDING_DIR.equals(this.sortDirection)) {
        // return SortOrderEnum.ASCENDING;
        // } else if (DESCENDING_DIR.equals(this.sortDirection)) {
        // return SortOrderEnum.DESCENDING;
        // } else {
        // return null;
        // }

    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setObjectsPerPage(int objectsPerPage) {
        this.objectsPerPage = objectsPerPage;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setSortDirection(SortOrder sortDirection) {
        this.sortDirection = sortDirection;
    }

    public void setSortCriterion(String sortCriterion) {
        this.sortCriterion = sortCriterion;
    }

    public void setFullListSize(int fullListSize) {
        this.fullListSize = fullListSize;
    }


    public int[] getPaginatedOptions() {
        return paginatedOptions;
    }

    public void setPaginatedOptions(int[] paginatedOptions) {
        this.paginatedOptions = paginatedOptions;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public Map<String, String> getFiltros() {
        return filtros;
    }

    public void setFiltros(Map<String, String> filtros) {
        this.filtros = filtros;
    }
    
    public void printFiltros(){
        for (Map.Entry<String, String> entry : filtros.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }
}
