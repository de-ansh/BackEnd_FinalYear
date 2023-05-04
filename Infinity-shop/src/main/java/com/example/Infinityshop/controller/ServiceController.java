package com.example.Infinityshop.controller;

import com.example.Infinityshop.payload.ServiceEntDto;
import com.example.Infinityshop.payload.UserDto;
import com.example.Infinityshop.response.ApiResponse;
import com.example.Infinityshop.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;


    @PostMapping("/")
    public ResponseEntity<ServiceEntDto> createService(@RequestBody ServiceEntDto serviceEntDto){
        ServiceEntDto create= this.serviceService.createService(serviceEntDto);
        return  new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<ServiceEntDto> updateService(@PathVariable Integer serviceId, @RequestBody ServiceEntDto serviceEntDto){
        ServiceEntDto update= this.serviceService.updateService(serviceEntDto,serviceId);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<ApiResponse> deleteuser(@PathVariable Integer serviceId){
        this.serviceService.deleteService(serviceId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Service deleted Succesfully", true), HttpStatus.OK);
    }

    @GetMapping("/")
    public  ResponseEntity<List<ServiceEntDto>> getAllService(){
        return ResponseEntity.ok(this.serviceService.getALlService());
    }
    @GetMapping("/{serviceId}")
    public  ResponseEntity<ServiceEntDto> getAllService(@PathVariable Integer serviceId){
        return ResponseEntity.ok(this.serviceService.getServuceById(serviceId));
    }
}
