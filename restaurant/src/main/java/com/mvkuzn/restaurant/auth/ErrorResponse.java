package com.mvkuzn.restaurant.auth;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse extends Response {

    private String message;
}
