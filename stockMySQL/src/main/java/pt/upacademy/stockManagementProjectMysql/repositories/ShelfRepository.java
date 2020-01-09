package pt.upacademy.stockManagementProjectMysql.repositories;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.models.ShelfDTO;

@RequestScoped
public class ShelfRepository extends EntityRepository<Shelf, ShelfDTO>  {
	

	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}

	@Override
	protected String getAllEntities() {
		return Shelf.GET_ALL_SHELVES;
	}

	@Override
	protected String getAllEntitiesIds() {
		return Shelf.GET_ALL_SHELVES_IDS;
	}
	
	@Override
	protected String getEntitiesCount() {
		return Shelf.GET_SHELVES_COUNT;
	}
	
	public List<Shelf> getEmptyShelves() {
		return em.createNamedQuery(Shelf.GET_EMPTY_SHELVES, getEntityClass()).getResultList();
	}
	
	public List<Shelf> findByProductId(long id) {
		TypedQuery<Shelf> query = em.createNamedQuery(Shelf.GET_SHELVES_BY_PRODUCT_ID, Shelf.class);
		query.setParameter("productId", id);
		return query.getResultList();
	}
	
	public void removeProductsByProductId(long id) {
	    em.createNamedQuery(Shelf.SHELVES_PRODUCT_TO_NULL).setParameter("productId", id).executeUpdate();
	}
	
	public boolean entityExist(long id) {
	    String query = "SELECT COUNT(e) FROM Product e WHERE e.id = " + id;
	    Long count = (Long) em.createQuery( query ).getSingleResult();
	    return ( ( count.equals( 0L ) ) ? false : true );
	}
	
	
	
	

}
