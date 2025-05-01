package com.yourorg.ums.mapper;

import com.yourorg.ums.dto.CourseDTO;
import com.yourorg.ums.entity.Course;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CourseDTO courseDTO);
    default CourseDTO toDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setStartDate(course.getStartDate());

        if (course.getEnrollments() != null) {
            dto.setEnrolledCount(course.getEnrollments().size());
        } else {
            dto.setEnrolledCount(0);
        }

        return dto;
    }
}
