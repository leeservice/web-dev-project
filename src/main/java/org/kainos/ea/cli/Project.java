package org.kainos.ea.cli;

import java.sql.Date;

public class Project {

    private int projectId;
    private String name;
    private double value;
    private Date projectStartDate;
    private Date projectEndDate;
    private int techLeadId;
    private int clientId;


    public Project(int projectId, String name, double value, Date projectStartDate, Date projectEndDate, int techLeadId, int clientId) {
        setProjectId(projectId);
        setName(name);
        setValue(value);
        setProjectStartDate(projectStartDate);
        setProjectEndDate(projectEndDate);
        setTechLeadId(techLeadId);
        setClientId(clientId);
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public int getTechLeadId() {
        return techLeadId;
    }

    public void setTechLeadId(int techLeadId) {
        this.techLeadId = techLeadId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
