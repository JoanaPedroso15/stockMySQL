package pt.upacademy.stockManagementProjectMysql.business;

import javax.enterprise.context.RequestScoped;

import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.ProductDTO;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.repositories.ProductRepository;

@RequestScoped
public class ProductBusiness extends EntityBusiness<ProductRepository, Product, ProductDTO> implements ProductBusinessInterface {

	protected String getEntityClassName() {
		return Product.getName();
	}


	
	}

