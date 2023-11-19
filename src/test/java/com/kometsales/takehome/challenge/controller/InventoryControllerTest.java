package com.kometsales.takehome.challenge.controller;

import com.kometsales.takehome.challenge.ApplicationConfig;
import com.kometsales.takehome.challenge.repository.CustomerRepository;
import com.kometsales.takehome.challenge.repository.InventoryRepository;
import com.kometsales.takehome.challenge.service.InventoryService;
import com.kometsales.takehome.challenge.service.impl.InventoryServiceImpl;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Import(ApplicationConfig.class)
public class InventoryControllerTest {
    private static final String INVENTORY_PATH = "/inventory";

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private InventoryController inventoryController;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    public InventoryRepository inventoryRepository;

    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private InventoryService inventoryService = new InventoryServiceImpl(inventoryRepository, customerRepository, modelMapper);
    
    @Test
    void shouldCalculateFinalFreight() throws Exception {
        this.mockMvc.perform(get(INVENTORY_PATH + "/final/freight/{companyId}", 1))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.products[0].finalFreight", Is.is("3.07")));
    }

    @Test
    void calculateFinalFreightWithNonexistentCompany() throws Exception {
        this.mockMvc.perform(get(INVENTORY_PATH + "/final/freight/{companyId}", 999))
                    .andExpect(status().isNotFound());
    }

    @Test
    void shouldCalculateCustomerPrice() throws Exception {
        this.mockMvc.perform(get(INVENTORY_PATH + "/customer/price/{customerId}", 1))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].productName", Is.is("White pom 3Inch")))
                    .andExpect(jsonPath("$[0].price", Is.is("1.05")));
    }

    @Test
    void calculateCustomerPriceWithNonexistentCustomer() throws Exception {
        this.mockMvc.perform(get(INVENTORY_PATH + "/customer/price/{customerId}", 999))
                    .andExpect(status().isNotFound());
    }

    @Test
    void calculateCustomerPriceWithEmptyInventory() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(inventoryService).build();
        when(inventoryRepository.findAll()).thenReturn(List.of());
        mockMvc.perform(get(INVENTORY_PATH + "/customer/price/{customerId}", 2))
                    .andExpect(status().isNotFound());
    }

    @Test
    void shouldCalculateProductsCode() throws Exception {
        this.mockMvc.perform(get(INVENTORY_PATH + "/products/company/{companyId}", 1))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].productName", Is.is("IL Hydrangea Blue")))
                    .andExpect(jsonPath("$[0].productCode", Is.is("I0L-H7a-B2e")));
    }

    @Test
    void calculateProductsCodeWithNonexistentCompany() throws Exception {
        this.mockMvc.perform(get(INVENTORY_PATH + "/products/company/{companyId}", 999))
                    .andExpect(status().isNotFound());
    }

}