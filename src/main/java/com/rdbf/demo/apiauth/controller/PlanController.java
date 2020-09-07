package com.rdbf.demo.apiauth.controller;


import com.rdbf.demo.apiauth.domain.Plan;
import com.rdbf.demo.apiauth.repository.PlanRepository;
import com.rdbf.demo.apiauth.service.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanController {

    private final PlanRepository planRepository;
    private final PlanService planService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PlanController.class);

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    PlanController(PlanRepository planRepository,PlanService planService){
        this.planRepository = planRepository;
        this.planService = planService;
    }

    @GetMapping("/plan")
    List<Plan> allOwnPlan() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        return planRepository.findAllOwnPlan(principal.toString());
    }

    @PostMapping("/org-plan/{orgId}")
    List<Plan> allOrgPlan(@PathVariable int orgId)  {
        return planService.findOrgPlan(orgId);
    }

    @PostMapping("/plan")
    void newPlan(@RequestBody Plan newPlan) {
        planRepository.createPlan(newPlan);
    }

    @PostMapping("/del-plan")
    void deletePlan(@RequestBody Plan deleteTargetPlan) {
        planRepository.deletePlan(deleteTargetPlan);
    }

    @PostMapping("/update-plan")
    void updatePlan(@RequestBody Plan updateTargetPlan){
        //LOGGER.info("updateTargetPlan::::::::::::::::::::::::::" + updateTargetPlan);
        planRepository.updatePlan(updateTargetPlan);
    }
}
