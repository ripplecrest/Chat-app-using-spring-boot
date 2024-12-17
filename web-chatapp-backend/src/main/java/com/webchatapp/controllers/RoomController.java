package com.webchatapp.controllers;

import com.webchatapp.entities.Room;
import com.webchatapp.repositories.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){

        if(roomRepository.findById(roomId) != null)
        {
            //room is already there
            return ResponseEntity.badRequest().body("Room already exists");

        }

        //create new room
        Room room = new Room();
        room.setRoomId(roomId);
        Room savedRoom = roomRepository.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);

    }

    //get room : join
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(
            @PathVariable String roomId
    ){

        Room room = roomRepository.findByRoomId(roomId);

        if(room == null){
            return ResponseEntity.badRequest()
                    .body("Room not found");
        }
        return ResponseEntity.ok(room);

    }


    //get messages of room

}
