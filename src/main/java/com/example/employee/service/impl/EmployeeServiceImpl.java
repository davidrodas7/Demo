package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.dto.response.WrapperDTO;
import com.example.employee.dto.response.WrapperExampleDTO;
import com.example.employee.hystrix.EmployeeExampleCommand;
import com.example.employee.service.DataConverter;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeExampleCommand employeeExampleCommand;

    @Autowired
    private DataConverter dataConverter;


    @Override
    public WrapperDTO getEmployeeList() {
        WrapperDTO wrapperDTO = new WrapperDTO();
        try {
            WrapperExampleDTO responseExampleAPI =
                    employeeExampleCommand.findAllEmployees();

            List<EmployeeDTO> responseEmployee = ((List<?>) responseExampleAPI.getData())
                    .stream()
                    .map(data -> {
                        return dataConverter.convertToEmployeeDTO((LinkedHashMap<?, ?>) data);
                    }).collect(Collectors.toList());

            wrapperDTO.setStatus(responseExampleAPI.getStatus());
            wrapperDTO.setData(responseEmployee);
            wrapperDTO.setMessage(responseExampleAPI.getMessage());

        } catch (Exception e) {
            wrapperDTO.setStatus("error");
            wrapperDTO.setData(new ArrayList<>());
            wrapperDTO.setMessage("Error: " + e.getMessage());
        }

        return wrapperDTO;
    }

    @Override
    public WrapperDTO getEmployeeListById(Long employeeId) {
        WrapperDTO wrapperDTO = new WrapperDTO();
        try {
            WrapperExampleDTO responseExampleAPI =
                    employeeExampleCommand.findAllEmployeesById(employeeId);

            EmployeeDTO responseEmployee =
                    dataConverter.convertToEmployeeDTO((LinkedHashMap<?, ?>) responseExampleAPI.getData());

            wrapperDTO.setStatus(responseExampleAPI.getStatus());
            wrapperDTO.setData(Collections.singletonList(responseEmployee));
            wrapperDTO.setMessage(responseExampleAPI.getMessage());

        } catch (Exception e) {
            wrapperDTO.setStatus("error");
            wrapperDTO.setData(new ArrayList<>());
            wrapperDTO.setMessage("Error: " + e.getMessage());
        }
        return wrapperDTO;
    }
}
