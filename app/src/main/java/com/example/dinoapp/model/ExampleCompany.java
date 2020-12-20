package com.example.dinoapp.model;

public class ExampleCompany {

    private String businessId;
    private String name;
    private String companyForm;
    private String registrationDate;
    private boolean expanded;


    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public ExampleCompany(String businessId, String name, String companyForm, String registrationDate) {
        this.businessId = businessId;
        this.name = name;
        this.companyForm = companyForm;
        this.registrationDate = registrationDate;
        this.expanded = false;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyForm() {
        return companyForm;
    }

    public void setCompanyForm(String companyForm) {
        this.companyForm = companyForm;
    }
    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
