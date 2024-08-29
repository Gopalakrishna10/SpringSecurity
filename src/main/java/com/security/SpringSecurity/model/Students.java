package com.security.SpringSecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Students {

    @Id
    private Integer id;

    private String name;

    private String marks;
}
