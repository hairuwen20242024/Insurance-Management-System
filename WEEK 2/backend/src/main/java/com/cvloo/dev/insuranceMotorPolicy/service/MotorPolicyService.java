package com.cvloo.dev.insuranceMotorPolicy.service;

import com.cvloo.dev.insuranceMotorPolicy.domain.MotorPolicy;
import com.cvloo.dev.insuranceMotorPolicy.domain.MotorPolicy;
import com.cvloo.dev.insuranceMotorPolicy.repository.MotorPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorPolicyService {

//    @Autowired
//    private MotorPolicyRepository motorPolicyRepository;
    private final MotorPolicyRepository motorPolicyRepository;

    @Autowired
    public MotorPolicyService(MotorPolicyRepository motorPolicyRepository) {
        this.motorPolicyRepository = motorPolicyRepository;
    }

    public List<MotorPolicy> getAllMotorPolicies() {
        return motorPolicyRepository.findAll();
    }

    public Optional<MotorPolicy> getMotorPolicyById(Long id) {
        return motorPolicyRepository.findById(id);
    }

    public MotorPolicy createMotorPolicy(MotorPolicy motorPolicy) {

        //Validation: 'PeriodFrom' not larger than 'PeriodTo'
        if (motorPolicy.getPeriodFrom().isAfter(motorPolicy.getPeriodTo())) {
            throw new RuntimeException("PeriodFrom cannot be after PeriodTo");
        }

        return motorPolicyRepository.save(motorPolicy);
    }

    public MotorPolicy updateMotorPolicy(Long id, MotorPolicy motorPolicy) {
        Optional<MotorPolicy> existingPolicy = motorPolicyRepository.findById(id);
        if (existingPolicy.isPresent()) {
            MotorPolicy policyToUpdate = existingPolicy.get();
            policyToUpdate.setPolicyStatus(motorPolicy.getPolicyStatus());
            // Set other fields
            return motorPolicyRepository.save(policyToUpdate);
        } else {
            return null;
        }
    }

    public void deleteMotorPolicy(Long id) {
        motorPolicyRepository.deleteById(id);
    }
}
