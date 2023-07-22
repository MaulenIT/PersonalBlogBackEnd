package com.example.pressRelize.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comments;

//    @JsonIgnore
//    @ManyToOne(cascade = CascadeType.ALL)
//    private User sender;
//
//    @JsonIgnore
//    @ManyToOne(cascade = CascadeType.ALL)
//    private Post post;
}
