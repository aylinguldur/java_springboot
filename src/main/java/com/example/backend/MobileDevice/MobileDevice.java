package com.example.backend.MobileDevice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class MobileDevice {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotEmpty
    private String brand ;

    @NotNull
    @NotEmpty
    private  String model;

    @NotNull
    @NotEmpty
    private String os;

    @NotNull
    @NotEmpty
    private String osVersion;
}
