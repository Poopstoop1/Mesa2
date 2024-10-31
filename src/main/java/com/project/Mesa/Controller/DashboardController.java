package com.project.Mesa.Controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.RequestMapping;






@Controller
public class DashboardController {
	

	@RequestMapping("/")
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		System.out.println("Username: " + username);
		System.out.println("Authorities: " + auth.getAuthorities());
		// Adiciona o nome do usuário ao modelo
		if (username != null) {
			// Separar o nome e sobrenome
			String nomeFormatado = formatarNome(username);
			model.addAttribute("message", nomeFormatado);
		}

		if (auth != null && auth.isAuthenticated()) {
			// Lógica existente
			return "dashboard"; 
		}
		// Se não autenticado, redirecione para login
		return "redirect:/login";
	}
	
	

	private String formatarNome(String username) {
		// Divide o nome em letras maiúsculas e minúsculas
		// Exemplo: "ErysonMoreira" -> "Eryson Moreira"
		return username.replaceAll("([a-z])([A-Z])", "$1 $2");
	}

	/*@RequestMapping(method = RequestMethod.GET, value = "/cadastrousuarios")
	public ModelAndView cadastro() {
		ModelAndView modelview = new ModelAndView("paginas/cadastrousuarios");
		modelview.addObject("usuarioobj", new Users());
		return modelview;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/salvarusuarios")
	public ModelAndView salvar(@ModelAttribute Users usuarios) {
		
		ModelAndView modelview = new ModelAndView("paginas/cadastrousuarios");
		// Salva um novo usuário
	
		userRepository.save(usuarios);
		
		modelview.addObject("usuarioobj", new Users());
		return modelview;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listarusuarios")
	public ModelAndView listar() {
		ModelAndView modelview = new ModelAndView("paginas/cadastrousuarios");
		Iterable<Users> usuarios = userRepository.findAll();
		
		modelview.addObject("usuarios", usuarios);
		modelview.addObject("usuarioobj", new Users());
		
		return modelview;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editarusuario/{idusuario}")
	public ModelAndView editar(@PathVariable("idusuario") Long idusuario) {
		Optional<Users> usuario = userRepository.findById(idusuario);
		ModelAndView modelview = new ModelAndView("paginas/cadastrousuarios");
		if (usuario.isPresent()) {
			modelview.addObject("usuarioobj", usuario.get());
		} else {
			// Adicionar uma mensagem de erro ao modelo
			modelview = new ModelAndView("redirect:/listarusuarios");
			modelview.addObject("errorMessage", "Usuário não encontrado!");
		}

		return modelview;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/removerusuario/{idusuario}")
	public ModelAndView excluir(@PathVariable("idusuario") Long idusuario) {
		userRepository.deleteById(idusuario);
		
		ModelAndView modelview = new ModelAndView("paginas/cadastrousuarios");
		modelview.addObject("usuarios", userRepository.findAll());
		modelview.addObject("usuarioobj", new Users());
		return modelview;
	}
*/

	
	
}
