package com.example.demo.composite.IdClass.Entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class PayShopId2 implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private Long payNumber;

    @EqualsAndHashCode.Include
    @Id
    private Long paySeq;

    @EqualsAndHashCode.Include
    @Id
    private Long payDetailId;

    @EqualsAndHashCode.Include
    @Id
    private String shopNumber;

    public PayShopId2(Long payNumber, Long paySeq, Long payDetailId, String shopNumber)
    {
        this.payNumber = payNumber;
        this.paySeq = paySeq;
        this.payDetailId = payDetailId;
        this.shopNumber = shopNumber;
    }
}