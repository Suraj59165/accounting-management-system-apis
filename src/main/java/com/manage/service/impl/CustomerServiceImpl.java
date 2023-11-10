package com.manage.service.impl;

import com.manage.dto.CustomerDto;
import com.manage.entities.Customer;
import com.manage.exception.ResourceNotFoundException;
import com.manage.helper.Helper;
import com.manage.payloads.PageableResponse;
import com.manage.repositories.CustomerRepo;
import com.manage.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        customerDto.setId(UUID.randomUUID().toString());
        return modelMapper.map(customerRepo.save(modelMapper.map(customerDto, Customer.class)), CustomerDto.class);
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerRepo.delete(customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + customerId)));


    }

    @Override
    public CustomerDto updateCustomer(String existingCustomerId, CustomerDto customerDto) {
        Customer customer = customerRepo.findById(existingCustomerId).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + existingCustomerId));
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        customer.setPhone(customerDto.getPhone());
        customer.setNotes(customerDto.getNotes());
        return modelMapper.map(customerRepo.save(customer), CustomerDto.class);
    }

    @Override
    public PageableResponse<CustomerDto> getAllCostumer(int pageNumber, int pageSize, String sortBy, String sortDirection) {
        return Helper.getPageableResponse(customerRepo.findAll(PageRequest.of(pageNumber, pageSize, sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending())), CustomerDto.class);

    }

    @Override
    public CustomerDto getCustomerById(String customerId) {
        return modelMapper.map(customerRepo.findById(customerId).get(), CustomerDto.class);
    }
}
