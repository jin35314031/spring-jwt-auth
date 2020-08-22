package com.rdbf.demo.apiauth.repository;

import com.rdbf.demo.apiauth.domain.Plan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.rdbf.demo.apiauth.domain.People;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PlanRepository {
    @Select("SELECT title, start_date, end_date, place, body, label FROM plans WHERE login_id= #{loginId}")
    People findByLoginId(String loginId);

    @Insert("INSERT INTO plans(title,start_date,end_date,place,label,body) VALUES (#{title},#{start_date},#{end_date},#{place},${label},${body})")
    void createPlan(Plan plan);

    @Select("SELECT plan_id,login_id,title, start_date, end_date, label,body,private,place FROM plans WHERE login_id = #{loginId}")
    List<Plan> findAllOwnPlan(String loginId);

//    @Select("SELECT plans.plan_id,plans.login_id,plans.title, plans.start_date, plans.end_date, plans.label,plans.body,plans.private,plans.place"+
//            "FROM plans" +
//            "WHERE plans.login_id in (" +
//                "SELECT peoples.login_id" +
//                "FROM peoples" +
//                "WHERE peoples.org_id = ("+
//                    "SELECT peoples.org_id" +
//                    "FROM peoples" +
//                    "WHERE peoples.login_id = #{loginId}))")
//    List<Plan> findAllOwnOrganization(String loginId);

//    @Select("SELECT plans.plan_id,plans.login_id,plans.title, plans.start_date, plans.end_date, plans.label,plans.body,plans.private,plans.place\n" +
//            "FROM plans" +
//            "INNER JOIN peoples ON plans.login_id = peoples.login_id" +
//            "WHERE peoples.org_id = (SELECT peoples.org_id from peoples WHERE peoples.login_id = 'test')")
//    List<Plan> findAllOwnOrganization(String loginId);

    @Select("SELECT plans.plan_id,plans.login_id,plans.title, plans.start_date, plans.end_date, plans.label,plans.body,plans.private,plans.place FROM plans WHERE login_id IN (#{loginIdList})")
    List<Plan> findByLoginIdList(String loginIdList);
}
