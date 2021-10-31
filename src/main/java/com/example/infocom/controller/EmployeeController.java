package com.example.infocom.controller;

import com.example.infocom.entity.Employee;
import com.example.infocom.model.EmployeeModel;

import javax.annotation.PostConstruct;;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class EmployeeController {
    private List<Employee> employees;
    private Employee employee = new Employee();

    @Inject
    private EmployeeModel employeeModel;

    @PostConstruct
    public void getAll(){
        employees = employeeModel.getAll();
    }

    public void delete(Employee employee){
        employeeModel.delete(employee);
        employees.remove(employee);
    }

    public void add(){
        employeeModel.addEmployee(employee);
        employees = employeeModel.getAll();
        employee = new Employee();
    }

    public void update(){
        employeeModel.update(employees);
    }




    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

}
