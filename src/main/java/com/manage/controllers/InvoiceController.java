package com.manage.controllers;

import com.manage.dto.CustomerDto;
import com.manage.dto.InvoiceDto;
import com.manage.payloads.ApiResponse;
import com.manage.payloads.PageableResponse;
import com.manage.repositories.InvoiceItemsRepo;
import com.manage.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
@CrossOrigin(origins = "*")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private InvoiceItemsRepo invoiceItemsRepo;


    @PostMapping
    public ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDto) {
        return new ResponseEntity<>(invoiceService.createInvoice(invoiceDto), HttpStatus.CREATED);
    }

    @PutMapping("/{invoiceNumber}")
    public ResponseEntity<InvoiceDto> updateInvoice(@RequestBody InvoiceDto invoiceDto, @PathVariable(value = "invoiceNumber") int invoiceNumber) {
        System.out.println(invoiceDto);
        return new ResponseEntity<>(invoiceService.updateInvoice(invoiceNumber, invoiceDto), HttpStatus.OK);
    }

    @DeleteMapping("/{invoiceId}")
    public ResponseEntity<ApiResponse> deleteInvoice(@PathVariable String invoiceId) throws Exception {
        invoiceService.deleteInvoice(invoiceId);
        return new ResponseEntity<>(ApiResponse.builder().response("invoice deleted successfully").status(true).httpStatus(HttpStatus.ACCEPTED).build(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PageableResponse<InvoiceDto>> getAllInvoices(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
                                                                       @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                                       @RequestParam(value = "sortBy", defaultValue = "customerName", required = false) String sortBy,
                                                                       @RequestParam(value = "sortDirection", defaultValue = "0", required = false) String sortDirection) {
        return new ResponseEntity<>(invoiceService.getAllInvoices(pageNumber, pageSize, sortBy, sortDirection), HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<PageableResponse<InvoiceDto>> getInvoiceByCustomer(@PathVariable String customerId, @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
                                                                             @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                                             @RequestParam(value = "sortBy", defaultValue = "itemName", required = false) String sortBy,
                                                                             @RequestParam(value = "sortDirection", defaultValue = "0", required = false) String sortDirection) {
        return new ResponseEntity<>(invoiceService.getInvoiceByCustomer(pageNumber, pageSize, sortBy, sortDirection, customerId), HttpStatus.OK);
    }

    @GetMapping("/customer/{invoiceNumber}")
    public ResponseEntity<CustomerDto> getCustomerByInvoiceNumber(@PathVariable int invoiceNumber) {
        return new ResponseEntity<>(invoiceService.getCostumerByInvoice(invoiceNumber), HttpStatus.OK);
    }

    @DeleteMapping("/invoice-item/{invoiceItemId}")
    public ResponseEntity<ApiResponse> deleteInvoiceItems(@PathVariable String invoiceItemId) {
        invoiceService.deleteInvoiceItem(invoiceItemId);
        return new ResponseEntity<>(ApiResponse.builder().response("invoice item deleted successfully").status(true).httpStatus(HttpStatus.ACCEPTED).build(), HttpStatus.OK);
    }
}




