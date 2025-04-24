package com.yourorg.ums.service;

import com.yourorg.ums.dto.EnrollmentDTO;
import com.yourorg.ums.entity.Course;
import com.yourorg.ums.entity.Enrollment;
import com.yourorg.ums.entity.Student;
import com.yourorg.ums.repository.CourseRepository;
import com.yourorg.ums.repository.EnrollmentRepository;
import com.yourorg.ums.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public Enrollment enrollStudent(EnrollmentDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId())
            .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(dto.getCourseId())
            .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
