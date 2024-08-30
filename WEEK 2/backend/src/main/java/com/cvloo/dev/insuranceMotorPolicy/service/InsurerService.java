package com.cvloo.dev.insuranceMotorPolicy.service;

import com.cvloo.dev.insuranceMotorPolicy.domain.Insurer;
import com.cvloo.dev.insuranceMotorPolicy.repository.InsurerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsurerService {

    @Autowired
    private InsurerRepository insurerRepository;

    public List<Insurer> getAllInsurers() {
        return insurerRepository.findAll();
    }

    public Insurer getInsurerById(Long id) {
        Optional<Insurer> insurer = insurerRepository.findById(id);
        return insurer.orElseThrow(() -> new RuntimeException("Insurer not found"));
    }

    public Insurer createInsurer(Insurer insurer) {
        return insurerRepository.save(insurer);
    }

    public Insurer updateInsurer(Long id, Insurer insurerDetails) {
        Insurer insurer = getInsurerById(id);
        insurer.setName(insurerDetails.getName());
        insurer.setEmail(insurerDetails.getEmail());
        insurer.setAddress(insurerDetails.getAddress());
        insurer.setTelephoneNumber(insurerDetails.getTelephoneNumber());
        return insurerRepository.save(insurer);
    }

    public void deleteInsurer(Long id) {
        insurerRepository.deleteById(id);
    }
}

