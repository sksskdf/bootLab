package com.example.bootlab.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
    @Id
    private long id;

    private String name;

    private int age;

    @OneToOne
    private Nation nation;
}
