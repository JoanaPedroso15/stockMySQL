package pt.upacademy.stockManagementProjectMysql.business;

import java.util.Collection;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pt.upacademy.stockManagementProjectMysql.models.EntityDTO;
import pt.upacademy.stockManagementProjectMysql.models.MyEntity;
import pt.upacademy.stockManagementProjectMysql.repositories.EntityRepository;

@Transactional
public abstract class EntityBusiness <R extends EntityRepository <E,D>, E extends MyEntity<D>, D extends EntityDTO> implements EntityBusinessInterface <E> {

	@Inject
	protected R repository;
	
	@Override
	public E get(long id) {
		validate(id);
		return repository.consultEntity (id);
	}

	@Override
	public Collection<E> consultAll() {
		return repository.consultAll();
	}
	@Override
	public Collection<Long> getAllIds() {
		return repository.getAllIds();
	}

	@Override
	public long save(E entity) {
	    return repository.createEnt (entity);
	}

	@Override
	public void update(E entity)  {
		validate (entity.getID());
		repository.editEntity(entity);
		
	}

	@Override
	public void delete(long id) {
		repository.removeEntity(id);
		
	}
	
	public void validate (long Id) throws IllegalArgumentException {
		if (repository.consultEntity (Id) == null) {
			throw new IllegalArgumentException (String.format("No %s with ID %d", getEntityClassName(), Id));
		}
	}

	protected abstract String getEntityClassName();
	

}
