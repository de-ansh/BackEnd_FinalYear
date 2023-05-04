package com.example.Infinityshop.service.impl;

import com.example.Infinityshop.Entity.ServiceEnt;
import com.example.Infinityshop.exception.ResourceNotFoundException;
import com.example.Infinityshop.payload.ServiceEntDto;
import com.example.Infinityshop.repo.ServiceEntRepo;
import com.example.Infinityshop.service.ServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceEntRepo serviceRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ServiceEntDto createService(ServiceEntDto serviceDto) {
        ServiceEnt service= this.modelMapper.map(serviceDto,ServiceEnt.class);
        ServiceEnt newService= this.serviceRepo.save(service);
        return this.modelMapper.map(newService, ServiceEntDto.class);
    }

    @Override
    public ServiceEntDto updateService(ServiceEntDto serviceDto, Integer serviceId) {
        ServiceEnt serviceEnt= this.serviceRepo.findById(serviceId).orElseThrow(()-> new ResourceNotFoundException("Service ", "service", serviceId));
        serviceEnt.setServiceName(serviceDto.getServiceName());
        serviceEnt.setDescription(serviceDto.getDescription());
        ServiceEnt newService= this.serviceRepo.save(serviceEnt);

        return this.modelMapper.map(newService,ServiceEntDto.class);
    }

    @Override
    public void deleteService(Integer serviceId) {
        ServiceEnt serviceEnt= this.serviceRepo.findById(serviceId).orElseThrow(()->new ResourceNotFoundException("Service", "serviceId",serviceId));
        this.serviceRepo.delete(serviceEnt);
    }

    @Override
    public ServiceEntDto getServuceById(Integer serviceId) {
        ServiceEnt serviceEnt= this.serviceRepo.findById(serviceId).orElseThrow(()->new ResourceNotFoundException("Service", "serviceId",serviceId));
        ServiceEntDto serviceEntDto= this.modelMapper.map(serviceEnt,ServiceEntDto.class);
        return serviceEntDto;
    }

    @Override
    public List<ServiceEntDto> getALlService() {
        List<ServiceEnt> serviceEntList= this.serviceRepo.findAll();
        List<ServiceEntDto> serviceEntDtos= serviceEntList.stream().map((serviceEnt) -> this.modelMapper.map(serviceEnt,ServiceEntDto.class)).collect(Collectors.toList());

        return serviceEntDtos;
    }
}
