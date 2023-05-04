package com.example.Infinityshop.repo;

import com.example.Infinityshop.Entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceProviderRepo extends JpaRepository<ServiceProvider, Integer> {
    List<ServiceProvider> findByServiceEnt(Integer serviceId);
}
