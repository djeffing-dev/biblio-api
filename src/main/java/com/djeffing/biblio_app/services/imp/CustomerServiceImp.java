package com.djeffing.biblio_app.services.imp;

import com.djeffing.biblio_app.Models.Customer;
import com.djeffing.biblio_app.dtos.CustomerDto;
import com.djeffing.biblio_app.mappers.CustomerMapper;
import com.djeffing.biblio_app.repositories.CustomerRepository;
import com.djeffing.biblio_app.services.interfaces.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImp  implements CustomerService {

    final private  CustomerRepository customerRepository;
    final  private CustomerMapper customerMapper;

    public CustomerServiceImp(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    private  CustomerDto save(CustomerDto customerDto){
        Customer customer = customerMapper.toCustomer(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        return save(customerDto);
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDto> findById(long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        return customerOptional.map(customer -> CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build());
    }

    @Override
    public CustomerDto update(long customerId, CustomerDto customerDto) {
        Optional<CustomerDto> customerDtoOptional = findById(customerId);
        if(customerDtoOptional.isPresent()){
            CustomerDto newCustomerDto = customerDtoOptional.get();

            if(customerDto.getName()!=null){
                newCustomerDto.setName(customerDto.getName());
            }

            if(customerDto.getEmail()!=null){
                newCustomerDto.setEmail(customerDto.getEmail());
            }

            if(customerDto.getPhoneNumber()!=null){
                newCustomerDto.setPhoneNumber(customerDto.getPhoneNumber());
            }

            return save(newCustomerDto);
        }

        return null;
    }

    @Override
    public String deleteById(long customerId) {
        customerRepository.deleteById(customerId);
        return "Le client à été supprimer avec succes";
    }

    @Override
    public String deleteAll() {
        customerRepository.deleteAll();
        return "La liste des clients à été supprimer avec succès";
    }
}
