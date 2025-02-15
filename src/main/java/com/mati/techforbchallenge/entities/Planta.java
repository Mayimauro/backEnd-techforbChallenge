package com.mati.techforbchallenge.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plantas")
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ubicacion;
    @OneToMany(mappedBy = "planta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sensor> sensores;
}
