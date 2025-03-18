package com.example.employee.dto;


public class EmployeeDTO {

    private Long id;
    private String employeeName;
    private Long employeeSalary;
    private Long employeeAnnualSalary;
    private Long employeeAge;
    private String profileImage;

    public EmployeeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Long getEmployeeAnnualSalary() {
        return employeeAnnualSalary;
    }

    public void setEmployeeAnnualSalary(Long employeeAnnualSalary) {
        this.employeeAnnualSalary = employeeAnnualSalary;
    }

    public Long getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Long employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

}
