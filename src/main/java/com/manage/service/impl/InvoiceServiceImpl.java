package com.manage.service.impl;

import com.manage.dto.CustomerDto;
import com.manage.dto.InvoiceDto;
import com.manage.dto.InvoiceItemsDto;
import com.manage.entities.Invoice;
import com.manage.entities.InvoiceItems;
import com.manage.exception.ResourceNotFoundException;
import com.manage.helper.Helper;
import com.manage.payloads.PageableResponse;
import com.manage.repositories.CustomerRepo;
import com.manage.repositories.InvoiceItemsRepo;
import com.manage.repositories.InvoiceRepo;
import com.manage.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private InvoiceItemsRepo invoiceItemsRepo;


    @Override
    public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);
        invoice.setId(UUID.randomUUID().toString());
        if (invoiceDto.getInvoiceItems() != null) {
            for (InvoiceItems invoiceItems : invoice.getInvoiceItems()) {
                invoiceItems.setId(UUID.randomUUID().toString());
                invoiceItems.setInvoice(invoice);
            }
        }
        return modelMapper.map(invoiceRepo.save(invoice), InvoiceDto.class);
    }

    @Modifying
    @Override
    public void deleteInvoice(String invoiceId) throws Exception {

        Invoice invoice = invoiceRepo.findById(invoiceId).get();
        if (invoice != null) {
            for (InvoiceItems invoiceItems1 : invoice.getInvoiceItems()) {
                invoiceItems1.setInvoice(null);
            }
            invoiceRepo.delete(invoice);
        } else {
            throw new Exception("invoice not found");
        }
    }


    @Override
    public InvoiceDto updateInvoice(int invoiceNumber, InvoiceDto newInvoiceData) {
        Invoice invoice = invoiceRepo.getInvoiceByInvoiceNumber(invoiceNumber).orElse(null);

        if (invoice != null) {
            invoice.setInvoiceNumber(newInvoiceData.getInvoiceNumber());
            invoice.setCreatedAt(newInvoiceData.getCreatedAt());
            invoice.setCustomerName(newInvoiceData.getCustomerName());
            invoice.setCustomerId(newInvoiceData.getCustomerId());
            invoiceRepo.save(invoice);

            List<InvoiceItems> oldInvoiceItemsList = invoice.getInvoiceItems();
            List<InvoiceItemsDto> newInvoiceItemsList = newInvoiceData.getInvoiceItems();


            for (int i = 0; i < oldInvoiceItemsList.size(); i++) {
                InvoiceItems oldInvoiceItems = oldInvoiceItemsList.get(i);
                InvoiceItemsDto newInvoiceItems = newInvoiceItemsList.get(i);
                oldInvoiceItems.setItemName(newInvoiceItems.getItemName());
                oldInvoiceItems.setItemOffer(newInvoiceItems.getItemOffer());
                oldInvoiceItems.setItemQuantity(newInvoiceItems.getItemQuantity());
                oldInvoiceItems.setItemTax(newInvoiceItems.getItemTax());
                oldInvoiceItems.setItemSalesPrice(newInvoiceItems.getItemSalesPrice());
                oldInvoiceItems.setItemSalesPrice(newInvoiceItems.getItemSalesPrice());
                oldInvoiceItems.setItemFinalPrice(newInvoiceItems.getItemFinalPrice());
                invoiceItemsRepo.save(oldInvoiceItems);

            }

            return modelMapper.map(invoice, InvoiceDto.class);
        }

        return null; // Handle the case where the invoice is not found
    }


    @Override
    public PageableResponse<InvoiceDto> getAllInvoices(int pageNumber, int pageSize, String sortBy, String sortDirection) {
        return Helper.getPageableResponse(invoiceRepo.findAll(PageRequest.of(pageNumber, pageSize, sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending())), InvoiceDto.class);

    }

    @Override
    public PageableResponse<InvoiceDto> getInvoiceByCustomer(int pageNumber, int pageSize, String sortBy, String sortDirection, String customerId) {
        return Helper.getPageableResponse(invoiceRepo.getInvoiceByCustomerId(customerId, PageRequest.of(pageNumber, pageSize, sortDirection.equalsIgnoreCase(sortBy) ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending())), InvoiceDto.class);
    }

    @Override
    public CustomerDto getCostumerByInvoice(int invoiceNumber) {
        return modelMapper.map(customerRepo.findById(invoiceRepo.getInvoiceByInvoiceNumber(invoiceNumber).orElseThrow(() -> new ResourceNotFoundException("oops invoice not found with " + invoiceNumber)).getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("customer either doesn't exists or deleted ")), CustomerDto.class);
    }


    @Override
    public void deleteInvoiceItem(String invoiceItemId) {

        if (invoiceItemsRepo.existsById(invoiceItemId)) {
            System.out.println("exists");
            invoiceItemsRepo.deleteInvoiceItems(invoiceItemId);
        } else {
            throw new ResourceNotFoundException("Item doesn't exist");
        }
    }

}
