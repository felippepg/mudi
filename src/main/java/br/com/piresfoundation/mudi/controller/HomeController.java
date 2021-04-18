package br.com.piresfoundation.mudi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomePedido("Console PlayStation®5");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/51n%2B6VOTGrL._AC_SL1000_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/PlayStation-Console-PlayStation%C2%AE5/dp/B088GNRX3J");
		
		List<Pedido> pedidos = List.of(pedido);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
}
