package edu.tenisscoreboard.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "matches")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player1", referencedColumnName = "id")
    private PlayerEntity player1;

    @ManyToOne
    @JoinColumn(name = "player2", referencedColumnName = "id")
    private PlayerEntity player2;

    @ManyToOne
    @JoinColumn(name = "winner", referencedColumnName = "id")
    private PlayerEntity winner;

}

