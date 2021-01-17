package com.example.demo.oneToOne.Repository;

import com.example.demo.oneToOne.Entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
