package br.com.piresfoundation.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.piresfoundation.mudi.models.Pedido;
import br.com.piresfoundation.mudi.models.StatusPedido;
import br.com.piresfoundation.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository repository;

	@GetMapping
	public String home(Model model) {
		
		// ordenação dos pedidos
		Sort descending = Sort.by("dataEntrega").descending();
		
		PageRequest paginacao = PageRequest.of(0, 2, descending);
		
		List<Pedido> pedidos = repository.findByStatus(StatusPedido.ENTREGUE, paginacao);

		model.addAttribute("pedidos", pedidos);
		return "home";
	}

	@GetMapping("/{status}")
	public String byStatus(@PathVariable String status, Model model) {
		Sort descending = Sort.by("dataEntrega").descending();
		
		PageRequest paginacao = PageRequest.of(0, 2, descending); 
		
		List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()), paginacao);
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String error() {
		return "redirect:/home";
	}
}
