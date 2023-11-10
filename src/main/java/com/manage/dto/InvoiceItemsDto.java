package com.manage.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manage.entities.Invoice;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItemsDto {

    private String id;
    private String itemName;
    private long itemSalesPrice;
    private int itemQuantity;
    private int itemOffer;
    private int itemTax;
    private int itemFinalPrice;
    @JsonIgnore
    private InvoiceDto invoice;


}
