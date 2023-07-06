package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliverEmployeeRequest extends  EmployeeRequest{

    public DeliverEmployeeRequest(@JsonProperty("name") String name,
                                  @JsonProperty("salary") double salary,
                                  @JsonProperty("bankAccountNo") String bankAccountNo,
                                  @JsonProperty("natInsuranceNo") String natInsuranceNo) {
        super(name, salary, bankAccountNo, natInsuranceNo);
    }
}
