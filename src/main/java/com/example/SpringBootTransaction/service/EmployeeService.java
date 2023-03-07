package com.example.SpringBootTransaction.service;

import com.example.SpringBootTransaction.entity.Department;
import com.example.SpringBootTransaction.entity.Employee;
import com.example.SpringBootTransaction.repository.DepartmentRepository;
import com.example.SpringBootTransaction.repository.EmployeeRepository;
import com.example.SpringBootTransaction.vo.EmployeeRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public String saveEmployee(EmployeeRequestVo employeeRequestVo) {
        Department department = new Department();
        department.setDepartmentName(employeeRequestVo.getDepartmentName());
        department.setDepartmentCode(employeeRequestVo.getDepartmentName());

        Long departmentId = departmentRepository.save(department).getDepartmentId();

        Employee employee = new Employee();
        employee.setEmpName(employeeRequestVo.getEmpName());
        employee.setEmail(employeeRequestVo.getEmail());
        employee.setDepartmentId(departmentId);

        employeeRepository.save(employee);

        return "Employee is saved with EmployeeID : " + employee.getEmployeeId();
    }
}
