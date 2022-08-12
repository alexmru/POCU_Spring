package com.pocu.telecomm.repo;

import com.pocu.telecomm.entity.NetworkProvider;
import com.pocu.telecomm.entity.Plan;
import com.pocu.telecomm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
