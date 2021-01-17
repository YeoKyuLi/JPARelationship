package com.example.demo.oneToMany.Repository;

import com.example.demo.oneToMany.Entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
