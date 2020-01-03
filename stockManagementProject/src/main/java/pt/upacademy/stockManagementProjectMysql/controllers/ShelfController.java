package pt.upacademy.stockManagementProjectMysql.controllers;

import javax.ws.rs.Path;

import pt.upacademy.stockManagementProjectMysql.business.ShelfBusiness;
import pt.upacademy.stockManagementProjectMysql.models.Shelf;
import pt.upacademy.stockManagementProjectMysql.repositories.ShelfRepository;

@Path("shelves")
public class ShelfController extends EntityController <ShelfBusiness,ShelfRepository,Shelf> {
	
	public ShelfController () {
		this.busEnt = new ShelfBusiness ();
	}
	
	

}
