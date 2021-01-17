package com.example.demo.composite.Embedded.Repository;

import com.example.demo.composite.Embedded.Entity.PayShop;
import com.example.demo.composite.Embedded.Entity.PayShopId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayShopRepository extends JpaRepository<PayShop, PayShopId> {
}
