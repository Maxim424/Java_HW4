package com.mvkuzn.restaurant.manager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DishQuantityForRequest {

    private Integer id;
    private Integer quantity;
}
