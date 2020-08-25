package com.rdbf.demo.apiauth.service;

import com.rdbf.demo.apiauth.domain.People;
import com.rdbf.demo.apiauth.domain.Plan;
import com.rdbf.demo.apiauth.repository.PeopleRepository;
import com.rdbf.demo.apiauth.repository.PlanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {

        private static final Logger LOGGER = LoggerFactory.getLogger(PlanService.class);
        private final PlanRepository planRepository;
        private final PeopleRepository peopleRepository;


        @Autowired
        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        public PlanService(PlanRepository planRepository,PeopleRepository peopleRepository) {
            this.planRepository = planRepository;
            this.peopleRepository = peopleRepository;
        }

        public People getUser(String loginId) {
            return planRepository.findByLoginId(loginId);
        }

        public List<Plan> findOrgPlan(int orgId){
            List<People> memberList =  peopleRepository.findbyOrgnizationId(orgId);
            ArrayList<Plan> orgPlanList = new ArrayList<Plan>();
            for(People peopleTemp : memberList){
                orgPlanList.addAll(planRepository.findAllOwnPlan(peopleTemp.getLoginId()));
            }
            return orgPlanList;
        }
}


