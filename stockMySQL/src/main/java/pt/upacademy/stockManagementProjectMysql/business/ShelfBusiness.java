package pt.upacademy.stockManagementProjectMysql.business;

import java.util.List;
import java.util.stream.Collectors;

import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.models.ShelfDTO;
import pt.upacademy.stockManagementProjectMysql.repositories.ShelfRepository;

public class ShelfBusiness extends EntityBusiness<ShelfRepository, Shelf, ShelfDTO> implements ShelfBusinessInterface {
	
	protected String getEntityClassName() {
		return Shelf.getName();
	}
	
	public List <ShelfDTO> getShelvesByProductId (long id) {
		return repository.findByProductId(id).stream().map(Shelf :: toDTO).collect(Collectors.toList());
		
	}
	public List <Shelf> getEmptyShelves () {
		return repository.getEmptyShelves();
		
	}
	
	public void removeProductsbyProdId (long id) {
		repository.removeProductsByProductId(id);
	}
	
}
