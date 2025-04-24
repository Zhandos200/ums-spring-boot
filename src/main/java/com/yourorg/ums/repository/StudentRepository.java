package com.yourorg.ums.repository;

import com.yourorg.ums.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
