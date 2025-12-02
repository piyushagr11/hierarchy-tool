package com.supplychain.hierarchytool.model;

import jakarta.persistence.*;
import tech.ailef.snapadmin.external.annotations.DisplayName;

/**
 * VehicleType entity - category level.
 * Represents the type of vehicle (e.g., Car, Truck, Motorcycle).
 */
@Entity
@Table(name = "vehicle_type")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // Constructors
    public VehicleType() {
    }

    public VehicleType(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @DisplayName
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
