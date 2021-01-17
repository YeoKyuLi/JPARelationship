package com.example.demo.manyToMany.Repository;

import com.example.demo.manyToMany.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
