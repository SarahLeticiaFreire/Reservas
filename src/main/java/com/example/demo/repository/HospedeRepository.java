package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {

    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.hospede.id = :hospedeId AND r.dataFim >= CURRENT_DATE")
    int countReservasAtivasPorHospede(@Param("hospedeId") Long hospedeId);
}
