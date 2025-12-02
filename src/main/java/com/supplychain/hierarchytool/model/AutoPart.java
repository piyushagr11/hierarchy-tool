package com.supplychain.hierarchytool.model;

import jakarta.persistence.*;
import tech.ailef.snapadmin.external.annotations.DisplayName;
import java.util.Set;

/**
 * AutoPart entity - represents individual auto parts.
 */
@Entity
@Table(name = "auto_part")
public class AutoPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String partNumber;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "part_type_id", nullable = false)
    private PartType partType;

    @Column(length = 100)
    private String manufacturer;

    @ManyToMany
    @JoinTable(name = "model_part_compatibility", joinColumns = @JoinColumn(name = "auto_part_id"), inverseJoinColumns = @JoinColumn(name = "vehicle_model_id"))
    private Set<VehicleModel> compatibleModels;

    // Constructors
    public AutoPart() {
    }

    public AutoPart(String partNumber, String name, PartType partType) {
        this.partNumber = partNumber;
        this.name = name;
        this.partType = partType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getName() {
        return name;
    }

    @DisplayName
    public String getFullName() {
        return name + " (" + partNumber + ")";
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

    public PartType getPartType() {
        return partType;
    }

    public void setPartType(PartType partType) {
        this.partType = partType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<VehicleModel> getCompatibleModels() {
        return compatibleModels;
    }

    public void setCompatibleModels(Set<VehicleModel> compatibleModels) {
        this.compatibleModels = compatibleModels;
    }

    @Override
    public String toString() {
        return name + " (" + partNumber + ")";
    }
}
