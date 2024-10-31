package com.project.Mesa.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class FilialController {
	
	
	
	@RequestMapping("/filial")
	public String filial(Model model) {	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();


		if(username != null){
			String nomeFormatado = formatarNome(username);
			model.addAttribute("message", nomeFormatado);
		}
		return "/paginas/gestaodefiliais";
	}
	
	private String formatarNome(String username) {
		// Divide o nome em letras maiúsculas e minúsculas
		// Exemplo: "ErysonMoreira" -> "Eryson Moreira"
		return username.replaceAll("([a-z])([A-Z])", "$1 $2");
	}
	/*
	@RequestMapping(method = RequestMethod.POST, value = "/salvarfiliais")
	public ModelAndView salvar(@ModelAttribute filial filiais) {
		ModelAndView modelview = new ModelAndView("paginas/filial");
		filialrepository.save(filiais);
		
		modelview.addObject("filialobj", new filial());
		return modelview;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listarfiliais")
	public ModelAndView listar() {
		ModelAndView modelview = new ModelAndView("paginas/filial");
		Iterable<filial> filiais = filialrepository.findAll();
		
		modelview.addObject("filiais", filiais);
		modelview.addObject("filialobj", new filial());
		
		return modelview;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/editarfilial/{cnpjfilial}")
	public ModelAndView editar(@PathVariable("cnpjfilial") String cnpj) {
		Optional<filial> filial = filialrepository.findById(cnpj);
		ModelAndView modelview = new ModelAndView("paginas/filial");
		if (filial.isPresent()) {
			modelview.addObject("filialobj", filial.get());
		} else {
			// Adicionar uma mensagem de erro ao modelo
			modelview = new ModelAndView("redirect:/listarfiliais");
			modelview.addObject("errorMessage", "Usuário não encontrado!");
		}

		return modelview;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/removerfilial/{cnpjfilial}")
	public ModelAndView excluir(@PathVariable("cnpjfilial") String cnpj) {
		filialrepository.deleteById(cnpj);
		
		ModelAndView modelview = new ModelAndView("paginas/filial");
		modelview.addObject("filiais", filialrepository.findAll());
		modelview.addObject("filialobj", new filial());
		return modelview;
	}
	*/

}
