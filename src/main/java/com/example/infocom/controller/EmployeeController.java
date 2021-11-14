package com.example.infocom.controller;

import com.example.infocom.entity.Employee;
import com.example.infocom.model.EmployeeModel;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class EmployeeController implements Serializable {

    private List<Employee> employees = new ArrayList<>();
    private Employee employee = new Employee();

    @Inject
    transient private EmployeeModel employeeModel;

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

    public String add(Employee employee){
        this.employee = employee;
        return "add";
    }

//    public void update(){
//        employeeModel.update(employees);
//    }

    public String update(Employee employee){
       this.employee = employee;
       return "update";
    }

    public void update(){
        employeeModel.updateById(employee.getId(),employee.getFullName(), employee.getHomePhone(), employee.getPhone()
        ,employee.getHomeAddress(),employee.getEmail(),employee.getBankDetails(),employee.getPosition(),employee.getWorkPhone());
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
