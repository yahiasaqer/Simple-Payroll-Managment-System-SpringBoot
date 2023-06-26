package com.odhiambopaul.demo.bootstrap;

import com.odhiambopaul.demo.model.Employee;
import com.odhiambopaul.demo.model.EmployeeStatus;
import com.odhiambopaul.demo.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLoader implements CommandLineRunner {
    public final EmployeeRepository employeeRepository;

    public EmployeeLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadEmployees();
    }

    private void loadEmployees() {
        if (employeeRepository.count() == 0) {
            employeeRepository.save(
                    Employee.builder()
                            .username("Yahia")
                            .salary(455)
                            .status(EmployeeStatus.WORKING)
                            .build()
            );
            employeeRepository.save(
                    Employee.builder()
                            .username("Ali")
                            .salary(555)
                            .status(EmployeeStatus.WORKING)
                            .build()
            );
            System.out.println("Sample Employees Loaded");
        }
    }
}
