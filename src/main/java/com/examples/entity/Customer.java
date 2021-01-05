package com.examples.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
    private Long customerId;
	
	@Column(name="customer_name")
    private String customerName;
    @ManyToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private Collection<Vehicle> vehicles = new ArrayList<>();


    public Long getCustomerId() {
        return customerId;

    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
	
	
	

}
