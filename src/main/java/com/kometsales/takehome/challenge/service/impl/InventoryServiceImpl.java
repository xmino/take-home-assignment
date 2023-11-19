package com.kometsales.takehome.challenge.service.impl;

import java.text.DecimalFormat;
import java.util.List;

import com.kometsales.takehome.challenge.dto.CompanyProductDTO;
import com.kometsales.takehome.challenge.dto.CustomerProductDTO;
import com.kometsales.takehome.challenge.dto.ProductFreightDTO;
import com.kometsales.takehome.challenge.exceptions.ResourceNotFoundException;
import com.kometsales.takehome.challenge.model.Customer;
import com.kometsales.takehome.challenge.model.Inventory;
import com.kometsales.takehome.challenge.dto.CompanyFreightDTO;
import com.kometsales.takehome.challenge.repository.CustomerRepository;
import com.kometsales.takehome.challenge.repository.InventoryRepository;
import com.kometsales.takehome.challenge.service.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private InventoryRepository inventoryRepository;
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository,
                                CustomerRepository customerRepository,
                                ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.inventoryRepository = inventoryRepository;
    }

    /**
     *
     * @param companyId
     * @return Items from inventory with final freight calculated
     */
    @Override
    public CompanyFreightDTO calculateFinalFreight(Integer companyId) {
        List<Inventory> inventories = inventoryRepository.findByCompany_Id(companyId);
        if(inventories.isEmpty()) {
            throw new ResourceNotFoundException("Company not found or inventory is empty");
        }
        List<ProductFreightDTO> products = inventories.stream()
                                                      .map(inventory -> ProductFreightDTO.builder()
                                                               .productName(inventory.getProduct().getName())
                                                               .basePrice(df.format(inventory.getBasePrice()))
                                                               .finalFreight(df.format(inventory.getFinalFreight()))
                                                               .build())
                                                      .toList();
        return CompanyFreightDTO.builder().companyId(companyId).products(products).build();
    }

    /**
     *
     * @param customerId
     * @return Items from inventory with customer price calculated
     */
    @Override
    public List<CustomerProductDTO> calculateCustomerPrice(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                                              .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        List<Inventory> inventories = inventoryRepository.findAll();
        if(inventories.isEmpty()) {
            throw new ResourceNotFoundException("Inventory is empty");
        }
        return inventories.stream()
                          .map(inventory -> CustomerProductDTO.builder()
                                                              .productName(inventory.getProduct().getName())
                                                              .companyName(inventory.getCompany().getName())
                                                              .price(df.format(inventory.getCustomerPrice(customer.getMarkdown())))
                                                              .build())
                          .toList();
    }

    /**
     *
     * @param companyId
     * @return Items from inventory with product code calculated
     */
    @Override
    public List<CompanyProductDTO> calculateProductsCode(Integer companyId) {
        List<Inventory> inventories = inventoryRepository.findByCompany_Id(companyId);
        if(inventories.isEmpty()) {
            throw new ResourceNotFoundException("Company not found or inventory is empty");
        }
        return inventories.stream()
                          .map(inventory -> CompanyProductDTO.builder()
                                                             .productName(inventory.getProduct().getName())
                                                             .productCode(inventory.getProduct().getCode())
                                                             .build())
                          .toList();
    }
}
