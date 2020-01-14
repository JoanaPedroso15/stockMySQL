package pt.upacademy.stockManagementProjectMysql.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import pt.upacademy.stockManagementProjectMysql.business.EntityBusiness;
import pt.upacademy.stockManagementProjectMysql.models.EntityDTO;
import pt.upacademy.stockManagementProjectMysql.models.MyEntity;
import pt.upacademy.stockManagementProjectMysql.repositories.EntityRepository;

@Transactional
public abstract class EntityController <T extends EntityBusiness <R,E,D>, R extends EntityRepository <E,D>, E extends MyEntity<D>, D extends EntityDTO> {

	@Inject
	protected T busEnt;
	
 @Context
 protected UriInfo context;
	
 @GET 
 @Path("status")
 @Produces(MediaType.TEXT_PLAIN)
	 public String status () {
		 return "Url: " + context.getRequestUri().toString() + " is Ok";
	 }

 @GET
 @Produces (MediaType.APPLICATION_JSON)
 public List<D> consultAllEnts () {
	 return busEnt.consultAll().stream().map(E :: toDTO).collect(Collectors.toList());
	 
 }
 
 @GET
 @Path("/{id}")
 @Produces (MediaType.APPLICATION_JSON)
 public D consultEntById (@PathParam("id") long id) {
	 return  busEnt.get(id).toDTO();
		 
	
 }
 
 @POST 
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public D addEntity (D entDTO)  {
	 	E ent = this.toEntity(entDTO);
	 	E savedEnt = busEnt.save(ent);
	 	D eNew = savedEnt.toDTO();
	 		return eNew;
	
 }
 
 @POST 
 @Path("list")
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public List <D> addEntityList (List <D> listEntsDTO) {
	 List <D> listentsDTONew = new ArrayList <D> ();
		 for (D entDTO : listEntsDTO) {
			 D pNew = this.addEntity(entDTO);
			 listentsDTONew.add(pNew);
		 }
		 
	 return listentsDTONew;	
 }
 

 
 @PUT
 @Path("/{id}")
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public Response updateEnt (@PathParam("id") long id, D entDTO) {
	 try {
		E ent = this.toEntity(entDTO);
		 E updatedEnt = busEnt.update(ent); 
		 D eNew = updatedEnt.toDTO();
	 }  catch (IllegalArgumentException e1) {
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel editar a entidade. ").build();
	 } catch (Exception e) {
		 e.printStackTrace();
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel editar a entidade. ").build(); 
	 }
	 return Response.status(Response.Status.OK).entity(entDTO).build();	
 }


 @PUT
 @Path("/list")
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public List <D> updateEntList (@PathParam("id") long id, List <D> listEntsDTOs) {
	 List <D> listentDTONew = new ArrayList <D> ();
		 for (D entDTO : listEntsDTOs) {
			 E ent = this.toEntity(entDTO);
			 E updatedEnt = busEnt.update(ent); 
			 D eNew = updatedEnt.toDTO();
			 listentDTONew.add(eNew);
		 }
	 return listentDTONew;	
 }
 


 
 @DELETE 
 @Path("/{id}")
 @Produces (MediaType.TEXT_PLAIN)
 public Response deleteEnt (@PathParam("id") long id) {
	 try {
		 busEnt.delete(id); 
	 }  catch (IllegalArgumentException e1) {
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel apagar a entidade. ").build();
	 } 
	 return Response.status(Response.Status.OK).entity("Entidade apagada").build();
 }
 

 public abstract E toEntity(D entDTO);
 
 }
 
 

 
 
