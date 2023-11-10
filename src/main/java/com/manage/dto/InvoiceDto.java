package com.manage.dto;

import com.manage.entities.InvoiceItems;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private String id;
    private int invoiceNumber;
    private LocalDateTime createdAt;
    private String customerName;
    private List<InvoiceItemsDto> invoiceItems;
    private String customerId;



}
