package com.webchatapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collation = "rooms")
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Room {
    @Id
    private String id; //mongodb unique identifier
    private String roomId;
    private List<Message> messages = new ArrayList<>();
}
