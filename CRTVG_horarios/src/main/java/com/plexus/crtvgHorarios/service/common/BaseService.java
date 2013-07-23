package com.plexus.crtvgHorarios.service.common;

/*
 * CRITERIOS DE ARQUITECTURA: 
 * 
 * La capa de vista y servicio solo operar#n con
 * Dtos y ning#n Pojo deber# verse en esta capa, beneficios:
 * - Desacoplamiento capas DAO - Service.
 * - En la capa de vista no hay confusi#n si el tipo de datos usado es un dto o un pojo,
 * los nombres de variables no necesitan el sufijo dto o pojo.
 *  
 * Los mapeos de atributos POJO-DTO, DTO-POJO se haran por tanto en la capa DAO
 * 	 
 * CRITERIO PARA GESTI#N DE EXCEPCIONES:
 * Solo se capturar#n y propagar#n excepciones que tengan utilidad para las clases
 * llamantes. El resto de excepciones se tomar#n como runtimeExceptions.
 * 
 * 
 */

/*
 * ******************** INYECCI#N DE DEPENDENCIAS Mediante la inyecci#n de
 * dependencias, los DAOs se generan al cargar el applicationContext. Al
 * instanciar este bean se le inyectan los daos que tiene
 * vinculados mediante la anotaci#n "@Resource" , por defecto se inician en
 * este momento salvo que se anoten como "@lazy" as# se detectar#n los
 * posibles problemas con las dependencias en el momento de instanciar el
 * servicio. Solo se crear# una instancia de estos beans. Se guardan en una
 * factor#a y se compartir#n entre los users de la aplicaci#n.
 */

/*
 * ********************* GESTI#N DE TRANSACCIONES ********************
 * 
 * Por configuraci#n no se permite la ejecuci#n de ning#n m#todo de los DAO 
 * sin estar vinculado a una transacci#n,por lo que todos los metodos deben 
 * estar anotados con @Transactional para que comiencen una nueva transacci#n
 * o ser llamados por otro m#todo que ya haya iniciado una transacci#n.
 * Anotar aquellos m#todos de solo lectura como @Transactional(readOnly = true)
 * ya que mejora la eficiencia y seguridad de la gesti#n de transacciones.
 * 
 * The default @Transactional settings: Propagation setting is
 * PROPAGATION_REQUIRED. Isolation level is ISOLATION_DEFAULT. Transaction
 * is read/write. Transaction timeout defaults to the default timeout of the
 * underlying transaction system, or to none if timeouts are not supported.
 * Any RuntimeException triggers rollback, and any checked Exception does
 * not.
 * 
 * When the propagation setting is PROPAGATION_REQUIRED, a logical
 * transaction scope is created for each method upon which the setting is
 * applied. Each such logical transaction scope can determine rollback-only
 * status individually, with an outer transaction scope being logically
 * independent from the inner transaction scope. Of course, in case of
 * standard PROPAGATION_REQUIRED behavior, all these scopes will be mapped
 * to the same physical transaction. So a rollback-only marker set in the
 * inner transaction scope does affect the outer transaction's chance to
 * actually commit (as you would expect it to).
 * 
 * Documentation:
 * http://static.springsource.org/spring/docs/3.0.x/spring-framework
 * -reference/html/transaction.html
 */
 	
/*
 * @Autowired wires per type. In combination with @Qualifier also autowires by name. 
 * The main difference is is that @Autowired is a spring annotation whereas 
 * @Resource wires by name and is specified by the JSR-250. 
 * So @Resource is part of normal java where as @Autowired is only available by spring. 
 */


public interface BaseService {

}