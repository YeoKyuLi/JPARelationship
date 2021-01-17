package com.example.demo.manyToMany.Repository;

import com.example.demo.manyToMany.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
