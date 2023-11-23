package com.manage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Items {
    @Id
    private String id;
    private String itemName;
    private BigDecimal itemSalesPrice;
    private BigDecimal itemOffer;
    private BigDecimal itemTax;
    private BigDecimal itemFinalPrice;


}
