package br.com.piresfoundation.mudi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.piresfoundation.mudi.models.Pedido;

@Repository
public class PedidoRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Pedido> buscarTodosOsPedidos() {
		String query = "SELECT p FROM Pedido AS p";
		return this.entityManager.createQuery(query, Pedido.class).getResultList();
	}
}
