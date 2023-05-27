package com.awsDBdemo.db1Demo.controller;

import com.awsDBdemo.db1Demo.model.Employee;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    EmployeeController employeeController;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setup() throws Throwable {
        employeeController = Mockito.mock(EmployeeController.class);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @AfterEach


    @Test
    @DisplayName("Test Get API call")
    void getAllEmployee() {
        Mockito.when(employeeController.getAllEmployee()).thenReturn(new ArrayList<Employee>());
        Assertions.assertNotNull(employeeController.getAllEmployee());
    }

    @Test
    void createEmployee() throws Exception {
        Employee getEmployee = new Employee();
        getEmployee.setFirstName("Angel");
        getEmployee.setLastName("Di Maria");
        getEmployee.setEmailId("Angel.DiMaria@yopmail.com");
        String employeeJson = "{\"firstName\":\"Angel\",\"lastName\":\"Di Maria\",\"emailId\":\"Angel.DiMaria@yopmail.com\"}";
        Mockito.when(employeeController.createEmployee(any(Employee.class))).thenReturn(getEmployee);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/employee")
                .accept(MediaType.APPLICATION_JSON)
                .content(employeeJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployee() {
    }
}