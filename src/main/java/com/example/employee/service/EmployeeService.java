package com.example.employee.service;

import com.example.employee.dto.response.WrapperDTO;


public interface EmployeeService {

    WrapperDTO getEmployeeList();

    WrapperDTO getEmployeeListById(Long employeeId);

}
