package com.manage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InvoiceDto {

    private String id;
    private int invoiceNumber;
    private Date createdAt;
    private String customerName;
    private List<InvoiceItemsDto> invoiceItems;
    private String customerId;


}
