package com.supplychain.hierarchytool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tech.ailef.snapadmin.external.SnapAdminAutoConfiguration;

/**
 * Standalone host that wires the SnapAdmin starter against the shared
 * SupplyChain data model so we can customize the hierarchy UI independently.
 */
@SpringBootApplication
@ImportAutoConfiguration(SnapAdminAutoConfiguration.class)
public class HierarchyToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(HierarchyToolApplication.class, args);
	}

}

