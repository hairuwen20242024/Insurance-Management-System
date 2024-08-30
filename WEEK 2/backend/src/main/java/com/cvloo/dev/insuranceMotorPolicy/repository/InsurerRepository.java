package com.cvloo.dev.insuranceMotorPolicy.repository;

import com.cvloo.dev.insuranceMotorPolicy.domain.Insurer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurerRepository extends JpaRepository<Insurer, Long> {
}
