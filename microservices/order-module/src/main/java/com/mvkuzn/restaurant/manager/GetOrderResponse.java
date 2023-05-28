package com.mvkuzn.restaurant.manager;

import com.mvkuzn.restaurant.auth.Response;
import com.mvkuzn.restaurant.order.Order;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse extends Response {

    private Order order;
}
