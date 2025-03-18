package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.service.DataConverter;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class DataConverterImpl implements DataConverter {

    @Override
    public EmployeeDTO convertToEmployeeDTO(Object data) {
        LinkedHashMap<?, ?> map = (LinkedHashMap<?, ?>) data;
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(convertToLong(map.get("id")));
        employeeDTO.setEmployeeName((String) map.get("employee_name"));
        employeeDTO.setEmployeeSalary(convertToLong(map.get("employee_salary")));
        employeeDTO.setEmployeeAnnualSalary(convertToLong(map.get("employee_salary")) * 12L);
        employeeDTO.setEmployeeAge(convertToLong(map.get("employee_age")));
        employeeDTO.setProfileImage((String) map.get("profile_image"));
        return employeeDTO;
    }

    private Long convertToLong(Object value) {
        if (value instanceof String) {
            try {
                return Long.parseLong((String) value);
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (value instanceof Integer) {
            return ((Integer) value).longValue();
        } else if (value instanceof Long) {
            return (Long) value;
        } else {
            return null;
        }
    }
}

