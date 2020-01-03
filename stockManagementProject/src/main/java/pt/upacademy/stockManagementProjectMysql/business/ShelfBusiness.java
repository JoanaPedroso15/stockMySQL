package pt.upacademy.stockManagementProjectMysql.business;



import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.repositories.ShelfRepository;

public class ShelfBusiness extends EntityBusiness<ShelfRepository, Shelf> implements ShelfBusinessInterface {
	
	  
	public static final ProductBusiness prodBus = new ProductBusiness ();
	


@Override
public long save(Shelf shelf) throws Exception {
//		long idProduto = shelf.getProdutoId();
//		Collection <Long> listProdIds = prodBus.getAllIds();
//		if (idProduto != 0) {
//			if (listProdIds.isEmpty()) throw new Exception ("Ainda nao ha produtos criados");
//			if (!listProdIds.contains(idProduto)) throw new Exception ("Ainda nao existe um produto com esse ID");
//		}
//		repository.createEnt (shelf);
	return shelf.getID();
}
//
@Override
public void update(Shelf shelf) throws Exception {
//		validate(shelf.getID());
//		Long productIdNew = shelf.getProdutoId();
//		alterarProducts(shelf, productIdNew, false);
//		Collection <Long> listProdIds = prodBus.getAllIds();
//		if (shelf.getProdutoId() != 0) {
//			if (listProdIds.isEmpty()) throw new Exception ("Ainda nao ha produtos criados");
//			if (!listProdIds.contains(shelf.getProdutoId())) throw new Exception ("Ainda nao existe um produto com esse ID");
//		}
//		repository.editEntity(shelf);
}
//
@Override
public void delete(long id) { 
//		validate(id);
//		Long prodIdNew = (long) 0;
//		Shelf shelf = repository.consultEntity(id);
//		alterarProducts (shelf, prodIdNew, true);
//		repository.removeEntity(id);
}
//
//	
//		
public void alterarProducts (Shelf shelf, long prodIdNew, boolean isRemove) {
//		System.out.println("alterarProducts");
//    	Long productInTheShelf = repository.consultEntity(shelf.getID()).getProdutoId();
//    	if (productInTheShelf == 0) {
//    		Product prod = prodBus.get(prodIdNew);
//    		prod.addShelfId(shelf.getID());
//    		shelf.setProdutoId(prodIdNew);
//    	} else {
//    		if (!isRemove) {
//    			Product prod2 = prodBus.get(prodIdNew);
//    			shelf.setProdutoId(prodIdNew);
//    			prod2.addShelfId(shelf.getID());	
//    		}else {
//    			Product prod = prodBus.get(productInTheShelf);
//    			prod.removeShelfId(shelf.getID());
//    		}
//    		
//    	}
}
//    	

	protected String getEntityClassName() {
		return Shelf.getName();
		
		
	}

}
    
	


