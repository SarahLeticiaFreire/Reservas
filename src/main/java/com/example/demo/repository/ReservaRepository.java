package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.demo.domain.Hospede;
import com.example.demo.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByHospede(Hospede hospede);
}
