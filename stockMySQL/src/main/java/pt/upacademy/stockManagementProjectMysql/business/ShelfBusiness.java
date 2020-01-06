package pt.upacademy.stockManagementProjectMysql.business;

import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.models.ShelfDTO;
import pt.upacademy.stockManagementProjectMysql.repositories.ShelfRepository;

public class ShelfBusiness extends EntityBusiness<ShelfRepository, Shelf> implements ShelfBusinessInterface {
	final static ProductBusiness prodBus = new ProductBusiness();

	protected String getEntityClassName() {
		return Shelf.getName();
	}

	public Shelf convertShelfDTOtoShelf(ShelfDTO s) {
		
		Shelf shelf = new Shelf(s.getCapacidade(), getProduct(s), s.getDailyPrice());

		return shelf;

	}

	public ShelfDTO convertShelftoShelfDTO(Shelf shelf) {
		ShelfDTO s = new ShelfDTO(shelf.getCapacidade(), getProductId(shelf), shelf.getDailyPrice());
		return s;
	}
	
	private Product getProduct(ShelfDTO s) {
		Product product;
		if (s.getProdutoId() != 0) {
			product = prodBus.get(s.getProdutoId());
		} else {
			product = null;
		}
		return product;
	}
	
	private long getProductId(Shelf s) {
		long productid;
		if (s.getProduto() != null) {
			productid = s.getProduto().getID();
		} else {
			productid = 0;
		}
		return productid;
	}
}
