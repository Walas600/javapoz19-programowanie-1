package pl.sdacademy.javapoz19programowanie1.employee;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> sortByAge() {
        return employeeRepository.sortByAge();
    }

    public List<Employee> sortBySalary() {
        return employeeRepository.sortBySalary();
    }

    public Map<String, List<Employee>> groupByAgeSegment() {
        List<Employee> employees = findAll();

        return employees.stream()
                .collect(Collectors.groupingBy(employee -> calculateAgeSegment(employee.getAge())));
    }

    private String calculateAgeSegment(int value) {
        int left = value - value % 5;
        int right = left + 5;
        return left + "-" + right;
    }

    public Double getAvgSalaryOfAgeSegment(int age) {
        Map<String, List<Employee>> groups = groupByAgeSegment();
        String ageSegment = calculateAgeSegment(age);
        List<Employee> employees = groups.get(ageSegment);


        return (employees != null ? employees : new ArrayList<Employee>())
                .stream()
                .mapToInt(employee -> employee.getSalary())
                .average()
                .orElse(0.0);
    }

}
