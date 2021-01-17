package com.example.demo.composite.IdClass.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@IdClass(PayId2.class)
@Entity
@Table(name = "pay_2")
@NoArgsConstructor
public class Pay2 {

    @Id
    private Long payNumber;

    @Id
    private Long paySeq;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pay2")
    private List<PayShop2> payShop2List = new ArrayList<>();

    public Pay2(Long payNumber, Long paySeq)
    {
        this.payNumber = payNumber;
        this.paySeq = paySeq;
    }
}