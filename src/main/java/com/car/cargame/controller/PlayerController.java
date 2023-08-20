package com.car.cargame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.car.cargame.Player;
import com.car.cargame.service.Playerservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PlayerController {

    @Autowired
    Playerservice playerservice;


    @GetMapping("/")
    public synchronized ResponseEntity<List<Player>> getStarter(){
        playerservice.start1();
        playerservice.start2();
        return playerservice.getAllPlayers();
    }

    @PostMapping("add")
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        return playerservice.addPlayer(player);
    }
    
}
