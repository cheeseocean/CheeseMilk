package com.cheeseocean.common.acl.model;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class AclEntry {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "acl_object_identity")
    private AclObjectIdentity objectIdentity;

    @Column(name = "ace_order")
    private int aceOrder;

    @ManyToOne
    @JoinColumn(name = "sid")
    private AclSid sid;

    private Integer mask;

    private boolean granting;

    @Column(name = "audit_success")
    private boolean auditSuccess;

    @Column(name = "audit_failure")
    private boolean auditFailure;
}
