package com.car.cargame.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.cargame.Player;

@Repository
public interface PlayerDao extends JpaRepository<Player, Integer>{
    
}
