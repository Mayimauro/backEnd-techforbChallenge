package com.mati.techforbchallenge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lecturas_sensores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LecturaSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private NivelAlerta nivelAlerta;
    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;
}
