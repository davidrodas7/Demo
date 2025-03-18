package com.example.employee.service.impl;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.dto.response.WrapperDTO;
import com.example.employee.dto.response.WrapperExampleDTO;
import com.example.employee.hystrix.EmployeeExampleCommand;
import com.example.employee.service.DataConverter;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeExampleCommand employeeExampleCommand;

    @Mock
    private DataConverter dataConverter;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    public EmployeeServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEmployeeList_successfulResponse() {
        WrapperExampleDTO mockResponse = new WrapperExampleDTO();
        mockResponse.setStatus("success");
        mockResponse.setMessage("Data retrieved successfully");
        List<LinkedHashMap<String, Object>> mockData = new ArrayList<>();
        LinkedHashMap<String, Object> mockEmployee = new LinkedHashMap<>();
        mockEmployee.put("id", 1L);
        mockEmployee.put("name", "John Doe");
        mockData.add(mockEmployee);
        mockResponse.setData(mockData);

        EmployeeDTO mockEmployeeDTO = new EmployeeDTO();
        mockEmployeeDTO.setId(1L);
        mockEmployeeDTO.setEmployeeName("John Doe");

        when(employeeExampleCommand.findAllEmployees()).thenReturn(mockResponse);
        when(dataConverter.convertToEmployeeDTO(mockEmployee)).thenReturn(mockEmployeeDTO);

        WrapperDTO result = employeeServiceImpl.getEmployeeList();

        assertNotNull(result);
        assertEquals("success", result.getStatus());
        assertEquals("Data retrieved successfully", result.getMessage());
        assertNotNull(result.getData());
        List<?> employees = (List<?>) result.getData();
        assertEquals(1, employees.size());
        assertEquals(mockEmployeeDTO, employees.get(0));
    }

    @Test
    void getEmployeeList_emptyResponse() {
        WrapperExampleDTO mockResponse = new WrapperExampleDTO();
        mockResponse.setStatus("success");
        mockResponse.setMessage("No data available");
        mockResponse.setData(new ArrayList<>());

        when(employeeExampleCommand.findAllEmployees()).thenReturn(mockResponse);

        WrapperDTO result = employeeServiceImpl.getEmployeeList();

        assertNotNull(result);
        assertEquals("success", result.getStatus());
        assertEquals("No data available", result.getMessage());
        assertNotNull(result.getData());
        List<?> employees = (List<?>) result.getData();
        assertEquals(0, employees.size());
    }

    @Test
    void getEmployeeList_exceptionThrown() {
        when(employeeExampleCommand.findAllEmployees()).thenThrow(new RuntimeException("Service unavailable"));

        WrapperDTO result = employeeServiceImpl.getEmployeeList();

        assertNotNull(result);
        assertEquals("error", result.getStatus());
        assertEquals("Error: Service unavailable", result.getMessage());
        assertNotNull(result.getData());
        List<?> employees = (List<?>) result.getData();
        assertEquals(0, employees.size());
    }

    @Test
    void getEmployeeListById_successfulResponse() {
        WrapperExampleDTO mockResponse = new WrapperExampleDTO();
        mockResponse.setStatus("success");
        mockResponse.setMessage("Data retrieved successfully");
        LinkedHashMap<String, Object> mockEmployee = new LinkedHashMap<>();
        mockEmployee.put("id", 1L);
        mockEmployee.put("name", "John Doe");
        mockResponse.setData(mockEmployee);

        EmployeeDTO mockEmployeeDTO = new EmployeeDTO();
        mockEmployeeDTO.setId(1L);
        mockEmployeeDTO.setEmployeeName("John Doe");

        when(employeeExampleCommand.findAllEmployeesById(1L)).thenReturn(mockResponse);
        when(dataConverter.convertToEmployeeDTO(mockEmployee)).thenReturn(mockEmployeeDTO);

        WrapperDTO result = employeeServiceImpl.getEmployeeListById(1L);

        assertNotNull(result);
        assertEquals("success", result.getStatus());
        assertEquals("Data retrieved successfully", result.getMessage());
        assertNotNull(result.getData());
        List<?> employees = (List<?>) result.getData();
        assertEquals(1, employees.size());
        assertEquals(mockEmployeeDTO, employees.get(0));
    }

    @Test
    void getEmployeeListById_exceptionThrown() {
        when(employeeExampleCommand.findAllEmployeesById(1L)).thenThrow(new RuntimeException("Service unavailable"));

        WrapperDTO result = employeeServiceImpl.getEmployeeListById(1L);
    }
}
