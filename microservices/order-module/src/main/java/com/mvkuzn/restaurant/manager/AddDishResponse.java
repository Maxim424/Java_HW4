package com.mvkuzn.restaurant.manager;

import com.mvkuzn.restaurant.auth.Response;
import com.mvkuzn.restaurant.dish.Dish;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddDishResponse extends Response {

    private Dish dish;
}
