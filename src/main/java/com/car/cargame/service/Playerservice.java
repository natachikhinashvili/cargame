package com.car.cargame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.car.cargame.Player;
import com.car.cargame.DAO.PlayerDao;

@Service
@EnableAsync
public class Playerservice {
    private final class Player1 extends Thread {
        public void run(){
            for(int i =0;i< 10;i ++){
                System.out.println("hello");
            }
        }
    }    
    private final class Player2 extends Thread {
        
        public void run(){
            for(int i =0;i< 10;i ++){
                System.out.println("hi");
            }
        }
    }

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

    public void start1(){
        Player1 player1 = new Player1();
        player1.start();
    }  
    public void start2(){
        Player2 player2 = new Player2();
        player2.start();
    }
}
