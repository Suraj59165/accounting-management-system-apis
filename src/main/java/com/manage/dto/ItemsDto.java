package com.manage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemsDto {
    private String id;
    private String itemName;
    private BigDecimal itemSalesPrice;
    private BigDecimal itemOffer;
    private BigDecimal itemTax;
    private BigDecimal itemFinalPrice;


}
