package com.spring.wc.model;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    //Relationships
    @OneToOne(fetch = FetchType.LAZY)
    private PlayerStatistics statistics;
    @OneToOne(fetch = FetchType.LAZY)
    private Profile profile;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_group", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "group_id")})
    Set<Group> groups = new HashSet<Group>();
    }

