package com.example.employee.feign;

import com.example.employee.dto.response.WrapperExampleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;



@FeignClient(value = "exampleAPI", url = "https://dummy.restapiexample.com/api/v1")
public interface EmployeeExampleFeignClient {

    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    WrapperExampleDTO findAllEmployees(@RequestHeader("Cookie") String cookie);

    @GetMapping(path = "/employee/{idEmployee}", produces = MediaType.APPLICATION_JSON_VALUE)
    WrapperExampleDTO findEmployeeById(@RequestHeader("Cookie") String cookie,
                                 @PathVariable("idEmployee") Long idEmployee);
}
