package com.example.demo.oneToMany.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CHILD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOM_ID")
    //ManyToMone와 JoinColumn을 같이써준다.
    private Mom mom;

    public Child (String title, Mom mom)
    {
        this.title = title;
        this.mom = mom;
    }
}
