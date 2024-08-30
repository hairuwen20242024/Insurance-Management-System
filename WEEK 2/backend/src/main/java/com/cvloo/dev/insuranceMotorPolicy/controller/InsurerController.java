package com.cvloo.dev.insuranceMotorPolicy.controller;

import com.cvloo.dev.insuranceMotorPolicy.domain.Insurer;
import com.cvloo.dev.insuranceMotorPolicy.domain.Insurer;
import com.cvloo.dev.insuranceMotorPolicy.service.InsurerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurers")
public class InsurerController {

    @Autowired
    private InsurerService insurerService;

    @GetMapping
    public ResponseEntity<List<Insurer>> getAllInsurers() {
        List<Insurer> insurers = insurerService.getAllInsurers();
        return ResponseEntity.ok(insurers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insurer> getInsurerById(@PathVariable Long id) {
        Insurer insurer = insurerService.getInsurerById(id);
        return ResponseEntity.ok(insurer);
    }

    @PostMapping
    public ResponseEntity<Insurer> createInsurer(@RequestBody Insurer insurer) {
        Insurer createdInsurer = insurerService.createInsurer(insurer);
        return ResponseEntity.ok(createdInsurer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Insurer> updateInsurer(@PathVariable Long id, @RequestBody Insurer insurer) {
        Insurer updatedInsurer = insurerService.updateInsurer(id, insurer);
        return ResponseEntity.ok(updatedInsurer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurer(@PathVariable Long id) {
        insurerService.deleteInsurer(id);
        return ResponseEntity.noContent().build();
    }
}
