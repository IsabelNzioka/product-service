package com.isabel.productservice.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCreateResponse {

    // DTO for wrapping the response from the server to the user
    // private Integer id;
    private String name;
    // private BigDecimal price;

    
}