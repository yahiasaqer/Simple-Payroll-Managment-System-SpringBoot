package com.odhiambopaul.demo.services;

import com.odhiambopaul.demo.model.Employee;
import com.odhiambopaul.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee insert(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void update(Long id, Employee employee) {
        Employee employeeFromDb = employeeRepository.findById(id).get();
        System.out.println(employeeFromDb.toString());
        employeeFromDb.setStatus(employee.getStatus());
        employeeRepository.save(employeeFromDb);
    }

    @Override
    public void delete(Long employee_id) {
        employeeRepository.deleteById(employee_id);
    }
}
