package com.manage.repositories;

import com.manage.entities.InvoiceItems;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface InvoiceItemsRepo extends JpaRepository<InvoiceItems, String> {
    @Modifying
    @Query("delete from InvoiceItems u  where u.id=:id")
    void deleteInvoiceItems(@Param("id") String id);
}
