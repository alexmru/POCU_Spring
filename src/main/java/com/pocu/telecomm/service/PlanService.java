package com.pocu.telecomm.service;

import com.pocu.telecomm.entity.NetworkProvider;
import com.pocu.telecomm.entity.Plan;
import com.pocu.telecomm.entity.User;
import com.pocu.telecomm.repo.NetworkRepository;
import com.pocu.telecomm.repo.PlanRepository;
import com.pocu.telecomm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;

    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    NetworkRepository networkRepository;



    public List<Plan> getPlans()
    {

        return planRepository.findAll();
    }

    public Plan findId(@PathVariable Long planId) {
        return planRepository.findById(planId).get();

    }
    public Plan save(Plan plan)
    {
        planRepository.save(plan);
        return plan;
    }


    public Plan chooseProvider(Long planId, Long networkId) {
        Plan plan = planRepository.findById(planId).get();
        NetworkProvider network = networkRepository.findById(networkId).get();
        plan.chooseNetwork(network);
        return planRepository.save(plan);
    }

    public void postPlan(final Plan plan) {
        planRepository.save(plan);
    }
    public Plan SubscribeUser(Long planId, Long userId) {
        Plan plan = planRepository.findById(planId).get();
        User user = userRepository.findById(userId).get();
        plan.subscribeUser(user);
        return planRepository.save(plan);
    }
}
