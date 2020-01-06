package pt.upacademy.stockManagementProjectMysql.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.ProductDTO;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.models.ShelfDTO;
import pt.upacademy.stockManagementProjectMysql.repositories.ProductRepository;



@Path("products")
public class ProductController extends EntityController <ProductBusiness,ProductRepository,Product> {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDTO> getAll() {
		return busEnt.consultAll().stream()
				.map(product -> new ProductDTO(
						product.getShelvesIds().stream().map(
								Shelf::getID).collect(Collectors.toList()),
						product.getDiscount(),
						product.getIva(),
						product.getPvp()
						)
				)
				.collect(Collectors.toList());
	}
	

@GET
@Path("/{id}")
@Produces (MediaType.APPLICATION_JSON)
public ProductDTO getEntById (@PathParam("id") long id) {
			Product product = busEnt.get(id);
			ProductDTO p = new ProductDTO (
					product.getShelvesIds().stream().map(Shelf::getID).collect(Collectors.toList()),
					product.getDiscount(),
					product.getIva(),
					product.getPvp()
					);
		return p;
}
			 
		
@POST 
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public ProductDTO addProduct (ProductDTO p)  {
	Product product = busEnt.convertProductDTOtoProduct (p);
	ProductDTO pNew = busEnt.convertProductToProductDTO (product);
	busEnt.save(product);
	return pNew;
	 	
}

@POST 
@Path("list")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public List <ProductDTO> addProductList (List <ProductDTO> listprodsDTO) {
	List <ProductDTO> listprodsDTONew = new ArrayList <ProductDTO> ();
	for (ProductDTO p : listprodsDTO) {
		Product product = busEnt.convertProductDTOtoProduct (p);
		 busEnt.save(product);
		 ProductDTO pNew = busEnt.convertProductToProductDTO (product);
		 listprodsDTONew.add(pNew);
	 }
	
	return listprodsDTONew;
}

@PUT
@Path("/{id}")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public ProductDTO updateProduct (@PathParam("id") long id, ProductDTO p) {
	Product product = busEnt.convertProductDTOtoProduct (p);
	ProductDTO pNew = busEnt.convertProductToProductDTO (product);
	busEnt.update(product);
	return pNew;
}

@PUT
@Path("/list")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public List <ProductDTO> updateProdList (@PathParam("id") long id, List <ProductDTO> listprodsDTO) {
	List <ProductDTO> listprodsDTONew = new ArrayList <ProductDTO> ();
	for (ProductDTO p : listprodsDTO) {
		Product product = busEnt.convertProductDTOtoProduct (p);
		 busEnt.update(product);
		 ProductDTO pNew = busEnt.convertProductToProductDTO (product);
		 listprodsDTONew.add(pNew);
	 }
	
	return listprodsDTONew;
}


@DELETE 
@Path("/{id}")
public void deleteProduct (@PathParam("id") long id, ProductDTO p) {
	Product product = busEnt.convertProductDTOtoProduct (p);
	busEnt.delete(product.getID());
}




}
