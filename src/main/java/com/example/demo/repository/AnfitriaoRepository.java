package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Anfitriao;

public interface AnfitriaoRepository extends JpaRepository<Anfitriao, Long> {

    @Query("SELECT COUNT(a) FROM Acomodacao a WHERE a.anfitriao.id = :anfitriaoId")
    int countAcomodacoesDisponibilizadasPorAnfitriao(@Param("anfitriaoId") Long anfitriaoId);
}
