package com.plexus.crtvgHorarios.dataAccess.dao.common;

import java.sql.Connection;

public interface PaginatedDao<T> {
    
    public PaginatedListFilter<T> getPaginatedList(PaginatedListFilter<T> paginatedListFilter);
    public Connection getConnection();
}
