package pt.upacademy.stockManagementProjectMysql.controllers;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
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
import pt.upacademy.stockManagementProjectMysql.models.MyEntity;
import pt.upacademy.stockManagementProjectMysql.repositories.EntityRepository;


public abstract class EntityController <T extends EntityBusiness <R,E>, R extends EntityRepository <E>, E extends MyEntity> {

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
 
 @POST 
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public E addEntity (E ent)  {
	 		busEnt.save(ent);
	 		return ent;
	 	
 }
 
 @POST 
 @Path("list")
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public List <E> addEntityList (List <E> listEnts) {
		 for (E ent : listEnts) {
			 busEnt.save(ent);
		 }
	 return listEnts;	
 }
 
 @GET
 @Produces (MediaType.APPLICATION_JSON)
 public Collection<E> consultAllEnts () {
	 return busEnt.consultAll();
	 
 }
 @GET
 @Path("/{id}")
 @Produces (MediaType.APPLICATION_JSON)
 public E consultEntById (@PathParam("id") long id) {
	 return  busEnt.get(id);
		 
	
 }
 
 @PUT
 @Path("/list")
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public List <E> updateEntList (@PathParam("id") long id, List <E> listEnts) {
	 
		 for (E ent : listEnts) {
		 busEnt.update(ent); 
		 }
	 return listEnts;	
 }
 
 @PUT
 @Path("/{id}")
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public Response updateEnt (@PathParam("id") long id, E ent) {
	 try {
		 busEnt.update(ent); 
	 }  catch (IllegalArgumentException e1) {
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel editar a entidade. ").build();
	 } catch (Exception e) {
		 e.printStackTrace();
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel editar a entidade. ").build(); 
	 }
	 return Response.status(Response.Status.OK).entity(ent).build();	
 }

 @DELETE 
 @Path("/{id}")
 public Response deleteEnt (@PathParam("id") long id, E ent) {
	 try {
		 busEnt.delete(ent.getID()); 
	 }  catch (IllegalArgumentException e1) {
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel apagar a entidade. ").build();
	 } 
	 return Response.status(Response.Status.OK).entity("Entidade apagada").build();
 }
 }
 
 

 
 
