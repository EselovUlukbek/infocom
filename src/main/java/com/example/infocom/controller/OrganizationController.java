package com.example.infocom.controller;

import com.example.infocom.entity.Organization;
import com.example.infocom.model.OrganizationModel;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class OrganizationController implements Serializable {

    private List<Organization> organizations;
    private Organization organization = new Organization();

    @Inject
    transient private OrganizationModel organizationModel;

    @PostConstruct
    public void getAll(){
        organizations = organizationModel.getAll();
    }

    public void delete(Organization organization){
        organizationModel.delete(organization);
        organizations.remove(organization);
    }

    public void add(){
        organizationModel.addOrganization(organization);
        organizations = organizationModel.getAll();
        organization = new Organization();

    }

    public String add(Organization organization){
        this.organization = organization;
        return "add";
    }

    public void update(){
        organizationModel.updateById(organization.getId(),organization.getTypeOfOwnership(),organization.getLegalForm(),
                organization.getNameOfTheOrganization(), organization.getFullnameOfTheHead(), organization.getFax(),
                organization.getPhone(),organization.getWebpage(), organization.getLicenseNumber(), organization.getDateOfObtainingTheLicense(),
                organization.getCertificateNumber(),organization.getDateOfReceiptOfTheCertificate(),organization.getAddress(), organization.getFilesToAttach());
    }

    public String update(Organization organization){
        this.organization = organization;
        return "update";
    }


    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public OrganizationModel getOrganizationModel() {
        return organizationModel;
    }

    public void setOrganizationModel(OrganizationModel organizationModel) {
        this.organizationModel = organizationModel;
    }
}
