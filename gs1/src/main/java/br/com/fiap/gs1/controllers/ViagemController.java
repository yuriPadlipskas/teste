package br.com.fiap.gs1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.gs1.models.ViagemMarte;
import br.com.fiap.gs1.repositories.ViagemMarteRepository;
import br.com.fiap.gs1.services.ViagemMarteService;


@Controller
public class ViagemController extends ViagemMarteService{
	
	@Autowired
	private ViagemMarteRepository viagemMarteRepository;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("index");
		List<ViagemMarte> viagensMarte = viagemMarteRepository.findAll();
		modelView.addObject("viagensMarte",viagensMarte);
		return modelView;
	}
	
	@GetMapping("/criar")
	public ModelAndView criar() {
		ModelAndView modelView = new ModelAndView("criar");
		modelView.addObject("viagemMarte",new ViagemMarte());
		return modelView;
	}
	@PostMapping("/criar")
	public ModelAndView salvar(@ModelAttribute("viagemMarte")ViagemMarte viagemMarte, BindingResult br) {
		if(!isMultipleThree(viagemMarte.getAssentos()) || br.hasErrors()) {
			return new ModelAndView("redirect:/erro");
		}
		viagemMarte.setDataRetorno(calculaDataRetornoTerra(viagemMarte.getDataDecolagem()));
		viagemMarteRepository.save(viagemMarte);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/deletar")
	public ModelAndView telaDeletar() {
		ModelAndView modelView = new ModelAndView("deletar");
		modelView.addObject("viagemMarte",new ViagemMarte());
		return modelView;
	}
	
	@DeleteMapping("/deletar")
	public ModelAndView deletar(ViagemMarte viagemMarte) {
		viagemMarteRepository.deleteById(viagemMarte.getId());
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/alterar")
	public ModelAndView telaAlterar() {
		ModelAndView modelView = new ModelAndView("alterar");
		modelView.addObject("viagemMarte",new ViagemMarte());
		return modelView;
	}
	@GetMapping("/erro")
	public ModelAndView telaErro() {
		return new ModelAndView("erro");
	}
	
	@PutMapping("/alterar")
	public ModelAndView alterar(ViagemMarte viagemMarte) {
		viagemMarteRepository.save(alterarViagem(viagemMarteRepository, viagemMarte));
		return new ModelAndView("redirect:/");
	}
}
