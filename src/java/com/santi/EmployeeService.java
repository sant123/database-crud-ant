/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.santi;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author sant821
 */
@Path("employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeService {
    
    @EJB
    private EmployeeDAO employeeDAO;
    
    @GET
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }
    
    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        Employee e = employeeDAO.getById(id);
        
        if (e == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok(e).build();
    }
    
    @POST
    public Response create(Employee e) {
        employeeDAO.create(e);
        return Response.status(Response.Status.CREATED).entity(e).build();
    }
    
    @PUT
    public Response update(Employee e) {
        try {
            employeeDAO.update(e);
            return Response.ok(e).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response destroy(@PathParam("id") int id) {
        try {
            employeeDAO.destroy(id);
            return Response.noContent().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
