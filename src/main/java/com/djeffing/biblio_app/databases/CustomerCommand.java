package com.djeffing.biblio_app.databases;

import com.djeffing.biblio_app.dtos.CustomerDto;
import com.djeffing.biblio_app.services.interfaces.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CustomerCommand {
    final private CustomerService customerService;

    public CustomerCommand(CustomerService customerService) {
        this.customerService = customerService;
    }


    public void save(){
        customerService.deleteAll();
        CustomerDto customer1 = CustomerDto.builder()
                .name("Jean Dupont")
                .email("jean.dupont@example.com")
                .phoneNumber("+33 6 12 34 56 78")
                .build();

        CustomerDto customer2 = CustomerDto.builder()
                .name("Marie Martin")
                .email("marie.martin@example.com")
                .phoneNumber("+33 6 98 76 54 32")
                .build();

        CustomerDto customer3 = CustomerDto.builder()
                .name("Ali Ben")
                .email("ali.ben@example.com")
                .phoneNumber("+33 6 22 33 44 55")
                .build();

        CustomerDto customer4 = CustomerDto.builder()
                .name("Sophie Bernard")
                .email("sophie.bernard@example.com")
                .phoneNumber("+33 6 77 88 99 00")
                .build();

        CustomerDto customer5 = CustomerDto.builder()
                .name("David Moreau")
                .email("david.moreau@example.com")
                .phoneNumber("+33 6 11 22 33 44")
                .build();

        customerService.create(customer1);
        customerService.create(customer2);
        customerService.create(customer3);
        customerService.create(customer4);
        customerService.create(customer5);

    }
}
