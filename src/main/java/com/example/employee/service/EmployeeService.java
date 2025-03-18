package com.example.employee.service;

import com.example.employee.dto.response.WrapperDTO;

import java.io.IOException;

public interface EmployeeService {

    WrapperDTO getEmployeeList();

    WrapperDTO getEmployeeListById(Long employeeId);

}
