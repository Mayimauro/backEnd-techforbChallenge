package com.mati.techforbchallenge.services;

import com.mati.techforbchallenge.entities.Sensor;
import com.mati.techforbchallenge.repositories.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    public List<Sensor> obtenerTodosLosSensores() {
        return sensorRepository.findAll();
    }

}