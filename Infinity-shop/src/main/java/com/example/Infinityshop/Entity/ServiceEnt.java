package com.example.Infinityshop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service")
@Getter
@Setter
@NoArgsConstructor
public class ServiceEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;
    @Column(name = "serviceName", nullable = false, length = 100)
    private String serviceName;
    @Column(name = "serviceDiscription", nullable = false, length = 500)
    private String description;

    @JsonIgnoreProperties(value = "service")

    @OneToMany(mappedBy = "serviceEnt" )
    private List<ServiceProvider> Providers= new ArrayList<>();

}
