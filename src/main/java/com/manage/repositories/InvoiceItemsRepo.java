package com.manage.repositories;

import com.manage.entities.InvoiceItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepo extends JpaRepository<InvoiceItems,String> {
}
