package pt.upacademy.stockManagementProjectMysql.repositories;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pt.upacademy.stockManagementProjectMysql.models.EntityDTO;
import pt.upacademy.stockManagementProjectMysql.models.MyEntity;

@Transactional
public abstract class EntityRepository <T extends MyEntity<D>, D extends EntityDTO> implements RepositoryInterface <T>{
	
	@PersistenceContext(unitName = "database")
	protected EntityManager em;

	
	public T createEnt (T newEnt) {
		return em.merge(newEnt);
	}

	protected abstract Class<T> getEntityClass();
	protected abstract String getAllEntities();
	protected abstract String getAllEntitiesIds();
	protected abstract String getEntitiesCount();
	
	public Collection<T> consultAll (){
		return em.createNamedQuery(getAllEntities (), getEntityClass()).getResultList();
	}
	
	public List<Long> getAllIds() {
		return em.createNamedQuery(getAllEntitiesIds(), Long.class).getResultList();
	}
	
	
	public T consultEntity (Long Id) {
		T entity = em.find(getEntityClass(), Id);
		return entity;
	}
	
	
	public void removeEntity (Long iD) {
		System.out.println("removeEntity : " + iD);
		T ent = consultEntity(iD);
		System.out.println("removeEntity : " + ent);
		if (ent != null) {
			em.remove(ent);
		}
	}
	
	
	public T editEntity (T newEnt) {
		return em.merge(newEnt);
	}
	
	

}
