package pt.upacademy.stockManagementProjectMysql.business;

import java.util.List;

import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.repositories.ProductRepository;


public interface ProductBusinessInterface extends EntityBusinessInterface<Product> {
	

	void updateShelfFromProduct(Product p, List<Long> oldShelves, List<Long> newShelves);
	
	

}
