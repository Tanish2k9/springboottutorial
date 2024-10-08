package com.tutorials.springbook.tutorial.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String imageUrl;
    @OneToMany(mappedBy = "post",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
