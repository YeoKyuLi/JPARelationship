package com.example.demo.composite.Embedded.Entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
@NoArgsConstructor
public class PayDetailId implements Serializable {

    @EqualsAndHashCode.Include
    private PayId payId;

    @EqualsAndHashCode.Include
    @Column
    private Long payDetailId;

    public PayDetailId(PayId payId,
                       Long payDetailId) {
        this.payId = payId;
        this.payDetailId = payDetailId;
    }
}
