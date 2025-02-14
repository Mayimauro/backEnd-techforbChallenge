package com.mati.techforbchallenge.controllers;

import com.mati.techforbchallenge.entities.Planta;
import com.mati.techforbchallenge.services.PlantaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permite el acceso desde Angular
@RequestMapping("/api/v1/plantas")
@RequiredArgsConstructor
public class plantaController {

    private final PlantaService plantaService;

    @GetMapping
    public List<Planta> obtenerTodasLasPlantas() {
        return plantaService.obtenerTodasLasPlantas();
    }

    @GetMapping("/{id}")
    public Optional<Planta> obtenerPlantaPorId(@PathVariable Long id) {
        return plantaService.obetenerPlantaPorId(id);
    }

    @PostMapping
    public Planta guardarPlanta(@RequestBody Planta tarjeta) {
        return plantaService.guardarPlanta(tarjeta);
    }

    @DeleteMapping("/{id}")
    public void elminarPlanta(@PathVariable Long id) {
        plantaService.eliminarPlanta(id);
    }
}