package br.com.piresfoundation.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private PedidoRepository repository;

	@GetMapping("pedidos")
	public String home(Model model, Principal principal) {
		List<Pedido> pedidos = repository.findAllByUser(principal.getName());

		model.addAttribute("pedidos", pedidos);
		return "usuario/home";
	}

	@GetMapping("pedidos/{status}")
	public String byStatus(@PathVariable String status, Model model, Principal principal) {
		List<Pedido> pedidos = repository.findByStatusAndUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "usuario/home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String error() {
		return "redirect:/usuario//home";
	}
}
