package com.yourorg.ums.mapper;

import com.yourorg.ums.dto.StudentDTO;
import com.yourorg.ums.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "user.username", target = "username")
    StudentDTO toDTO(Student student);

    @Mapping(target = "user", ignore = true) // handled manually or in service
    Student toEntity(StudentDTO dto);
}
