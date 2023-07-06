package org.kainos.ea.client;

public class SalesEmployeeDoesNotExistException extends Throwable {
    @Override
    public String getMessage(){
        return "Sales Employee with that ID does not exist";
    }
}
