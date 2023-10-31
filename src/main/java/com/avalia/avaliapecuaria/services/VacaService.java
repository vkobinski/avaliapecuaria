package com.avalia.avaliapecuaria.services;

import com.avalia.avaliapecuaria.models.Vaca;
import com.avalia.avaliapecuaria.repositories.VacaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class VacaService {

    private final VacaRepository vacaRepository;

    @Autowired
    public VacaService(VacaRepository vacaRepository) {
        this.vacaRepository = vacaRepository;
    }

    public Optional<Vaca> createVaca(Vaca vaca) {
        try {
            return Optional.of(vacaRepository.save(vaca));
        } catch (Exception e) {
            log.error("Could not create Vaca in VacaService.java");
            return Optional.empty();
        }

    }
    public List<Vaca> getVacas() {
        return vacaRepository.findAll();
    }

    public List<Vaca> createVacas(List<Vaca> vacas) {
        List<Vaca> vacasRepo = vacaRepository.saveAll(vacas);
        return vacasRepo;
    }
}
