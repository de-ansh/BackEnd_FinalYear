package com.example.Infinityshop.service;

import com.example.Infinityshop.payload.ServiceProviderDto;

import java.util.List;

public interface ServiceProviderService {
    //Create post
    ServiceProviderDto createServiceProvider(ServiceProviderDto serviceProviderDto, Integer serviceENtId);

    //update
    ServiceProviderDto updateServiceprovider(ServiceProviderDto serviceProviderDto, Integer serviceProviderId);

    ServiceProviderDto GetById(Integer serviceProviderId);

    List<ServiceProviderDto> GetALlServiceProvider();

    List<ServiceProviderDto> getProviderByService(Integer serviceId);


}
