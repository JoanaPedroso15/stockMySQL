package pt.upacademy.stockManagementProjectMysql.business;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.repositories.ShelfRepository;

public interface ShelfBusinessInterface extends EntityBusinessInterface<Shelf> {

	
	void alterarProducts (Shelf shelf, long prodId, boolean isRemove);
}
