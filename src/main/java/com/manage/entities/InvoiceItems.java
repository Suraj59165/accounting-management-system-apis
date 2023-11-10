package com.manage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItems {
    @Id
    private String  id;
    private String itemName;
    private long itemSalesPrice;
    private int itemQuantity;
    private int itemOffer;
    private int itemTax;
    private int itemFinalPrice;
    @ManyToOne
    private Invoice invoice;


}
