package com.cvloo.dev.insuranceMotorPolicy.repository;

import com.cvloo.dev.insuranceMotorPolicy.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
