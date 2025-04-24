package com.yourorg.ums.dto;

import com.yourorg.ums.entity.User;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private User.Role role;
}
