package com.example.Infinityshop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "ServiceProvider")
@Getter
@Setter
@NoArgsConstructor
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceProviderId;
    @Column(name = "ServiceProviderName", nullable = false, length = 100)
    private String providerName;
    @Column(name = "ServiceProviderEmail", nullable = false, length = 150)
    private String email;
    @Column(name = "ServiceProviderphone", nullable = false, length = 10)
    private String phone;
    @Column( nullable = false, length = 100)
    private String address;
    @Column( nullable = false, length = 12)
    private String idProofNum;


    @JsonIgnoreProperties(value = "serviceProvider")
    @ManyToOne
    @JoinColumn(name = "serviceId")
    private ServiceEnt serviceEnt;

}
