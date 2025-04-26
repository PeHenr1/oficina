package br.edu.ifsp.aissa.oficina.repository;

import br.edu.ifsp.aissa.oficina.model.entity.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    List<Conserto> findAllByAtivoTrue();
}