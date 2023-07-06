package org.kainos.ea.api;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.EmployeeRequestValidator;
import org.kainos.ea.core.EmployeeValidator;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;
import java.util.List;


public class EmployeeService {

        private EmployeeDao employeeDao = new EmployeeDao();

        private EmployeeValidator employeeValidator = new EmployeeValidator();
    private EmployeeRequestValidator employeeRequestValidator = new EmployeeRequestValidator();


    public int createEmployee (EmployeeRequest employee) throws FailedToCreateEmployeeException, InvalidEmployeeException {

        try {

            String validation = employeeRequestValidator.isValidEmployee(employee);

            if (validation != null) {
                throw new InvalidEmployeeException(validation);
            }

            int id = employeeDao.createEmployee(employee);

            if (id < 1) {
                throw new FailedToCreateEmployeeException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateEmployeeException();
        }
    }

    public void updateDeliveryEmployee(int id, EmployeeRequest employee) throws InvalidEmployeeException, EmployeeDoesNotExistException, FailedToUpdateEmployeeException {
        try{
            String validation = employeeRequestValidator.isValidEmployee(employee);
            if (validation != null){
                throw new InvalidEmployeeException(validation);
            }

            EmployeeRequest employeeToUpdate = employeeDao.getEmployeeByID(id);

            if (employeeToUpdate == null){
                throw new EmployeeDoesNotExistException();
            }

            employeeDao.updateEmployee(id, employee);
        } catch (SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToUpdateEmployeeException();
        }
    }

          
          public EmployeeRequest getEmployeeByID(int id) throws FailedToGetEmployeeException, EmployeeDoesNotExistException {

            try {
                EmployeeRequest employee = employeeDao.getEmployeeByID(id);

                if (employee == null) {
                    throw new EmployeeDoesNotExistException();
                }
                return employee;
            } catch (SQLException e){
                System.err.println(e.getMessage());
                throw new FailedToGetEmployeeException();
            }
        }
                


    public void deleteEmployee(int id) throws EmployeeDoesNotExistException, FailedToDeleteEmployeeException {
        try {
            EmployeeRequest employeeToDelete = employeeDao.getEmployeeByID(id);

            if(employeeToDelete == null) {
                throw new EmployeeDoesNotExistException();
            }

            employeeDao.deleteEmployee(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToDeleteEmployeeException();
        }
    }


    public List<EmployeeRequest> getAllEmployees() throws FailedToCreateEmployeeException {
        List<EmployeeRequest> employeeRequestList = null;
        try {
            employeeRequestList = employeeDao.getAllEmployees();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        employeeRequestList.stream().forEach(System.out::println);
        return employeeRequestList;
    }


}
