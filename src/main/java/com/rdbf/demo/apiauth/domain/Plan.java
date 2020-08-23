package com.rdbf.demo.apiauth.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Plan {

    private Integer planId;
    private String loginId;
    private String title;
   // @JsonFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss.SSSZ")
    private Date startDate;
   // @JsonFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss.SSSZ")
    private Date endDate;
    private String label;
    private String body;
    private Boolean share;
    private String place;

    public Plan(Integer planId, String loginId, String title, Date startDate, Date endDate, String label, String body, Boolean share, String place) {

        this.planId = planId;
        this.loginId = loginId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.label = label;
        this.body = body;
        this.share = share;
    }

    public Plan(String loginId, String title, Date startDate, Date endDate, String label, String body, Boolean share, String place) {
        this.loginId = loginId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.label = label;
        this.body = body;
        this.share = share;
        this.place = place;
    }

    public Plan() {
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getShare() {
        return share;
    }

    public void setShare(Boolean share) {
        this.share = share;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
