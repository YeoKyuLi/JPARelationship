package com.example.demo.composite.Embedded.Repository;

import com.example.demo.composite.Embedded.Entity.Pay;
import com.example.demo.composite.Embedded.Entity.PayId;
import com.example.demo.composite.Embedded.Entity.PayShopId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  PayRepository extends JpaRepository<Pay, PayId> {

    List<Pay> findByPayShops(PayShopId payShopId);
}
