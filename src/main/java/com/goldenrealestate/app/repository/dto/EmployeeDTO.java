package com.goldenrealestate.app.repository.dto;

import com.goldenrealestate.app.model.Employee;

public class EmployeeDTO {


    private String employeeName;
    private String emailID;
    private String contactNo;

    public EmployeeDTO(Employee employee) {

        this.employeeName =employee.getEmployeeName();
        this.emailID =employee.getEmailID();
        this.contactNo=employee.getContactNo();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

}
