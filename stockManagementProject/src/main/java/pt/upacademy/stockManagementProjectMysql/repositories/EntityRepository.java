package pt.upacademy.stockManagementProjectMysql.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pt.upacademy.stockManagementProjectMysql.models.MyEntity;


public abstract class EntityRepository <T extends MyEntity> implements RepositoryInterface <T>{
	
	@PersistenceContext(unitName = "database")
	protected EntityManager em;

	
	public Long createEnt (T newEnt) {
		return em.merge(newEnt).getID();
	}

	protected abstract Class<T> getEntityClass();
	protected abstract String getAllEntities();
	
	public Collection<T> consultAll (){
		return em.createNamedQuery(getAllEntities (), getEntityClass()).getResultList();
	}
	
	
	public T consultEntity (Long Id) {
		T entity = em.find(getEntityClass(), Id);
		return entity;
	}
	
	
	public void removeEntity (Long iD) {
		T ent = consultEntity(iD);
		if (ent != null) {
			em.remove(ent);
		}
	}
	
	
	public void editEntity (T newEnt) {
		em.merge(newEnt);
	}
	
	

}
