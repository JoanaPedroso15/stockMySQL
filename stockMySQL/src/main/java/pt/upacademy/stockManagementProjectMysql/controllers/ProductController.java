package pt.upacademy.stockManagementProjectMysql.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pt.upacademy.stockManagementProjectMysql.business.ProductBusiness;
import pt.upacademy.stockManagementProjectMysql.business.ShelfBusiness;
import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.ProductDTO;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.models.ShelfDTO;
import pt.upacademy.stockManagementProjectMysql.repositories.ProductRepository;

@Path("products")
public class ProductController extends EntityController <ProductBusiness,ProductRepository, Product, ProductDTO> {
	
	@Inject
	ShelfBusiness shelfBus;


@Override
public Product toEntity(ProductDTO entDTO) {
	List <Long> shelvesIds = new ArrayList <Long>();
	shelvesIds = entDTO.getShelfIds();
	List <Shelf> shelves = new ArrayList <Shelf> ();
	if (!shelvesIds.isEmpty()) {
		for (Long shelfId : shelvesIds) {
			shelfBus.get(shelfId);
			shelves.add(shelfBus.get(shelfId));
		}
	}
	Product product = new Product (
 			shelves,
 			entDTO.getDiscount(),
 			entDTO.getIva(),
 			entDTO.getPvp()
 			);
 	return product;
}






}
