package com.kometsales.takehome.challenge.testbuilders;

import com.kometsales.takehome.challenge.model.Customer;
import lombok.Builder;

public class CustomerTestBuilder {
    @Builder
    public static Customer customer(Integer id, String name, Double markdown) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setMarkdown(markdown);
        return customer;
    }

    public static class CustomerBuilder {
        private Integer id = 1;
        private String name = "Customer 1";
        private Double markdown = 25.0;
    }
}
