package com.example.SpringBootTransaction.controller;

import com.example.SpringBootTransaction.entity.Employee;
import com.example.SpringBootTransaction.service.EmployeeService;
import com.example.SpringBootTransaction.vo.EmployeeRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public String saveEmployee(@RequestBody EmployeeRequestVo employeeRequestVo) {

        return employeeService.saveEmployee(employeeRequestVo);
    }
}
