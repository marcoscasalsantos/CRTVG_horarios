package com.plexus.crtvgHorarios.dataAccess.dao.common;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author mcs
 * 
 * Métodos genericos de acceso a datos, Métodos CRUD (create, read, update y delete)
 * Si fuese necesario crear métodos específicos para un DAO concreto se extendería 
 * la implementación de esta clase con los métodos correspondientes
 *
 */


public abstract class BaseDao {
	
	
	protected JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	
	
     
	/*
	 * CRITERIOS DE ARQUITECTURA: 
	 * 
	 * Los métodos de la capa DAO que devuelven objetos de la clase Collection o heredados de este 
	 * por ejemlo List, Map, Set... NO devolverán null si no el correspondiente objeto vacío errores por null Exceptions
	 * 
	 */	
    
    
}
