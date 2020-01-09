package pt.upacademy.stockManagementProjectMysql.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import pt.upacademy.stockManagementProjectMysql.business.ProductBusiness;
import pt.upacademy.stockManagementProjectMysql.business.ShelfBusiness;
import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.models.ShelfDTO;
import pt.upacademy.stockManagementProjectMysql.repositories.ShelfRepository;

@RequestScoped
@Path("shelves")
public class ShelfController extends EntityController <ShelfBusiness,ShelfRepository,Shelf, ShelfDTO> {
	@Inject 
	ProductBusiness prodBus;
	
@DELETE 
@Path("/{id}")
public void deleteShelf (@PathParam("id") long id, ShelfDTO s) {
	Shelf shelf = toEntity (s);
	busEnt.delete(shelf.getID());
}


@Override
public Shelf toEntity(ShelfDTO entDTO) {
	Product product;
	if (entDTO.getProdutoId() != 0) {
		product = prodBus.get(entDTO.getProdutoId());
	}else {
		product = null;
	}
	
	Shelf shelf = new Shelf(entDTO.getCapacidade(), product , entDTO.getDailyPrice());
	if(entDTO.getId() > 0) {
		shelf.setID(entDTO.getId());
	}
	return shelf;

}


	
}
