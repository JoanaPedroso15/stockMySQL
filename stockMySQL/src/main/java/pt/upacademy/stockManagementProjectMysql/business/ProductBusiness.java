package pt.upacademy.stockManagementProjectMysql.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response;

import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.repositories.ProductRepository;


public class ProductBusiness extends EntityBusiness<ProductRepository, Product> implements ProductBusinessInterface {
	public static final ShelfBusiness shelfBus = new ShelfBusiness();

//
@Override
public long save(Product product) throws Exception {
//		List<Long> listShelves = product.getShelvesIds();
//		Collection<Long> listCreatedShelves = shelfBus.getAllIds();
//		if (!listShelves.isEmpty()) {
//			if (listCreatedShelves.isEmpty()) {
//				throw new Exception("Ainda nao existem prateleiras criadas");
//			} else if (!listCreatedShelves.isEmpty()) {
//				for (Long shelfId : listShelves) {
//					if (!listCreatedShelves.contains(shelfId)) {
//						throw new Exception("Ainda nao existe uma prateleira com esse ID");
//					}
//					if (listCreatedShelves.contains(shelfId) && shelfBus.get(shelfId).getProdutoId() != 0) {
//						throw new Exception(String.format("A prateleira %d ja tem um produto", shelfId));
//				}
//				}
//			}
//		}
//		repository.createEnt(product);
//		if (!listShelves.isEmpty()) updateShelfFromProduct(product, new ArrayList<Long>() , product.getShelvesIds());
return product.getID();
}
//
@Override
public void update(Product product) throws Exception {
//		validate(product.getID());
//		Product oldProduct = repository.consultEntity(product.getID());
//		Collection<Long> listCreatedShelves = shelfBus.getAllIds();
//		if (!product.getShelvesIds().isEmpty()) {
//			for (Long shelfId : product.getShelvesIds()) {
//				if (listCreatedShelves.isEmpty())
//					throw new Exception("Ainda nao existem prateleiras criadas");
//				if (!listCreatedShelves.contains(shelfId))
//					throw new Exception("Ainda nao existe uma prateleira com esse ID");
//			}
//		}
//		if (!oldProduct.getShelvesIds().equals(product.getShelvesIds())) {
//			updateShelfFromProduct(product, oldProduct.getShelvesIds(), product.getShelvesIds());
//
//		}
//		repository.editEntity(product);
//
}
//
@Override
public void delete(long id) {
//		validate(id);
//		removeProductShelves(id);
//		repository.removeEntity(id);
//
}
//
@Override
public void updateShelfFromProduct(Product p, List<Long> oldShelves, List<Long> newShelves) {
//		System.out.println("!oldProduct.getShelvesIds().equals(product.getShelvesIds()");
//		try {
//			List<Long> emptyShelves = getEmptyShelves(newShelves, p.getID());
//			p.setShelvesIds(emptyShelves);
//			for (Long shelfId : emptyShelves) {
//				Shelf shelf = shelfBus.get(shelfId);
//				shelf.setProdutoId(p.getID());
//			}
//		} catch (IllegalArgumentException e2) {
//			throw new IllegalArgumentException(e2.getMessage());
//		}
//
}
//
//public void removeProductShelves(Long productId) {
//		Collection<Long> oldShelves = repository.consultEntity(productId).getShelvesIds();
//		Iterator<Long> shelfIterator = oldShelves.iterator();
//		while (shelfIterator.hasNext()) {
//			Long shelfid = (Long) shelfIterator.next();
//			shelfBus.get(shelfid).setProdutoId(0);
//		}
//	}
//
//	public List<Long> getEmptyShelves(List<Long> array, Long productId) throws IllegalArgumentException {
//		List<Long> emptyShelves = new ArrayList<Long>();
//		Iterator<Long> shelfIterator = array.iterator();
//		while (shelfIterator.hasNext()) {
//			Long shelfId = (Long) shelfIterator.next();
//			Long id = shelfBus.get(shelfId).getProdutoId();
//			if (id == 0 || id == productId) {
//				emptyShelves.add(shelfId);
//			} else {
//				throw new IllegalArgumentException(String.format("A prateleira %d ja tem um produto", shelfId));
//			}
//		}
//		return emptyShelves;
//	}

	protected String getEntityClassName() {
		return Product.getName();
	}
	@Override
	public Collection<Long> getAllIds() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
