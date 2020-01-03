package pt.upacademy.stockManagementProjectMysql.controllers;

import java.util.Collection;
import java.util.List;

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
 public Response addEntity (E ent)  {
	 	try {
	 		busEnt.save(ent);
	 	}
	 	catch (Exception e) {
	 		
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel criar a entidade. " + e.getMessage()).build();
	 }
	 	return Response.status(Response.Status.OK).entity(ent).build();	
 }
 
 @POST 
 @Path("list")
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public Response addEntityList (List <E> listEnts) {
	 try {
		 for (E ent : listEnts) {
			 busEnt.save(ent);
		 } 
	 } catch (Exception e) {
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel criar a entidade. " + e.getMessage()).build(); 
	 }
	 return Response.status(Response.Status.OK).entity(listEnts).build();	
 }
 
 @GET
 @Produces (MediaType.APPLICATION_JSON)
 public Collection<E> consultAllEnts () {
	 return busEnt.consultAll();
	 
 }
 @GET
 @Path("/{id}")
 @Produces (MediaType.APPLICATION_JSON)
 public Response consultEntById (@PathParam("id") long id) {
	 try {
		 busEnt.get(id);
		 
	 }  
	 catch (IllegalArgumentException e1) {
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel consultar a entidade. " + e1.getMessage()).build(); 
	 }
	 return Response.status(Response.Status.OK).entity(busEnt.get(id)).build();
 }
 
 @PUT
 @Path("/list")
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public Response updateEntList (@PathParam("id") long id, List <E> listEnts) {
	 try {
		 for (E ent : listEnts) {
		 busEnt.update(ent); 
		 }
	 }  catch (IllegalArgumentException e1) {
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel editar a entidade. " + e1.getMessage()).build();
	 } catch (Exception e) {
		 e.printStackTrace();
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel editar a entidade. " + e.getMessage()).build(); 
	 }
	 return Response.status(Response.Status.OK).entity(listEnts).build();	
 }
 
 @PUT
 @Path("/{id}")
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 public Response updateEnt (@PathParam("id") long id, E ent) {
	 try {
		 busEnt.update(ent); 
	 }  catch (IllegalArgumentException e1) {
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel editar a entidade. " + e1.getMessage()).build();
	 } catch (Exception e) {
		 e.printStackTrace();
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel editar a entidade. " + e.getMessage()).build(); 
	 }
	 return Response.status(Response.Status.OK).entity(ent).build();	
 }

 @DELETE 
 @Path("/{id}")
 public Response deleteEnt (@PathParam("id") long id) {
	 try {
		 busEnt.delete(id); 
	 }  catch (IllegalArgumentException e1) {
		 return Response.status(Response.Status.BAD_REQUEST).entity("Nao foi possivel apagar a entidade. " + e1.getMessage()).build();
	 } 
	 return Response.status(Response.Status.OK).entity("Entidade apagada").build();
 }
 }
 
 
