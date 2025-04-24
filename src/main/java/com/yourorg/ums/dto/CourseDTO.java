package com.yourorg.ums.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CourseDTO {
    private Long id;
    private String title;
    private LocalDate startDate;
    private int enrolledCount;
}
