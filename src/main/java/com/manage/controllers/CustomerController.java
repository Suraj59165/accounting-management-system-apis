package com.manage.controllers;

import com.manage.dto.CustomerDto;
import com.manage.payloads.ApiResponse;
import com.manage.payloads.PageableResponse;
import com.manage.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse> removeCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(ApiResponse.builder().response("customer deleted successfully").status(true).httpStatus(HttpStatus.ACCEPTED).build(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PageableResponse<CustomerDto>> getAllCustomer(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
                                                                        @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                                        @RequestParam(value = "sortBy", defaultValue = "name", required = false) String sortBy,
                                                                        @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection) {
        return new ResponseEntity<>(customerService.getAllCostumer(pageNumber, pageSize, sortBy, sortDirection), HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }


    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable String customerId, @Valid @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.updateCustomer(customerId, customerDto), HttpStatus.OK);
    }

}
