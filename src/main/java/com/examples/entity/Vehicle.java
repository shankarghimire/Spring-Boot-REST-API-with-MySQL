package com.examples.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Vehicle")
@Table(name="vehicle")
public class Vehicle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vehicle_id")
    private Long vehicleId;
	
	@Column(name="vehicle_name")
    private String vehicleName;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_vehicle",
            joinColumns = @JoinColumn (name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    @JsonIgnore
    private Collection<Customer> customers = new ArrayList<>();

    public Long getVehicleId() {

        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

}
