package pt.upacademy.stockManagementProjectMysql.repositories;

import java.util.Collection;


public interface RepositoryInterface<T> {

	public T consultEntity (Long Id);

	public void removeEntity (Long iD);
	
	public T editEntity (T newEnt);
	
	public T createEnt (T newEnt);
	
	public Collection<T> consultAll ();
}
