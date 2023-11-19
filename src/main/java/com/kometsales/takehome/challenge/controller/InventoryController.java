package com.kometsales.takehome.challenge.controller;

import com.kometsales.takehome.challenge.dto.CompanyFreightDTO;
import com.kometsales.takehome.challenge.dto.CompanyProductDTO;
import com.kometsales.takehome.challenge.dto.CustomerProductDTO;
import com.kometsales.takehome.challenge.service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * Calculate the final freight for each product of the company
     * @param companyId
     * @return CompanyFreightDTO
     */
    @GetMapping("/final/freight/{companyId}")
    public CompanyFreightDTO finalFreight(@PathVariable("companyId") Integer companyId) {
        return inventoryService.calculateFinalFreight(companyId);
    }

    /**
     * List all products with their respective code for a customer
     * @param customerId
     * @return List<CustomerProductDTO>
     */
    @GetMapping("/customer/price/{customerId}")
    public List<CustomerProductDTO> customerPrice(@PathVariable("customerId") Integer customerId) {
        return inventoryService.calculateCustomerPrice(customerId);
    }

    /**
     * List all products with their respective code for a company
     * @param companyId
     * @return List<CompanyProductDTO>
     */
    @GetMapping("/products/company/{companyId}")
    public List<CompanyProductDTO> companyProducts(@PathVariable("companyId") Integer companyId) {
        return inventoryService.calculateProductsCode(companyId);
    }
    
}
