package com.mvkuzn.restaurant.manager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddDishRequest {

    private String name;
    private String description;
    private Integer price;
    private Integer quantity;
}
