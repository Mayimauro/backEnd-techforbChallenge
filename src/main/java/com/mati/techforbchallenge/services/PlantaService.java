package com.mati.techforbchallenge.services;

import com.mati.techforbchallenge.entities.Planta;
import com.mati.techforbchallenge.repositories.plantaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantaService {

    private final plantaRepository plantaRepository;

    // Obtener todas las tarjetas
    public List<Planta> obtenerTodasLasPlantas() {
        return plantaRepository.findAll();
    }

    // Obtener una tarjeta por ID
    public Optional<Planta> obetenerPlantaPorId(Long id) {
        return plantaRepository.findById(id);
    }

    // Guardar una nueva tarjeta
    public Planta guardarPlanta(Planta tarjeta) {
        return plantaRepository.save(tarjeta);
    }

    // Eliminar una tarjeta por ID
    public void eliminarPlanta(Long id) {
        plantaRepository.deleteById(id);
    }
}