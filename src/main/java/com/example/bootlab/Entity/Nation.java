package com.example.bootlab.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nation {
    @Id
    private long id;

    private String name;

    private String continent;

    private long popular;
}
