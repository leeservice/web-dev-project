package org.kainos.ea.resources;

import org.kainos.ea.api.SalesEmployeeService;
import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.SalesEmployeeRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.client.EmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToCreateEmployeeException;
import org.kainos.ea.client.FailedToGetEmployeeException;
import org.kainos.ea.client.FailedToUpdateEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;
import io.swagger.annotations.Api;

import org.kainos.ea.client.*;
@Api("Sales Employee API")
@Path("/api")
public class SalesEmployeeController {

    private SalesEmployeeService salesEmployeeService = new SalesEmployeeService();

    @POST
    @Path("/salesemployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesEmployee employee) {
        try{                                                     VVV need to pass a call to saleEmployeeService.createSalesEmployee()
            return Response.status(Response.Status.CREATED).entity(employee.).build();
//        } catch (FailedToCreateEmployeeException e) {
//            System.err.println(e.getMessage());
//
//            return Response.serverError().entity(e.getMessage()).build();
//        } catch (InvalidEmployeeException e){
//            System.err.println(e.getMessage());
//
//            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
//        }
    }

    @GET
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployeeByID(@PathParam("id") int id){

        try {
            return Response.ok(employeeService.getEmployeeByID(id)).build();
        } catch (FailedToGetEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (EmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();        }
    }

    @GET //accessed via http GET request
    @Path("/employee") //URL ends with /products
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSalesEmployees() {
        try {
            return Response.ok(employeeService.getAllEmployees()).build();
        } catch (FailedToCreateEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response updateSalesEmployees(@PathParam("id") int id, EmployeeRequest employee){

        try{
            employeeService.updateDeliveryEmployee(id, employee);

            return Response.ok().build();
        } catch (FailedToUpdateEmployeeException e){
            System.err.println(e.getMessage());

            return Response.serverError().entity(e.getMessage()).build();
        } catch (InvalidEmployeeException | EmployeeDoesNotExistException e){
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }


    @DELETE
    @Path("/employees/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSalesEmployee(@PathParam("id") int id){
        try{
            employeeService.deleteEmployee(id);

            return Response.ok().build();
        } catch (EmployeeDoesNotExistException e){
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToDeleteEmployeeException e){
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

}
