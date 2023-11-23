package com.manage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItems {
    @Id
    private String id;
    private String itemName;
    private BigDecimal itemSalesPrice;
    private BigDecimal itemQuantity;
    private BigDecimal itemOffer;
    private BigDecimal itemTax;
    private BigDecimal itemFinalPrice;
    @ManyToOne
    private Invoice invoice;


}
