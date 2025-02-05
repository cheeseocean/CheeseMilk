package com.cheeseocean.common.acl.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class AclClass {

    @Id
    private Long id;

    @Column(name = "class", length = 100, unique = true)
    private String className;
}
