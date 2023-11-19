package com.kometsales.takehome.challenge.testbuilders;

import com.kometsales.takehome.challenge.model.Product;
import lombok.Builder;

public class ProductTestBuilder {
    @Builder
    public static Product product(Integer id, String name, Double freshCutValue) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setFreshCutValue(freshCutValue);
        return product;
    }

    public static class ProductBuilder {
        private Integer id = 1;
        private String name = "Product 1";
        private Double freshCutValue = 25.0;
    }
}
