package org.kainos.ea.core;

import org.kainos.ea.cli.SalesEmployeeRequest;

public class SalesEmployeeRequestValidator extends EmployeeRequestValidator {

    public String isValidEmployee(SalesEmployeeRequest salesEmployee) {


        if (salesEmployee.getCommisionRate() < 0.0f ) {
            return "Commission Rate is less than 0";
        }
        return null;
    }


}
