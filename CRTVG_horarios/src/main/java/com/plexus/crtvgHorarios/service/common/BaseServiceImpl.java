package com.plexus.crtvgHorarios.service.common;

import org.springframework.stereotype.Service;



@Service("baseService")
public class BaseServiceImpl implements BaseService {

	/*
	 * CRITERIOS DE ARQUITECTURA: La capa de vista solo debería trabajar con
	 * Dtos y ningún Pojo debería verse en esta capa, beneficios: - En la capa
	 * de vista no hay confusión si el tipo de datos usado es un dto o un pojo,
	 * los nombres de variables no necesitan el sufijo dto o pojo. - Si los
	 * mapeos de atributos POJO-DTO, DTO-POJO se hacen siempre en la capa
	 * servicio, mediante métodos "Populates.populate" con lo que los cambios en
	 * los Pojos son más sencillos de trasladar a los DTOs y por tanto al
	 * negocio y la vista - Los DTOs agruparán atributos que pueden estár
	 * distribuidos en varios POJOs
	 * 
	 * Criterios en el mapeo de DTO-POJO POJO-DTO: - Los pojos que contienen
	 * otros pojos se mapearan como Dtos que contienen otros Dtos, beneficios: -
	 * Los pojos tengan los mismos nombres que las tablas, haya una relaci@n
	 * equivalente entre tablas con otras tablas y Pojos con otros pojos con lo
	 * que es facil ver cual es el pojo correspondiente a una tabla. Aunque si
	 * pojo y subpojo componen un mismo objeto de la vista en el DTO los
	 * atributos de pojo y subpojo estar@an mejor a un mismo nivel en el DTO.
	 * 
	 * CRITERIOS PARA IMPLEMENTACI@N DE POJOS: - Un pojo deber@a contener otros
	 * pojos cuando: - En la vista es muy com@n que a partir de los datos del
	 * pojo se necesiten mostrar datos del subpojo lo que conllevar@a una
	 * busqueda en la BD si el pojo no contuviese ya el subpojo.
	 * 
	 * Buenas practicas implementaci@n: En los m@todos Populates.populate,
	 * tratar los atributos alfab@ticamente para evitar confusiones al picar el
	 * c@digo del m@todo
	 * 
	 * 
	 * CRITERIO PARA GESTI@N DE EXCEPCIONES:
	 * Solo se capturar@n y propagar@n excepciones que tengan utilidad para las clases
	 * llamantes. El resto de excepciones se tomar@n como runtimeExceptions.
	 * 
	 * 
	 */

	/*
	 * ******************** INYECCI@N DE DEPENDENCIAS Mediante la inyecci@n de
	 * dependencias, los DAOs se generan al cargar el applicationContext. Al
	 * instanciar este bean se le inyectan los daos que tiene
	 * vinculados mediante la anotaci@n "@Resource" , por defecto se inician en
	 * este momento salvo que se anoten como "@lazy" as@ se detectar@n los
	 * posibles problemas con las dependencias en el momento de instanciar el
	 * servicio. Solo se crear@ una instancia de estos beans. Se guardan en una
	 * factor@a y se compartir@n entre los usuarios de la aplicaci@n.
	 */

	/*
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
	//@Resource
	//private UserDao userDao;
	//No need of a setter anymore. Spring can inject the resorce.


	/**
	@Transactional(readOnly = true)

	}
	*/

}
