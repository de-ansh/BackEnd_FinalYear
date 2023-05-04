package com.example.Infinityshop.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ServiceEntDto {
    private Integer serviceId;
    private String serviceName;
    private String description;
}
