package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeRequest extends EmployeeRequest {

    private float commisionRate;

    @JsonCreator
    public SalesEmployeeRequest(@JsonProperty("name") String name, @JsonProperty("salary") double salary, @JsonProperty("bankAccountNo") String bankAccountNo,@JsonProperty("natInsuranceNo") String natInsuranceNo, @JsonProperty("commissionRate") float commisionRate) {
        super(name, salary, bankAccountNo, natInsuranceNo);
        setCommisionRate(commisionRate);
    }

    public float getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(float commisionRate) {
        this.commisionRate = commisionRate;
    }
}
