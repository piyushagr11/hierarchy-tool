package com.supplychain.hierarchytool.model;

import jakarta.persistence.*;
import tech.ailef.snapadmin.external.annotations.DisplayName;
import tech.ailef.snapadmin.external.annotations.SnapTree;
import java.util.Set;

/**
 * VehicleModel entity - top level of the hierarchy.
 * Represents a vehicle model that belongs to a brand.
 */
@Entity
@Table(name = "vehicle_model", uniqueConstraints = @UniqueConstraint(columnNames = { "name", "year", "brand_id",
        "variant" }))
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "vehicle_type_id", nullable = false)
    private VehicleType vehicleType;

    @Column(length = 100)
    private String variant;

    @Column(length = 500)
    private String description;

    @ManyToMany
    @JoinTable(name = "model_part_compatibility", joinColumns = @JoinColumn(name = "vehicle_model_id"), inverseJoinColumns = @JoinColumn(name = "auto_part_id"))
    @SnapTree(childLabel = "Compatible Parts", icon = "bi bi-gear")
    private Set<AutoPart> compatibleParts;

    // Constructors
    public VehicleModel() {
    }

    public VehicleModel(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DisplayName
    public String getDisplayName() {
        return name + (year != null ? " (" + year + ")" : "");
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<AutoPart> getCompatibleParts() {
        return compatibleParts;
    }

    public void setCompatibleParts(Set<AutoPart> compatibleParts) {
        this.compatibleParts = compatibleParts;
    }

    @Override
    public String toString() {
        return name + (year != null ? " " + year : "") +
                (variant != null ? " " + variant : "");
    }
}
