package com.xmall.auth.dao;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(nullable=false)
    private String name;

    public void setId(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority(){
        return name;
    }

    @Override
    public String toString(){
        return "Role{" +
                "ud-" + id +
                ", name ='" + name + '\'' +
                '}';
    }

}
