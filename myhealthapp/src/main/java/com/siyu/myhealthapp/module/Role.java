package com.siyu.myhealthapp.module;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Table(name = "roles")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column
    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName roleName;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public Role() {}

}
