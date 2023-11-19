package com.kometsales.takehome.challenge.testbuilders;

import com.kometsales.takehome.challenge.model.BoxType;
import lombok.Builder;

public class BoxTypeTestBuilder {
    @Builder
    public static BoxType boxType(Integer id, String code, Double width, Double height, Double length) {
        BoxType boxType = new BoxType();
        boxType.setId(id);
        boxType.setCode(code);
        boxType.setWidth(width);
        boxType.setHeight(height);
        boxType.setLength(length);
        return boxType;
    }

    public static class BoxTypeBuilder {
        private Integer id = 1;
        private String code = "456132";
        private Double width = 12.1;
        private Double height = 22.0;
        private Double length = 13.0;
    }
}
