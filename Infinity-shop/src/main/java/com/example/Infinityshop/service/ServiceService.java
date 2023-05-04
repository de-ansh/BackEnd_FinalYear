package com.example.Infinityshop.service;

import com.example.Infinityshop.payload.ServiceEntDto;
import com.example.Infinityshop.payload.ServiceEntDto;

import java.util.List;

public interface ServiceService {
    ServiceEntDto createService(ServiceEntDto serviceDto);
    ServiceEntDto updateService(ServiceEntDto serviceDto, Integer serviceId);

    void deleteService(Integer serviceId);

    ServiceEntDto getServuceById(Integer serviceId);
    List<ServiceEntDto> getALlService();
}
