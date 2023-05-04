package com.example.Infinityshop.service.impl;

import com.example.Infinityshop.Entity.ServiceEnt;
import com.example.Infinityshop.Entity.ServiceProvider;
import com.example.Infinityshop.exception.ResourceNotFoundException;
import com.example.Infinityshop.payload.ServiceProviderDto;
import com.example.Infinityshop.repo.ServiceEntRepo;
import com.example.Infinityshop.repo.ServiceProviderRepo;
import com.example.Infinityshop.service.ServiceProviderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    @Autowired
   private ServiceProviderRepo serviceProviderRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ServiceEntRepo serviceEntRepo;

    @Override

    public ServiceProviderDto createServiceProvider(ServiceProviderDto serviceProviderDto, Integer serviceENtId) {
        ServiceEnt serviceEnt= this.serviceEntRepo.findById(serviceENtId).orElseThrow(()-> new ResourceNotFoundException("Service","Service Id", serviceENtId));
        ServiceProvider serviceProvider=this.modelMapper.map(serviceProviderDto, ServiceProvider.class);
        serviceProvider.setServiceEnt(serviceEnt);
        ServiceProvider serviceProvider1= this.serviceProviderRepo.save(serviceProvider);
        return this.modelMapper.map(serviceProvider1, ServiceProviderDto.class);
    }

    @Override
    public ServiceProviderDto updateServiceprovider(ServiceProviderDto serviceProviderDto, Integer serviceProviderId) {
        return null;
    }

    @Override
    public ServiceProviderDto GetById(Integer serviceProviderId) {
        return null;
    }

    @Override
    public List<ServiceProviderDto> GetALlServiceProvider() {
        List<ServiceProvider> providers= this.serviceProviderRepo.findAll();
        List<ServiceProviderDto> providerDtos= providers.stream().map((serviceProvider) ->this.modelMapper.map(serviceProvider, ServiceProviderDto.class) ).collect(Collectors.toList());

        return providerDtos;
    }

    @Override
    public List<ServiceProviderDto> getProviderByService(Integer serviceId) {
        return null;
    }
}
