package com.yourorg.ums.repository;

import com.yourorg.ums.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
