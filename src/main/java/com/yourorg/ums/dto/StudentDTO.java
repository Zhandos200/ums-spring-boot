package com.yourorg.ums.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username; // extracted from linked User entity
}
