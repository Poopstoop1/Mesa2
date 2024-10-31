package com.project.Mesa.Controller;

import com.project.Mesa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/usuarios")
	public String user(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();


		if(username != null){
			String nomeFormatado = formatarNome(username);
			model.addAttribute("message", nomeFormatado);
		}

		return "/paginas/gestaodeusuarios";
	}

	private String formatarNome(String username) {
		// Divide o nome em letras maiúsculas e minúsculas
		// Exemplo: "ErysonMoreira" -> "Eryson Moreira"
		return username.replaceAll("([a-z])([A-Z])", "$1 $2");
	}
}
