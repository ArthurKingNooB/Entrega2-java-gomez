package com.example.entrega2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entrega2.models.competicion;
import com.example.entrega2.models.competidor;

public interface CompeticionRepository extends JpaRepository<competicion, Long> {

	competicion save(competidor competicion);

}
