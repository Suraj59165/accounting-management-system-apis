package com.manage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountOfferDto {
    private String id;
    private String discountName;
    private String discountType;
    private int discountValue;
}
