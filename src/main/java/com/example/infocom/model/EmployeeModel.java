package com.example.infocom.model;

import com.example.infocom.entity.Employee;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class EmployeeModel {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private static EntityManager  entityManager = entityManagerFactory.createEntityManager();
    private static EntityTransaction transaction = entityManager.getTransaction();



    public void addEmployee(Employee employee) {
        try {
            transaction.begin();

            Employee newEmployee = new Employee();
            newEmployee.setId(employee.getId());
            newEmployee.setFullName(employee.getFullName());
            newEmployee.setHomePhone(employee.getHomePhone());
            newEmployee.setWorkPhone(employee.getWorkPhone());
            newEmployee.setHomeAddress(employee.getHomeAddress());
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
//            entityManager.close();
//            entityManagerFactory.close();
        }

    }

    public void delete(Employee employee){
        transaction.begin();
        if(entityManager.contains(employee)){
            entityManager.remove(employee);
        }else {
            Employee employee1 =entityManager.find(Employee.class, employee.getId());
            if(employee1 != null){
                entityManager.remove(employee1);

            }
        }
        transaction.commit();
        entityManager.clear();

    }

    public String updateById(long id, String name, String homePhone, String phone, String homeAddress,
                             String email, long bankDetails, String position, String workPhone){

        if(!transaction.isActive()){
            transaction.begin();
        }

        if(isId(id)){
            Query query = entityManager.createQuery("UPDATE Employee s SET s.fullName = :fullName, s.homePhone = :homePhone," +
                    "s.phone = :phone, s.homeAddress = :homeAddress, s.email = :email, s.bankDetails = :bankDetails, s.position = :position," +
                    "s.workPhone = :workPhone WHERE s.id = :id");

                query.setParameter("id", id);
                query.setParameter("fullName", name);
                query.setParameter("homePhone", homePhone);
                query.setParameter("phone", phone);
                query.setParameter("homeAddress", homeAddress);
                query.setParameter("email", email);
                query.setParameter("bankDetails", bankDetails);
                query.setParameter("position", position);
                query.setParameter("workPhone", workPhone);

                int updateCount = query.executeUpdate();
                if(updateCount > 0){
                    System.out.println("Record for id: " + id + "is updated");
                }
        }
        transaction.commit();
        return "update.xhtml";
    }

    private static boolean isId(long employeeId){
        boolean idResult = false;

        Query query = entityManager.createQuery("SELECT s FROM Employee s WHERE s.id = :id");
        query.setParameter("id", employeeId);
        Employee employee = (Employee) query.getSingleResult();

        if(employee != null){
            idResult = true;
        }
        return idResult;
    }

    public List<Employee> getAll(){
        return entityManager.createQuery("SELECT c FROM Employee c", Employee.class)
                .getResultList();
    }


//    public void update(List<Employee> employees){
//        transaction.begin();                                                  // Eto ne zarabotalo, i mne prishlos6 podrugomu napistat6
//        employees.forEach(entityManager::merge);
//        transaction.commit();
//    }

//    public void update(EmployeeDto employeeDto){
//        Employee employee = new Employee();
//        transaction.begin();
//        Employee employee1  = entityManager.find(Employee.class, employee.getId());
//        employee1.toEntity(employeeDto);
//        employee1.setId(employee1.getId());
//        employee1.setFullName(employee1.getFullName());
//        employee1.setHomePhone(employee1.getHomePhone());
//        employee1.setWorkPhone(employee1.getWorkPhone());
//        employee1.setHomeAddress(employee1.getHomeAddress());
//        employee1.setPhone(employee1.getPhone());
//        employee1.setEmail(employee1.getEmail());
//        employee1.setBankDetails(employee1.getBankDetails());
//        employee1.setPosition(employee1.getPosition());
//        entityManager.merge(employee1);
//        transaction.commit();
//    }
}
