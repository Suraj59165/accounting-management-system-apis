package com.manage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Items {
    @Id
    private String id;
    private String itemName;
    private long itemSalesPrice;
    private int itemOffer;
    private int itemTax;
    private long itemFinalPrice;


}
