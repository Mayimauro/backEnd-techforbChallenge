package com.mati.techforbchallenge.repositories;

import com.mati.techforbchallenge.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> { }