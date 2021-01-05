package com.examples.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.dao.CustomerRepository;
import com.examples.entity.Customer;
import com.examples.entity.Vehicle;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleService vehicleService;

    public Customer saveCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName(customer.getCustomerName());
        newCustomer.getVehicles()
                .addAll(customer
                        .getVehicles()
                        .stream()
                        .map(v -> {
                            Vehicle vv = vehicleService.findVehicleById(v.getVehicleId());
                            vv.getCustomers().add(newCustomer);
                            return vv;
                        }).collect(Collectors.toList()));
        return customerRepository.save(newCustomer);
    }
}
