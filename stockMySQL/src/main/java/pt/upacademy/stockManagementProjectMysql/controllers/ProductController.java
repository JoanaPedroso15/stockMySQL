package pt.upacademy.stockManagementProjectMysql.controllers;


import java.util.ArrayList;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import pt.upacademy.stockManagementProjectMysql.business.ProductBusiness;
import pt.upacademy.stockManagementProjectMysql.business.ShelfBusiness;
import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.ProductDTO;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.repositories.ProductRepository;
@RequestScoped
@Path("products")
public class ProductController extends EntityController <ProductBusiness,ProductRepository, Product, ProductDTO> {
	
	@Inject
	ShelfBusiness shelfBus;


@Override
public Product toEntity(ProductDTO entDTO) {
	List <Long> shelvesIds = new ArrayList <Long>();
	shelvesIds = entDTO.getShelfIds();
	List <Shelf> shelves = new ArrayList <Shelf> ();
	
	Product product = new Product (
 			shelves,
 			entDTO.getDiscount(),
 			entDTO.getIva(),
 			entDTO.getPvp()
 			);
	if (!shelvesIds.isEmpty()) {
		for (Long shelfId : shelvesIds) {
			Shelf s = shelfBus.get(shelfId);
			s.setProduto(product);
			shelves.add(s);
		}
	}
	if(entDTO.getId() > 0) {
		product.setID(entDTO.getId());
	}
 	return product;
}






}
