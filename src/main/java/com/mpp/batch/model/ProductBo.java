package com.mpp.batch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductBo {
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate createdAt;
}
