package com.example.demo.composite.IdClass.Repository;

import com.example.demo.composite.IdClass.Entity.Pay2;
import com.example.demo.composite.IdClass.Entity.PayId2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pay2Repository extends JpaRepository<Pay2, PayId2> {

}