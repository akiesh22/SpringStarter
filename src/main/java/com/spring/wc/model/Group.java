package com.spring.wc.model;


import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="groups")
public class Group {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int maxSize;
    private int minSize;


    //Relationships
    @ManyToMany(mappedBy = "groups",fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<User>();
    @OneToOne(fetch = FetchType.LAZY)
    private GroupStatistics groupStatistics;
}

