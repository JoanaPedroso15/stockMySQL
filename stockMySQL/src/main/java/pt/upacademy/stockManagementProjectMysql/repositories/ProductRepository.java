package pt.upacademy.stockManagementProjectMysql.repositories;

import pt.upacademy.stockManagementProjectMysql.models.Product;


public class ProductRepository extends EntityRepository<Product> {

	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}

	@Override
	protected String getAllEntities() {
		return Product.GET_ALL_PRODUCTS;
	}
	
}
