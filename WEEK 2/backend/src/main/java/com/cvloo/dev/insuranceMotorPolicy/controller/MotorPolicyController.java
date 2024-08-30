package com.cvloo.dev.insuranceMotorPolicy.controller;

import com.cvloo.dev.insuranceMotorPolicy.domain.MotorPolicy;
import com.cvloo.dev.insuranceMotorPolicy.service.MotorPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/motor-policies")
public class MotorPolicyController {

    @Autowired
    private MotorPolicyService motorPolicyService;

    @GetMapping
    public List<MotorPolicy> getAllMotorPolicies() {
        return motorPolicyService.getAllMotorPolicies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotorPolicy> getMotorPolicyById(@PathVariable Long id) {
        Optional<MotorPolicy> motorPolicy = motorPolicyService.getMotorPolicyById(id);
        return motorPolicy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


//    @PostMapping
//    public MotorPolicy createMotorPolicy(@Valid @RequestBody MotorPolicy motorPolicy) {
//        System.out.println("MotorPolicy received: " + motorPolicy);
//        return motorPolicyService.createMotorPolicy(motorPolicy);
//    }

    @PostMapping
    public ResponseEntity<MotorPolicy> createMotorPolicy(@Valid @RequestBody MotorPolicy motorPolicy) {
        MotorPolicy createdPolicy = motorPolicyService.createMotorPolicy(motorPolicy);
        return ResponseEntity.ok(createdPolicy);
    }



    @PutMapping("/{id}")
    public ResponseEntity<MotorPolicy> updateMotorPolicy(@PathVariable Long id, @Valid @RequestBody MotorPolicy motorPolicy) {
        MotorPolicy updatedPolicy = motorPolicyService.updateMotorPolicy(id, motorPolicy);
        if (updatedPolicy != null) {
            return ResponseEntity.ok(updatedPolicy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotorPolicy(@PathVariable Long id) {
        motorPolicyService.deleteMotorPolicy(id);
        return ResponseEntity.noContent().build();
    }
}
