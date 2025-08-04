package com.djeffing.biblio_app.mappers;

import com.djeffing.biblio_app.Models.Customer;
import com.djeffing.biblio_app.dtos.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toCustomerDto(Customer customer);
    Customer toCustomer(CustomerDto customerDto);

}
