package com.example.infocom.model;

import com.example.infocom.entity.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Stateless
public class EmployeeModel {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();


    public void addEmployee(Employee employee) {
        try {
            transaction.begin();

            Employee newEmployee = new Employee();
            newEmployee.setId(employee.getId());
            newEmployee.setFullName(employee.getFullName());
            newEmployee.setHomePhone(employee.getHomePhone());
            newEmployee.setWorkPhone(employee.getWorkPhone());
            newEmployee.setPhone(employee.getPhone());
            newEmployee.setEmail(employee.getEmail());
            newEmployee.setBankDetails(employee.getBankDetails());
            newEmployee.setPosition(employee.getPosition());
            entityManager.persist(newEmployee);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    public void delete(Employee employee){
        if(entityManager.contains(employee)){
            entityManager.remove(employee);
        }else {
            Employee employee1 =entityManager.find(Employee.class, employee.getId());
            if(employee1 != null){
                entityManager.remove(employee1);
            }
        }
    }

    public List<Employee> getAll(){
        return entityManager.createQuery("SELECT c FROM Employee c", Employee.class)
                .getResultList();
    }

    public void update (List<Employee> employees){
        employees.forEach(entityManager::merge);
    }
}
