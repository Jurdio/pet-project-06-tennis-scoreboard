package edu.tenisscoreboard.persistence.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@Table(name = "players")
public class PlayerEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "name")
        private String name;
}
