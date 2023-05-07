package com.example.Infinityshop.controller;

import com.example.Infinityshop.Entity.ServiceProvider;
import com.example.Infinityshop.payload.ServiceProviderDto;
import com.example.Infinityshop.response.ApiResponse;
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
    //GetAllProvider
    @GetMapping("providers/")
    public  ResponseEntity<List<ServiceProviderDto>> getProvider(){
        List<ServiceProviderDto> providerDtoList= this.serviceProviderService.GetALlServiceProvider();
        return new ResponseEntity<>(providerDtoList, HttpStatus.OK);
    }
    //getBYProviderId
    @GetMapping("providers/{serviceProviderId}")
    public  ResponseEntity<ServiceProviderDto> getByProviderId(@PathVariable Integer serviceProviderId){
        ServiceProviderDto serviceProviderDto= this.serviceProviderService.GetById(serviceProviderId);
        return new ResponseEntity<>(serviceProviderDto, HttpStatus.OK);
    }

    @GetMapping("service/{serviceId}/providers")
    public ResponseEntity<List<ServiceProviderDto>> GetServiceProvidersByServiceId( @PathVariable Integer serviceId){
        List<ServiceProviderDto> serviceProviderDtoList = this.serviceProviderService.getProviderByService(serviceId);
        return  new ResponseEntity<>(serviceProviderDtoList,HttpStatus.OK);
    }

    @PutMapping("providers/{serviceProviderId}")
    public  ResponseEntity<ServiceProviderDto> updateProviderId(@PathVariable Integer serviceProviderId, @RequestBody ServiceProviderDto serviceProviderDto){
        ServiceProviderDto serviceProviderDto1= this.serviceProviderService.updateServiceprovider(serviceProviderDto,serviceProviderId);
        return new ResponseEntity<>(serviceProviderDto1, HttpStatus.OK);
    }
    @DeleteMapping("providers/{serviceProviderId}")
    public ApiResponse deleteProvider(){
        return null;
    }

}
