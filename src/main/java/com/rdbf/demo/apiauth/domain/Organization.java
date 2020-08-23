package com.rdbf.demo.apiauth.domain;

public class Organization {
    private String orgId;
    private String orgName;
    private String peopleName;

    public Organization(String orgId,String orgName,String peopleName){
        this.orgId = orgId;
        this.orgName = orgName;
        this.peopleName = peopleName;
    }

    public String getOrgId() { return orgId; }
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() { return orgName; }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPeopleName() { return peopleName; }
    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }
}
