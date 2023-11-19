package com.kometsales.takehome.challenge.repository;

import com.kometsales.takehome.challenge.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    List<Inventory> findByCompany_Id(Integer id);
    
}
