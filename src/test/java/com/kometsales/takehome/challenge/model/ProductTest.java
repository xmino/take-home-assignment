package com.kometsales.takehome.challenge.model;

import com.kometsales.takehome.challenge.testbuilders.ProductTestBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getCode_generateProductCode_correctly() {
         Product product = ProductTestBuilder.builder().name("&White pom 3Inch").build();
         assertEquals("&4e-p1m-33h", product.getCode());;
    }
}