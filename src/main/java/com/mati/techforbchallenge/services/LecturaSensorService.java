package com.mati.techforbchallenge.services;

import com.mati.techforbchallenge.entities.LecturaSensor;
import com.mati.techforbchallenge.repositories.LecturaSensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturaSensorService {

    private final LecturaSensorRepository lecturaSensorRepository;

    public List<LecturaSensor> obtenerLecturas() {
        return lecturaSensorRepository.findAll();
    }


}