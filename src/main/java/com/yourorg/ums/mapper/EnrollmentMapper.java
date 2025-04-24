package com.yourorg.ums.mapper;

import com.yourorg.ums.dto.EnrollmentDTO;
import com.yourorg.ums.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "course.id", target = "courseId")
    EnrollmentDTO toDTO(Enrollment enrollment);

    @Mapping(target = "student", ignore = true)
    @Mapping(target = "course", ignore = true)
    Enrollment toEntity(EnrollmentDTO dto);
}