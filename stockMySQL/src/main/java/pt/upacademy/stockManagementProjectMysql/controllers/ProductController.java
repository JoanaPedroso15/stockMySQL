package pt.upacademy.stockManagementProjectMysql.controllers;


import javax.ws.rs.Path;

import pt.upacademy.stockManagementProjectMysql.business.ProductBusiness;
import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.repositories.ProductRepository;

@Path("products")
public class ProductController extends EntityController <ProductBusiness,ProductRepository,Product> {
	
	public ProductController () {
		this.busEnt = new ProductBusiness ();
	}


}
