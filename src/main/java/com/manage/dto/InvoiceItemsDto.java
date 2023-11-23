package com.manage.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItemsDto {

    private String id;
    private String itemName;
    private BigDecimal itemSalesPrice;
    private BigDecimal itemQuantity;
    private BigDecimal itemOffer;
    private BigDecimal itemTax;
    private BigDecimal itemFinalPrice;
    @JsonIgnore
    private InvoiceDto invoice;


}
