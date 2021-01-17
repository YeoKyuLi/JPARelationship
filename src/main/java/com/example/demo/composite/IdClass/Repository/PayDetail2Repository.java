package com.example.demo.composite.IdClass.Repository;

import com.example.demo.composite.IdClass.Entity.PayDetail2;
import com.example.demo.composite.IdClass.Entity.PayDetailId2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayDetail2Repository extends JpaRepository<PayDetail2, PayDetailId2> {
}