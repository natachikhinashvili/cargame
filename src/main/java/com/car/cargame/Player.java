package com.car.cargame;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "players")
public class Player {
    @Id
    private Integer id;
    private String name;
    private Integer points;
}
