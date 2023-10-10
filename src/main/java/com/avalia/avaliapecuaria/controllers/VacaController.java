package com.avalia.avaliapecuaria.controllers;

import com.avalia.avaliapecuaria.models.Vaca;
import com.avalia.avaliapecuaria.services.VacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/vaca")
public class VacaController {

    private final VacaService vacaService;

    @Autowired
    public VacaController(VacaService vacaService) {
        this.vacaService = vacaService;
    }

    @PostMapping
    public ResponseEntity<Vaca> createVaca(@RequestBody Vaca vaca) {
        Optional<Vaca> vacaOp = vacaService.createVaca(vaca);
        return vacaOp.map(value -> ResponseEntity.status(201).body(vacaOp.get()))
                .orElseGet(() -> ResponseEntity.unprocessableEntity().body(null));
    }

    @GetMapping
    public ResponseEntity<List<Vaca>> getVacas() {
        return ResponseEntity.ok(vacaService.getVacas());
    }
}
