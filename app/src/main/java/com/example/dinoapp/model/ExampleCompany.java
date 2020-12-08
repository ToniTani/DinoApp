package com.example.dinoapp.model;

public class ExampleCompany {

    private String businessId;
    private String name;
    private String companyForm;

    public ExampleCompany(String businessId, String name, String companyForm) {
        this.businessId = businessId;
        this.name = name;
        this.companyForm = companyForm;
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
}
