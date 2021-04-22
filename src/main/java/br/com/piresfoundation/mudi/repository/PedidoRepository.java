package br.com.piresfoundation.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.piresfoundation.mudi.models.Pedido;
import br.com.piresfoundation.mudi.models.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);
	
	@Query("SELECT p FROM Pedido AS p join p.user AS u WHERE u.username =:username")
	List<Pedido> findAllByUser(@Param("username") String username);

	@Query("SELECT p FROM Pedido AS p join p.user AS u WHERE u.username =:username AND p.status = :status")
	List<Pedido> findByStatusAndUsuario(@Param("status")StatusPedido status, @Param("username")String username);
}
