package com.car.cargame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.car.cargame.Player;
import com.car.cargame.DAO.PlayerDao;

@Service
public class Playerservice {
    @Autowired
    PlayerDao playerDao;

    public ResponseEntity<List<Player>> getAllPlayers() {
        try{
            return new ResponseEntity<>(playerDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addPlayer(Player user) {
        playerDao.save(user);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

}
