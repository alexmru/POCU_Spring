package com.pocu.telecomm.controller;


import com.pocu.telecomm.entity.NetworkProvider;
import com.pocu.telecomm.entity.Plan;
import com.pocu.telecomm.entity.User;
import com.pocu.telecomm.repo.NetworkRepository;
import com.pocu.telecomm.repo.PlanRepository;
import com.pocu.telecomm.repo.UserRepository;
import com.pocu.telecomm.service.PlanService;
import com.pocu.telecomm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/controllers")
public class PlanController {
    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }




    @GetMapping
    public List<Plan> getPlans(){
        return planService.getPlans();
    }

    @PutMapping("/{planId}/network/{networkId}")
    Plan choosePlanProvider(
                @PathVariable Long planId,
                @PathVariable Long networkId
    ){
         return planService.chooseProvider(planId, networkId);

    }

    @PostMapping(path = "/add")
    public void postUser(@RequestBody Plan plan) {
        planService.postPlan(plan);
    }

    @PutMapping("/{planId}/users/{userId}")
    Plan SubscribeToPlan(
            @PathVariable Long planId,
            @PathVariable Long userId
    ){
        return planService.SubscribeUser(planId, userId);

    }

}
