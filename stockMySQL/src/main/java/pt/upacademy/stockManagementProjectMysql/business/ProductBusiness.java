package pt.upacademy.stockManagementProjectMysql.business;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.ProductDTO;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.repositories.ProductRepository;


public class ProductBusiness extends EntityBusiness<ProductRepository, Product, ProductDTO> implements ProductBusinessInterface {

	protected String getEntityClassName() {
		return Product.getName();
	}

	
	}

