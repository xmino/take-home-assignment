package com.kometsales.takehome.challenge.testbuilders;

import com.kometsales.takehome.challenge.model.Company;
import lombok.Builder;

public class CompanyTestBuilder {
    @Builder
    public static Company company(Integer id, String name) {
        Company company = new Company();
        company.setId(id);
        company.setName(name);
        return company;
    }

    public static class CompanyBuilder {
        private Integer id = 1;
        private String name = "Company 1";
    }
}
