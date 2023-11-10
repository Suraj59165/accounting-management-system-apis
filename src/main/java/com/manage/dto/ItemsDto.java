package com.manage.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemsDto {
    private String id;
    private String itemName;
    private long itemSalesPrice;
    private int itemOffer;
    private int itemTax;
    private long itemFinalPrice;


}
