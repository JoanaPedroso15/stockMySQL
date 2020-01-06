package pt.upacademy.stockManagementProjectMysql.business;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.ProductDTO;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.repositories.ProductRepository;


public class ProductBusiness extends EntityBusiness<ProductRepository, Product> implements ProductBusinessInterface {
	static final ShelfBusiness shelfBus = new ShelfBusiness ();
	
	protected String getEntityClassName() {
		return Product.getName();
	}

	public  Product convertProductDTOtoProduct (ProductDTO p) {
		List <Long> shelvesIds = new ArrayList <Long>();
		shelvesIds = p.getShelfIds();
		List <Shelf> shelves = new ArrayList <Shelf> ();
		if (!shelvesIds.isEmpty()) {
			for (Long shelfId : shelvesIds) {
				shelfBus.get(shelfId);
				shelves.add(shelfBus.get(shelfId));
			}
		}
		Product product = new Product (
	 			shelves,
	 			p.getDiscount(),
	 			p.getIva(),
	 			p.getPvp()
	 			);
	 	return product;
	}

	public  ProductDTO convertProductToProductDTO (Product product) {
		ProductDTO p = new ProductDTO (
				product.getShelvesIds().stream().map(Shelf::getID).collect(Collectors.toList()),
				product.getDiscount(),
				product.getIva(),
				product.getPvp()
				);
		return p;
	}
	
}
