package com.kometsales.takehome.challenge.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerProductDTO {

    @Parsed
    private String productName;

    @Parsed
    private String companyName;

    @Parsed
    private String price;
}
