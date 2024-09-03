package com.example.nba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private Long id;
    private String name;
    private int points;
}
