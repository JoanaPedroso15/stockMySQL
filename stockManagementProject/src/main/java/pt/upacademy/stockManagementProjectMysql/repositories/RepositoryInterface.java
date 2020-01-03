package pt.upacademy.stockManagementProjectMysql.repositories;

import java.util.Collection;


public interface RepositoryInterface<T> {

	public T consultEntity (Long Id);

	public void removeEntity (Long iD);
	
	public void editEntity (T newEnt);
	
	public Long createEnt (T newEnt);
	
	public Collection<T> consultAll ();
}
