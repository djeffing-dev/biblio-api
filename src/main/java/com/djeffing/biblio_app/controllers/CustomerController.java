package com.djeffing.biblio_app.controllers;

import com.djeffing.biblio_app.dtos.CustomerDto;
import com.djeffing.biblio_app.services.interfaces.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    final private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDto create(@RequestBody  CustomerDto customerDto){
        return customerService.create(customerDto);
    }

    @GetMapping
    public List<CustomerDto> findAll(){
        return customerService.findAll();
    }

    @PutMapping("/update")
    public  CustomerDto update(@RequestParam long id, @RequestBody CustomerDto customerDto){
        return customerService.update(id, customerDto);
    }

    @GetMapping("/findById")
    public Optional<CustomerDto> findById(@RequestParam  long id){
        return customerService.findById(id);
    }

    @DeleteMapping
    public String deleteById(long id){
        return customerService.deleteById(id);
    }



}
