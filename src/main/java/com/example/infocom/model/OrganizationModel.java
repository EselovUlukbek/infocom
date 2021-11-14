package com.example.infocom.model;

import com.example.infocom.entity.Organization;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class OrganizationModel {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static EntityTransaction transaction = entityManager.getTransaction();

    public void addOrganization(Organization organization){
        try{
            transaction.begin();

            Organization organization1 = new Organization();
            organization1.setId(organization.getId());
            organization1.setTypeOfOwnership(organization.getTypeOfOwnership());
            organization1.setLegalForm(organization.getLegalForm());
            organization1.setNameOfTheOrganization(organization.getNameOfTheOrganization());
            organization1.setFullnameOfTheHead(organization.getFullnameOfTheHead());
            organization1.setFax(organization.getFax());
            organization1.setPhone(organization.getPhone());
            organization1.setWebpage(organization.getWebpage());
            organization1.setLicenseNumber(organization.getLicenseNumber());
            organization1.setDateOfObtainingTheLicense(organization.getDateOfObtainingTheLicense());
            organization1.setCertificateNumber(organization.getCertificateNumber());
            organization1.setDateOfReceiptOfTheCertificate(organization.getDateOfReceiptOfTheCertificate());
            organization1.setAddress(organization.getAddress());
            organization1.setFilesToAttach(organization.getFilesToAttach());
            entityManager.persist(organization1);
            transaction.commit();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
        }
    }


    public void delete(Organization organization){
        transaction.begin();
        if(entityManager.contains(organization)){
            entityManager.remove(organization);
        }else {
            Organization organization1 = entityManager.find(Organization.class, organization.getId());
            if(organization1 != null){
                entityManager.remove(organization1);
            }
        }
        transaction.commit();
        entityManager.clear();
    }

    public List<Organization> getAll(){
        return entityManager.createQuery("SELECT c FROM Organization c", Organization.class)
                .getResultList();
    }

    public String updateById(long id, String typeOfOwnership, String legalForm, String nameOfTheOrganization,
                             String fullnameOfTheHead, String fax, String phone, String webpage, long licenseNumber,
                             String dateOfObtainingTheLicense, long certificateNumber, String dateOfReceiptOfTheCertificate,
                             String address, String fileToAttach){

        if(!transaction.isActive()){
            transaction.begin();
        }

        if(isId(id)){
            Query query = entityManager.createQuery("UPDATE Organization s SET s.typeOfOwnership = :typeOfOwnership," +
                    "s.legalForm = :legalForm, s.nameOfTheOrganization = :nameOfTheOrganization, s.fullnameOfTheHead = :fullnameOfTheHead," +
                    "s.fax = :fax, s.phone = :phone, s.webpage = :webpage, s.licenseNumber = :licenseNumber," +
                    " s.dateOfObtainingTheLicense = :dateOfObtainingTheLicense, s.certificateNumber = :certificateNumber, " +
                    "s.dateOfReceiptOfTheCertificate = :dateOfReceiptOfTheCertificate, s.address = :address, s.filesToAttach = :fileToAttach " +
                    "WHERE s.id = :id");

                query.setParameter("id", id);
                query.setParameter("typeOfOwnership", typeOfOwnership);
                query.setParameter("legalForm", legalForm);
                query.setParameter("nameOfTheOrganization", nameOfTheOrganization);
                query.setParameter("fullnameOfTheHead", fullnameOfTheHead);
                query.setParameter("fax", fax);
                query.setParameter("phone",phone);
                query.setParameter("dateOfObtainingTheLicense", dateOfObtainingTheLicense);
                query.setParameter("certificateNumber", certificateNumber);
                query.setParameter("address", address);
                query.setParameter("fileToAttach", fileToAttach);

                int updateCount = query.executeUpdate();
                if(updateCount > 0){
                    System.out.println("Record for id: " + id + " is updated");
            }

        }

        transaction.commit();
        return "update-organization.xhtml";

    }


    private static boolean isId(long organizationId){
        boolean idResult = false;

        Query query = entityManager.createQuery("SELECT s FROM Organization s WHERE s.id = :id");
        query.setParameter("id", organizationId);
        Organization organization = (Organization) query.getSingleResult();

        if(organization != null){
            idResult = true;
        }
        return idResult;
    }

}
