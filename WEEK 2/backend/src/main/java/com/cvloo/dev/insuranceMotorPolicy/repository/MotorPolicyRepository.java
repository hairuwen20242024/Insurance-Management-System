package com.cvloo.dev.insuranceMotorPolicy.repository;

import com.cvloo.dev.insuranceMotorPolicy.domain.MotorPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorPolicyRepository extends JpaRepository<MotorPolicy, Long> {
}
