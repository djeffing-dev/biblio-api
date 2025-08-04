package com.djeffing.biblio_app.services.interfaces;

import com.djeffing.biblio_app.dtos.BookDto;
import com.djeffing.biblio_app.dtos.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerDto create(CustomerDto customerDto);
    List<CustomerDto> findAll();
    Optional<CustomerDto> findById(long customerId);
    CustomerDto update(long customerId, CustomerDto customerDto);

    String deleteById(long customerId);

    String deleteAll();
}
