package com.kometsales.takehome.challenge.service;

import com.kometsales.takehome.challenge.dto.CompanyFreightDTO;
import com.kometsales.takehome.challenge.dto.CompanyProductDTO;
import com.kometsales.takehome.challenge.dto.CustomerProductDTO;

import java.util.List;

public interface InventoryService {

    CompanyFreightDTO calculateFinalFreight(Integer companyId);

    List<CustomerProductDTO> calculateCustomerPrice(Integer customerId);

    List<CompanyProductDTO> calculateProductsCode(Integer companyId);
}
