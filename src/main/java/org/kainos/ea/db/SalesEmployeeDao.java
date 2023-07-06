package org.kainos.ea.db;

import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.SalesEmployeeRequest;

import java.sql.*;

import static org.kainos.ea.db.DatabaseConnector.getConnection;

public class SalesEmployeeDao {

    public int createSalesEmployee(SalesEmployee employee) throws SQLException {
        Connection c = getConnection();

        String insertStatement = "INSERT INTO salesEmployee(employeeId, commissionRate) VALUES (?, ?);";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setInt(1, employee.getEmployeeId());
        st.setFloat(2, employee.getCommissionRate());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()){
            return rs.getInt(1);
        }

        return -1;
    }

    public void updateSalesEmployee(int id, SalesEmployee employee) throws SQLException{
        Connection c = DatabaseConnector.getConnection();

        String updateStatement = "UPDATE salesEmployee SET employeeId = ?, CommissionRate = ? WHERE salesEmployeeId = " +id;

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, employee.getEmployeeId());
        st.setFloat(2, employee.getCommissionRate());

        st.executeUpdate();

    }

    public SalesEmployee getSalesEmployeeByID(int id) throws SQLException {
        Connection c = getConnection();
        Statement st = c.createStatement();

        String selectStatement = "SELECT salesEmployeeId, commissionRate FROM salesEmployee WHERE salesEmployeeId = " + id;

        ResultSet rs = st.executeQuery(selectStatement);


        while (rs.next()) {
            return new SalesEmployee(
                    rs.getInt("SalesEmployeeID"),
                    rs.getString("Name"),
                    rs.getFloat("Salary"),
                    rs.getString("BankAccountNo"),
                    rs.getString("NatInsuranceNo"),
                    rs.getFloat("CommissionRate")
            );

        }
        return null;
    }
}
