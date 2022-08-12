package com.pocu.telecomm.controller;


import com.pocu.telecomm.entity.NetworkProvider;
import com.pocu.telecomm.entity.Plan;
import com.pocu.telecomm.service.NetworkService;
import com.pocu.telecomm.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/plans")
public class NetworkController {
    private final NetworkService networkService;

    @Autowired
    public NetworkController(NetworkService networkService) {
        this.networkService = networkService;
    }

    @GetMapping
    public List<NetworkProvider> getNetworks(){
        return networkService.getNetworks();
    }
}
