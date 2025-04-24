package com.yourorg.ums.mapper;

import com.yourorg.ums.dto.CourseDTO;
import com.yourorg.ums.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toDTO(Course course);
    Course toEntity(CourseDTO dto);
}
