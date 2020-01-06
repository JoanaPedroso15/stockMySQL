package pt.upacademy.stockManagementProjectMysql.repositories;


import pt.upacademy.stockManagementProjectMysql.models.Shelf;

public class ShelfRepository extends EntityRepository<Shelf>  {
	

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
	
	

}
