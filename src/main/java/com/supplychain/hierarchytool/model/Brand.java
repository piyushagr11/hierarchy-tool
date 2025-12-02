package com.supplychain.hierarchytool.model;

import jakarta.persistence.*;
import tech.ailef.snapadmin.external.annotations.DisplayName;
import tech.ailef.snapadmin.external.annotations.SnapTree;
import java.util.Set;

/**
 * Brand entity - middle level of the hierarchy.
 * Represents a brand.
 */
@Entity
@Table(name = "brand")
@SnapTree(root = true, label = "Vehicle Hierarchy", icon = "bi bi-building")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;

    @OneToMany(mappedBy = "brand")
    @SnapTree(childLabel = "Models", icon = "bi bi-car")
    private Set<VehicleModel> vehicleModels;

    // Constructors
    public Brand() {
    }

    public Brand(String name) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<VehicleModel> getVehicleModels() {
        return vehicleModels;
    }

    public void setVehicleModels(Set<VehicleModel> vehicleModels) {
        this.vehicleModels = vehicleModels;
    }

    @Override
    public String toString() {
        return name;
    }
}
