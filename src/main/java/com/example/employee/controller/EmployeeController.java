package com.example.employee.controller;

import com.example.employee.dto.response.WrapperDTO;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WrapperDTO> getEmployeeList() {
        WrapperDTO wrapperDTO = employeeService.getEmployeeList();
        return new ResponseEntity<>(wrapperDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getList/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WrapperDTO> getEmployeeListById(@PathVariable("employeeId") Long employeeId) {
        WrapperDTO wrapperDTO = employeeService.getEmployeeListById(employeeId);
        return new ResponseEntity<>(wrapperDTO, HttpStatus.OK);
    }

}
