package com.mvkuzn.restaurant.manager;

import com.mvkuzn.restaurant.auth.Response;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse extends Response {

    private String status;
    private String message;
}
