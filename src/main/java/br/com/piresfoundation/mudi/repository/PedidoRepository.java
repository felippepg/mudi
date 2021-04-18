package br.com.piresfoundation.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.piresfoundation.mudi.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
