package io.glitchtech.customer.controller;

import io.glitchtech.customer.domain.*;
import io.glitchtech.customer.dto.CustomerDTO;
import io.glitchtech.customer.mapper.CustomerMapper;
import io.glitchtech.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody @Valid CustomerDTO customerDTO) {

        Customer customer = CustomerMapper.mapToCustomer(customerDTO);
        Customer createdCustomer = customerService.create(customer);

        return ResponseEntity.ok(createdCustomer);
    }
}
