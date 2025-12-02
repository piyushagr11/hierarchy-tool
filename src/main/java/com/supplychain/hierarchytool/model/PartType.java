package com.supplychain.hierarchytool.model;

import jakarta.persistence.*;
import tech.ailef.snapadmin.external.annotations.DisplayName;

/**
 * PartType entity - categorizes auto parts.
 * Examples: Filters, Brake System, Engine Parts, Suspension, Electrical
 */
@Entity
@Table(name = "part_type")
public class PartType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;

    // Constructors
    public PartType() {
    }

    public PartType(String name) {
        this.name = name;
    }

    public PartType(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return name;
    }
}
