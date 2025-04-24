package com.yourorg.ums.controller;

import com.yourorg.ums.dto.EnrollmentDTO;
import com.yourorg.ums.entity.Enrollment;
import com.yourorg.ums.mapper.EnrollmentMapper;
import com.yourorg.ums.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final EnrollmentMapper enrollmentMapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
        List<EnrollmentDTO> enrollments = enrollmentService.getAllEnrollments()
                .stream()
                .map(enrollmentMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id)
                .map(enrollmentMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> enrollStudent(@RequestBody EnrollmentDTO enrollmentDTO) {
        Enrollment saved = enrollmentService.enrollStudent(enrollmentDTO);
        return ResponseEntity.ok(enrollmentMapper.toDTO(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}
