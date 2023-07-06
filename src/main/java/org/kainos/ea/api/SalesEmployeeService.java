package org.kainos.ea.api;

import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.SalesEmployeeRequestValidator;
import org.kainos.ea.core.SalesEmployeeValidator;
import org.kainos.ea.db.SalesEmployeeDao;

import java.sql.SQLException;
import java.util.List;


public class SalesEmployeeService extends EmployeeService{

    private SalesEmployeeDao salesEmployeeDao = new SalesEmployeeDao();

    private SalesEmployeeValidator salesemployeeValidator = new SalesEmployeeValidator();
    private SalesEmployeeRequestValidator salesEmployeeRequestValidator = new SalesEmployeeRequestValidator();


    public int createSalesEmployee (SalesEmployee employee) throws FailedToCreateEmployeeException, InvalidEmployeeException {

        try {

            String validation = salesEmployeeRequestValidator.isValidEmployee(employee);

            if (validation != null) {
                throw new InvalidEmployeeException(validation);
            }

            int id = salesEmployeeDao.createSalesEmployee(employee);

            if (id < 1) {
                throw new FailedToCreateEmployeeException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateEmployeeException();
        }
    }

    public void updateSalesEmployee(int id, SalesEmployeeRequest salesEmployee) throws InvalidEmployeeException, EmployeeDoesNotExistException, FailedToUpdateEmployeeException {
        try{
            String validation = salesemployeeValidator.isValidEmployee(salesEmployee);
            if (validation != null){
                throw new InvalidEmployeeException(validation);
            }

            EmployeeRequest employeeToUpdate = salesEmployeeDao.getEmployeeByID(id);

            if (employeeToUpdate == null){
                throw new EmployeeDoesNotExistException();
            }

            salesEmployeeDao.updateEmployee(id, salesEmployee);
        } catch (SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToUpdateEmployeeException();
        }
    }


    public SalesEmployee getSalesEmployeeByID(int id) throws FailedToGetEmployeeException, EmployeeDoesNotExistException {

        try {
            SalesEmployee salesEmployee = salesEmployeeDao.getSalesEmployeeByID(id);

            if (salesEmployee == null) {
                throw new EmployeeDoesNotExistException();
            }
            return salesEmployee;
        } catch (SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToGetEmployeeException();
        }
    }



    public void deleteSalesEmployee(int id) throws EmployeeDoesNotExistException, FailedToDeleteEmployeeException {
        try {
            SalesEmployeeRequest employeeToDelete = (id);

            if(employeeToDelete == null) {
                throw new EmployeeDoesNotExistException();
            }

            salesEmployeeDao.deleteEmployee(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToDeleteEmployeeException();
        }
    }


    public List<SalesEmployeeRequest> getAllSalesEmployees() throws FailedToCreateEmployeeException {
        List<SalesEmployeeRequest> salesEmployeeRequestList = null;
        try {
            salesEmployeeRequestList = salesEmployeeDao.getAllSalesEmployees();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        salesEmployeeRequestList.stream().forEach(System.out::println);
        return salesEmployeeRequestList;
    }


}
