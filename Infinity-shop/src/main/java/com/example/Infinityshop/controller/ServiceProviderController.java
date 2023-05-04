package com.example.Infinityshop.controller;

import com.example.Infinityshop.Entity.ServiceProvider;
import com.example.Infinityshop.payload.ServiceProviderDto;
import com.example.Infinityshop.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ServiceProviderController {
    @Autowired
    private ServiceProviderService serviceProviderService;

    @PostMapping("service/{serviceEntId}/serviceProvider")
    public ResponseEntity<ServiceProviderDto> saveprovider(@RequestBody ServiceProviderDto serviceProviderDto, @PathVariable Integer serviceEntId){

        ServiceProviderDto serviceProviderDto1= this.serviceProviderService.createServiceProvider(serviceProviderDto, serviceEntId);

        return new ResponseEntity<ServiceProviderDto>(serviceProviderDto1,HttpStatus.CREATED);
    }
    @GetMapping("providers/")
    public  ResponseEntity<List<ServiceProviderDto>> getProvider(){
        List<ServiceProviderDto> providerDtoList= this.serviceProviderService.GetALlServiceProvider();
        return new ResponseEntity<>(providerDtoList, HttpStatus.OK);
    }
}
