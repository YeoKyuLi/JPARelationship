package com.example.demo.oneToMany.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "MOM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Mom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "mom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // oneToMany와 mappedBy를 같이 써준다.
    // mappedBy: indicate the entity that owns the bidirectional relationship.
    private Set<Child> Childs;

    public Mom(String title)
    {
        this.title = title;
    }
}
