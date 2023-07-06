package org.kainos.ea.cli;

import java.sql.Date;

public class Client {
    private int clientId;
    private String name;
    private String address;
    private String phoneNo;
    private Date joinDate;
    private int salesEmployeeId;

    public Client(int clientId, String name, String address, String phoneNo, Date joinDate, int salesEmployeeId) {
        setClientId(clientId);
        setName(name);
        setAddress(address);
        setPhoneNo(phoneNo);
        setJoinDate(joinDate);
        setSalesEmployeeId(salesEmployeeId);
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public void setSalesEmployeeId(int salesEmployeeId) {
        this.salesEmployeeId = salesEmployeeId;
    }
}
