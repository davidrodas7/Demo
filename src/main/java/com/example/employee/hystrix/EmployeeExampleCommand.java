package com.example.employee.hystrix;


import com.example.employee.dto.response.WrapperExampleDTO;
import com.example.employee.feign.EmployeeExampleFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeExampleCommand {

    @Autowired
    private EmployeeExampleFeignClient employeeExampleFeignClient;

    private static final String COOKIE = "humans_21909=1";

    @HystrixCommand
    public WrapperExampleDTO findAllEmployees() {
        return employeeExampleFeignClient.findAllEmployees(COOKIE);
    }

    @HystrixCommand
    public WrapperExampleDTO findAllEmployeesById(Long idEmployee) {
        return employeeExampleFeignClient.findEmployeeById(COOKIE, idEmployee);
    }

}
