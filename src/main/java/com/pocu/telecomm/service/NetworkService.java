package com.pocu.telecomm.service;

import com.pocu.telecomm.entity.NetworkProvider;
import com.pocu.telecomm.repo.NetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkService {

    private final NetworkRepository networkRepository;

    @Autowired
    public NetworkService(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }


    public List<NetworkProvider> getNetworks()
    {
        return networkRepository.findAll();
    }
}
