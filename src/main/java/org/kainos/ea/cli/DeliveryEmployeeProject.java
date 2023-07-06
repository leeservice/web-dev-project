package org.kainos.ea.cli;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

abstract class DeliveryEmployeeProject {

    private int deliveryEmployeeId;
    private int projectId;
    private Date startDate;
    private Date endDate;

    @JsonCreator
    public DeliveryEmployeeProject(@JsonProperty("deliveryEmployeeId") int deliveryEmployeeId,
                                   @JsonProperty("projectId") int projectId,
                                   @JsonProperty("startDate") Date startDate,
                                   @JsonProperty("endDate") Date endDate) {
        this.deliveryEmployeeId = deliveryEmployeeId;
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getDeliveryEmployeeId() {
        return deliveryEmployeeId;
    }

    public void setDeliveryEmployeeId(int deliveryEmployeeId) {
        this.deliveryEmployeeId = deliveryEmployeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
