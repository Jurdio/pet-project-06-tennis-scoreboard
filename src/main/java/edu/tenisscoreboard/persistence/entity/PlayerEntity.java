package edu.tenisscoreboard.persistence.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "players")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PlayerEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "name")
        private String name;
}
