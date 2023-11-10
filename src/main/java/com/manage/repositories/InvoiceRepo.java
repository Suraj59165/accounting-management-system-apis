package com.manage.repositories;

import com.manage.entities.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepo extends JpaRepository<Invoice, Integer> {

    Page<Invoice> getInvoiceByCustomerId(String customerId, Pageable pageable);

    Optional<Invoice> getInvoiceByInvoiceNumber(int invoiceNumber);
}
