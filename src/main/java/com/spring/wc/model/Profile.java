package com.spring.wc.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="profile")
public class Profile {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    //Relationships
}
