package com.odhiambopaul.demo.services;

import com.odhiambopaul.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getById(Long empolyee_id);

    Employee insert(Employee employee);

    void update(Long employee_id, Employee employee);

    void delete(Long employeeId);
}
