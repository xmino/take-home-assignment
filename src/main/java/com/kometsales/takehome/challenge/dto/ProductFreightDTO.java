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
public class ProductFreightDTO {

    @Parsed
    private String productName;

    @Parsed
    private String basePrice;

    @Parsed
    private String finalFreight;
}
