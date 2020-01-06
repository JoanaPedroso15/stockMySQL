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

import pt.upacademy.stockManagementProjectMysql.business.ShelfBusiness;
import pt.upacademy.stockManagementProjectMysql.models.Product;
import pt.upacademy.stockManagementProjectMysql.models.ProductDTO;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.models.ShelfDTO;
import pt.upacademy.stockManagementProjectMysql.repositories.ShelfRepository;

@Path("shelves")
public class ShelfController extends EntityController <ShelfBusiness,ShelfRepository,Shelf> {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShelfDTO> getAll() {
		return busEnt.consultAll().stream()
				.map(shelf -> new ShelfDTO(
						shelf.getCapacidade(),
						shelf.getProduto().getID(),
						shelf.getDailyPrice()
						)
				)
				.collect(Collectors.toList());
	}
	
	
@GET
@Path("/{id}")
@Produces (MediaType.APPLICATION_JSON)
public ShelfDTO getEntById (@PathParam("id") long id) {
			Shelf shelf = busEnt.get(id);
			ShelfDTO s = new ShelfDTO (
					shelf.getCapacidade(),
					shelf.getProduto().getID(),
					shelf.getDailyPrice()
					);
		return s;
}
			 
		
@POST 
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public ShelfDTO addShelf (ShelfDTO s)  {
	Shelf shelf = busEnt.convertShelfDTOtoShelf (s);
	ShelfDTO sNew = busEnt.convertShelftoShelfDTO(shelf);
	busEnt.save(shelf);
	return sNew;
	 	
}

@POST 
@Path("list")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public List <ShelfDTO> addShelfList (List <ShelfDTO> listshelvesDTO) {
	List <ShelfDTO> listshelvesDTONew = new ArrayList <ShelfDTO> ();
	for (ShelfDTO s : listshelvesDTO) {
		Shelf shelf = busEnt.convertShelfDTOtoShelf (s);
		 busEnt.save(shelf);
		 ShelfDTO sNew = busEnt.convertShelftoShelfDTO(shelf);
		 listshelvesDTONew.add(sNew);
	 }
	
	return listshelvesDTONew;
}

@PUT
@Path("/{id}")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public ShelfDTO updateShelf (@PathParam("id") long id, ShelfDTO s) {
	Shelf shelf = busEnt.convertShelfDTOtoShelf (s);
	ShelfDTO sNew = busEnt.convertShelftoShelfDTO(shelf);
	busEnt.save(shelf);
	return sNew;
}

@PUT
@Path("/list")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public List <ShelfDTO> updateShelfList (@PathParam("id") long id, List <ShelfDTO> listshelfDTO) {
	List <ShelfDTO> listshelvesDTONew = new ArrayList <ShelfDTO> ();
	for (ShelfDTO s : listshelfDTO) {
		Shelf shelf = busEnt.convertShelfDTOtoShelf (s);
		 busEnt.save(shelf);
		 ShelfDTO sNew = busEnt.convertShelftoShelfDTO(shelf);
		 listshelvesDTONew.add(sNew);
	 }
	
	return listshelvesDTONew;
	
}

@DELETE 
@Path("/{id}")
public void deleteShelf (@PathParam("id") long id, ShelfDTO s) {
	Shelf shelf = busEnt.convertShelfDTOtoShelf (s);
	busEnt.delete(shelf.getID());
}


	
}
