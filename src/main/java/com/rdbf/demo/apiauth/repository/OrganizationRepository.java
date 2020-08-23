package com.rdbf.demo.apiauth.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.rdbf.demo.apiauth.domain.People;


@Mapper
public interface OrganizationRepository {
    @Select("SELECT org_id, org_name, people_name FROM organizations WHERE org_id = #{org_Id}")
    People findByLoginId(String loginId);

    @Insert("INSERT INTO organizations(org_name) VALUES (#{orgName},#{password})")
    void createAccount(People people);
}