package com.mvkuzn.restaurant.manager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {

    private String email;
    private List<DishQuantityForRequest> dishes;
    private String specialRequests;
}
