package br.com.piresfoundation.mudi.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.piresfoundation.mudi.models.Pedido;
import br.com.piresfoundation.mudi.repository.PedidoRepository;

@Controller
public class HomeController {

	@Autowired
	private PedidoRepository repository;

	@GetMapping("/home")
	public String home(Model model) {
		List<Pedido> pedidos = repository.buscarTodosOsPedidos();
		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}
