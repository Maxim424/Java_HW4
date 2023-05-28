package com.mvkuzn.restaurant.auth;

import com.mvkuzn.restaurant.session.Session;
import com.mvkuzn.restaurant.user.Role;
import lombok.*;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponse extends Response{

    private String username;
    private String email;
    private Role role;
    private Date createdAt;
    private Date updatedAt;
    private List<Session> sessions;
}
