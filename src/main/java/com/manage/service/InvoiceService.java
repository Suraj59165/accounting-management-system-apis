package com.manage.service;

import com.manage.dto.CustomerDto;
import com.manage.dto.InvoiceDto;
import com.manage.payloads.PageableResponse;

public interface InvoiceService {
    InvoiceDto createInvoice(InvoiceDto invoiceDto);

    void deleteInvoice(String invoiceNumber) throws Exception;

    InvoiceDto updateInvoice(int invoiceNumber, InvoiceDto newInvoiceData);

    PageableResponse<InvoiceDto> getAllInvoices(int pageNumber, int pageSize, String sortBy, String sortDirection);

    PageableResponse<InvoiceDto> getInvoiceByCustomer(int pageNumber, int pageSize, String sortBy, String sortDirection, String customerId);

    CustomerDto getCostumerByInvoice(int invoiceNumber);

    void deleteInvoiceItem(String invoiceItemId);


}
