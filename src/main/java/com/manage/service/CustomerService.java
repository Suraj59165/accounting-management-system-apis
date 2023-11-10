package com.manage.service;

import com.manage.dto.CustomerDto;
import com.manage.payloads.PageableResponse;


public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    void deleteCustomer(String customerId);

    CustomerDto updateCustomer(String existingCustomerId, CustomerDto customerDto);

    PageableResponse<CustomerDto> getAllCostumer(int pageNumber, int pageSize, String sortBy, String sortDirection);

    CustomerDto getCustomerById(String customerId);
}
