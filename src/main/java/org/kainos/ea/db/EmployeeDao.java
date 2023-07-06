package org.kainos.ea.db;

import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.kainos.ea.db.DatabaseConnector.getConnection;

public class EmployeeDao {
     public int createEmployee(EmployeeRequest employee) throws SQLException {
            Connection c = getConnection();

            String insertStatement = "INSERT INTO employee(name, salary, bankAccountNo, natInsuranceNo) VALUES (?, ?, ?, ?);";

            PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, employee.getName());
            st.setDouble(2, employee.getSalary());
            st.setString(3, employee.getBankAccountNo());
            st.setString(4, employee.getNatInsuranceNo());

            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()){
                return rs.getInt(1);
            }

            return -1;
        }

        public void updateEmployee(int id, EmployeeRequest employee) throws SQLException{
            Connection c = DatabaseConnector.getConnection();

            String updateStatement = "UPDATE employee SET name = ?, salary = ?, bankAccountNo = ?, natInsuranceNo = ? WHERE employeeId = ?;";

            PreparedStatement st = c.prepareStatement(updateStatement);

            st.setString(1, employee.getName());
            st.setDouble(2, employee.getSalary());
            st.setString(3, employee.getBankAccountNo());
            st.setString(4, employee.getNatInsuranceNo());
            st.setInt(5, id);

            st.executeUpdate();

        }

        public EmployeeRequest getEmployeeByID(int id) throws SQLException {
            Connection c = getConnection();
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery("SELECT `name`,salary,bankAccountNo,natInsuranceNo FROM employee WHERE employeeId = "+id);

            while (rs.next()) {
                return new EmployeeRequest(
                        rs.getString("name"),
                        rs.getFloat("salary"),
                        rs.getString("bankAccountNo"),
                        rs.getString("natInsuranceNo")
                );

            }
            return null;
        }

        public void deleteEmployee(int id) throws SQLException {
            Connection c = DatabaseConnector.getConnection();

            String deleteStatement = "DELETE FROM `employee` WHERE employeeId = ?;";

            PreparedStatement st = c.prepareStatement(deleteStatement);

            st.setInt(1, id);

            st.executeUpdate();
        }


        public List<EmployeeRequest> getAllEmployees() throws SQLException {
            Connection c = getConnection();
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery("SELECT name,salary,bankAccountNo,natInsuranceNo FROM employee;");

            List<EmployeeRequest> employeeList = new ArrayList<>();

            while (rs.next()) {
                EmployeeRequest employee = new EmployeeRequest(
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getString("bankAccountNo"),
                        rs.getString("natInsuranceNo")
                );

                employeeList.add(employee);
            }
            return employeeList;
        }

    }

