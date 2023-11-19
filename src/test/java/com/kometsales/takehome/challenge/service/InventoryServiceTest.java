package com.kometsales.takehome.challenge.service;

import com.kometsales.takehome.challenge.dto.CompanyFreightDTO;
import com.kometsales.takehome.challenge.dto.CompanyProductDTO;
import com.kometsales.takehome.challenge.dto.CustomerProductDTO;
import com.kometsales.takehome.challenge.exceptions.ResourceNotFoundException;
import com.kometsales.takehome.challenge.repository.CustomerRepository;
import com.kometsales.takehome.challenge.repository.InventoryRepository;
import com.kometsales.takehome.challenge.service.impl.InventoryServiceImpl;
import com.kometsales.takehome.challenge.testbuilders.CustomerTestBuilder;
import com.kometsales.takehome.challenge.testbuilders.InventoryTestBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {
    
    @InjectMocks
    public InventoryServiceImpl inventoryService;

    @Mock
    public InventoryRepository inventoryRepository;

    @Mock
    public CustomerRepository customerRepository;

    @Mock
    private ModelMapper mapper;

    @Test
    void testCalculateFinalFreight() {
        Double finalFreight = 8.01;
        when(inventoryRepository.findByCompany_Id(1)).thenReturn(List.of(InventoryTestBuilder.builder().build()));
        CompanyFreightDTO result = inventoryService.calculateFinalFreight(1);
        Mockito.verify(inventoryRepository).findByCompany_Id(1);
        Assertions.assertEquals(result.getCompanyId(), 1);
        Assertions.assertEquals(finalFreight.toString(), result.getProducts().stream().findFirst().get().getFinalFreight());
    }

    @Test
    void calculateFinalFreightWithNonexistentCompany() {
        when(inventoryRepository.findByCompany_Id(999)).thenReturn(List.of());
        Assertions.assertThrows(ResourceNotFoundException.class,
                                () -> inventoryService.calculateFinalFreight(999));
    }

    @Test
    void testCalculateCustomerPrice() {
        Double price = 1.12;
        when(customerRepository.findById(1)).thenReturn(Optional.of(CustomerTestBuilder.builder().build()));
        when(inventoryRepository.findAll()).thenReturn(List.of(InventoryTestBuilder.builder().build()));

        List<CustomerProductDTO> result = inventoryService.calculateCustomerPrice(1);

        Mockito.verify(customerRepository).findById(1);
        Mockito.verify(inventoryRepository).findAll();
        Assertions.assertEquals(price.toString(), result.stream().findFirst().get().getPrice());
    }

    @Test
    void calculateCustomerPriceWithNonexistentCustomer() {
        when(customerRepository.findById(999)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundException.class,
                                () -> inventoryService.calculateCustomerPrice(999));
    }

    @Test
    void calculateCustomerPriceWithEmptyInventory() {
        when(customerRepository.findById(1)).thenReturn(Optional.of(CustomerTestBuilder.builder().build()));
        when(inventoryRepository.findAll()).thenReturn(List.of());
        Assertions.assertThrows(ResourceNotFoundException.class,
                                () -> inventoryService.calculateCustomerPrice(1));
    }

    @Test
    void testCalculateProductsCode() {
        when(inventoryRepository.findByCompany_Id(1)).thenReturn(List.of(InventoryTestBuilder.builder().build()));
        List<CompanyProductDTO> result = inventoryService.calculateProductsCode(1);
        Mockito.verify(inventoryRepository).findByCompany_Id(1);
        Assertions.assertEquals("P5t-1", result.stream().findFirst().get().getProductCode());
    }

    @Test
    void calculateProductsCodeWithNonexistentCompany() {
        when(inventoryRepository.findByCompany_Id(999)).thenReturn(List.of());
        Assertions.assertThrows(ResourceNotFoundException.class,
                                () -> inventoryService.calculateProductsCode(999));
    }

}
