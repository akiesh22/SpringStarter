package com.spring.wc.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="score")
public class Score {
    @Id
    @GeneratedValue
    private int id;
    private double score;
    //Relationships
    @OneToOne
    private User user = new User();
    @ManyToOne
    private Group group = new Group();
}
