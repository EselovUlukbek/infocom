//package com.example.infocom.mapper;
//
//import com.example.infocom.dto.EmployeeDto;
//import com.example.infocom.entity.Employee;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmployeeMapper implements BaseMapper<Employee, EmployeeDto>{
//    @Override
//    public Employee toEntity(EmployeeDto employeeDto) {
//
//        Employee employee = new Employee();
//        employee.setId(employeeDto.getId());
//        employee.setFullName(employeeDto.getFullName());
//        employee.setHomePhone(employeeDto.getHomePhone());
//        employee.setPhone(employeeDto.getPhone());
//        employee.setWorkPhone(employee.getWorkPhone());
//        employee.setHomeAddress(employeeDto.getHomeAddress());
//        employee.setEmail(employeeDto.getEmail());
//        employee.setBankDetails(employeeDto.getBankDetails());
//        employee.setPosition(employeeDto.getPosition());
//        return employee;
//    }
//
//    @Override
//    public EmployeeDto toDto(Employee employee) {
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setId(employee.getId());
//        employeeDto.setFullName(employee.getFullName());
//        employeeDto.setHomePhone(employee.getHomePhone());
//        employeeDto.setPhone(employee.getPhone());
//        employeeDto.setWorkPhone(employee.getWorkPhone());
//        employeeDto.setHomeAddress(employee.getHomeAddress());
//        employeeDto.setEmail(employee.getEmail());
//        employeeDto.setBankDetails(employee.getBankDetails());
//        employeeDto.setPosition(employee.getPosition());
//        return employeeDto;
//    }
//
//    @Override
//    public List<Employee> toEntityList(List<EmployeeDto> employeeDtos) {
//
//        List<Employee> employees = new ArrayList<>();
//
//        for(EmployeeDto employeeDto : employeeDtos){
//            employees.add(toEntity(employeeDto));
//        }
//
//        return employees;
//    }
//
//    @Override
//    public List<EmployeeDto> toDtoList(List<Employee> employees) {
//
//        List<EmployeeDto> employeeDtoList = new ArrayList<>();
//
//        for(Employee employee : employees){
//            employeeDtoList.add(toDto(employee));
//        }
//
//        return employeeDtoList;
//    }
//}
