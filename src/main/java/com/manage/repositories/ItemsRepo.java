package com.manage.repositories;

import com.manage.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepo extends JpaRepository<Items, String> {
}
