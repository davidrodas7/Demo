package com.example.employee.dto;


public class EmployeeDTO {

    private Long id;
    private String employee_name;
    private Long employee_salary;
    private Long employee_annual_salary;
    private Long employee_age;
    private String profile_image;

    public EmployeeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Long getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Long employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Long getEmployee_annual_salary() {
        return employee_annual_salary;
    }

    public void setEmployee_annual_salary(Long employee_annual_salary) {
        this.employee_annual_salary = employee_annual_salary;
    }

    public Long getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Long employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

}
