package com.example.Infinityshop.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceProviderDto {
    private Integer serviceProviderId;
    private String providerName;
    private String email;
    private String phone;
    private String address;
    private String idProofNum;
    private ServiceEntDto service;
}
