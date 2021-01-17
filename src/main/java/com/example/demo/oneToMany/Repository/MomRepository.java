package com.example.demo.oneToMany.Repository;

import com.example.demo.oneToMany.Entity.Mom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MomRepository  extends JpaRepository<Mom, Long> {
    Mom findByTitle(String title);
}
