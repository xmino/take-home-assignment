package com.kometsales.takehome.challenge.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblinventorypt")
@Getter
@Setter
@NoArgsConstructor
public class Inventory {

    private static final Integer INCHES_CUBE = 1728;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cubes_per_carrier")
    private Double cubesPerCarrier;

    @Column(name = "pack")
    private Integer pack;

    @Column(name = "base_price")
    private Double basePrice;

    @ManyToOne
    @JoinColumn(name = "box_type_id", nullable = false)
    private BoxType boxType;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    /**
     *
     * @return Final freight calculated (outboundFreight  * (  freshCutValue  /100))
     */
    public Double getFinalFreight() {
        double cubesPerBox = (boxType.getWidth() * boxType.getHeight() * boxType.getLength()) / INCHES_CUBE;
        double outboundFreight = (cubesPerBox * cubesPerCarrier) / pack;
        return outboundFreight * (product.getFreshCutValue()/100);
    }

    public double getCustomerPrice(Double markdown) {
        return basePrice - (basePrice * (markdown / 100));
    }
}
