package com.example.demo.composite.Embedded.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class PayShop {

    @EmbeddedId
    private PayShopId id;

    private String shopName;

    @MapsId(value = "payId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pay pay;

    public PayShop(PayShopId id,
                   String shopName) {
        this.id = id;
        this.shopName = shopName;
    }

    public void setPay(Pay pay) {
        if (pay != null) {
            pay.getPayShops().remove(this);
        }
        this.pay = pay;
        this.pay.getPayShops().add(this);
    }
}