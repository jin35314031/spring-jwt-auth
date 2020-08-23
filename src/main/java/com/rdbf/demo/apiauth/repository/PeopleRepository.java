package com.rdbf.demo.apiauth.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.rdbf.demo.apiauth.domain.People;

import java.util.List;


@Mapper
public interface PeopleRepository {
    @Select("SELECT people_id, login_id, password, org_id FROM peoples WHERE login_id = #{loginId}")
    People findByLoginId(String loginId);

    @Insert("INSERT INTO peoples(login_id,password) VALUES (#{loginId},#{password})")
    void createAccount(People people);

    @Select("SELECT people_id, login_id, password,org_id FROM peoples WHERE org_id = #{orgId}")
    List<People> findbyOrgnizationId(int orgId);
}
