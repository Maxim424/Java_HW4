package com.mvkuzn.restaurant.manager;

import com.mvkuzn.restaurant.auth.Response;
import com.mvkuzn.restaurant.dish.Dish;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMenuResponse extends Response {

    private List<Dish> menu;
}
