package pt.upacademy.stockManagementProjectMysql.business;

import java.util.Collection;

import pt.upacademy.stockManagementProjectMysql.models.MyEntity;


public interface EntityBusinessInterface <T extends MyEntity> {
	
	T get (long id);
	
	Collection<T> consultAll ();	
	
	Collection<Long> getAllIds ();
	
	long save (T entity) throws Exception;
	
	void update (T entity) throws Exception;
	
	void delete (long id);

	

}
