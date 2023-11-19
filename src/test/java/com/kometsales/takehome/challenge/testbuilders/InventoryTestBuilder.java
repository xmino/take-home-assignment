package com.kometsales.takehome.challenge.testbuilders;

import com.kometsales.takehome.challenge.model.BoxType;
import com.kometsales.takehome.challenge.model.Company;
import com.kometsales.takehome.challenge.model.Inventory;
import com.kometsales.takehome.challenge.model.Product;
import lombok.Builder;

public class InventoryTestBuilder {

    @Builder
    public static Inventory inventory(Integer id,
                                      Double cubesPerCarrier,
                                      Integer pack, Double basePrice,
                                      Product product,
                                      Company company,
                                      BoxType boxType) {
        Inventory inventory = new Inventory();
        inventory.setId(id);
        inventory.setCubesPerCarrier(cubesPerCarrier);
        inventory.setPack(pack);
        inventory.setBasePrice(basePrice);
        inventory.setProduct(product);
        inventory.setCompany(company);
        inventory.setBoxType(boxType);
        return inventory;
    }

    public static class InventoryBuilder {
        private Integer id = 1;
        private Double cubesPerCarrier = 16.0;
        private Integer pack = 1;
        private Double basePrice = 1.5;
        private Product product = ProductTestBuilder.builder().build();
        private Company company = CompanyTestBuilder.builder().build();
        private BoxType boxType = BoxTypeTestBuilder.builder().build();
    }
}
