package com.odhiambopaul.demo.controllers;

import com.odhiambopaul.demo.model.Employee;
import com.odhiambopaul.demo.services.EmployeeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping({"/{employeeId}"})
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.getById(employeeId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.insert(employee);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("employee", "/employee" + employee1.getEmployee_id());
        return new ResponseEntity<>(employee1, httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping({"/{employeeId}"})
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee) {
        employeeService.update(employeeId, employee);
        return new ResponseEntity<>(employeeService.getById(employeeId), HttpStatus.OK);
    }
    @DeleteMapping({"/{Employee}"})
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("Employee") Long Employee) {
        employeeService.delete(Employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
