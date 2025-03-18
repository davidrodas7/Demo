package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;

public interface DataConverter {

    EmployeeDTO convertToEmployeeDTO(Object data);

}
