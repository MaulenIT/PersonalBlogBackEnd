package com.example.pressRelize.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "postTable")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Timestamp timerSendMessage;

    @Column
    Timestamp postCreatedTime;

}
