package edu.tenisscoreboard.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "player1", referencedColumnName = "id")
    private PlayerEntity firstPlayer;

    @ManyToOne
    @JoinColumn(name = "player2", referencedColumnName = "id")
    private PlayerEntity secondPlayer;

    @ManyToOne
    @JoinColumn(name = "winner", referencedColumnName = "id")
    private PlayerEntity winner;

}

