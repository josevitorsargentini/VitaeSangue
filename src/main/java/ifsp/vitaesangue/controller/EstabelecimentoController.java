package ifsp.vitaesangue.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.repository.EstabelecimentoRepository;


@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@GetMapping
	public List<Estabelecimento> getAll() {
		
		return estabelecimentoRepository.findAll();
	}
	
	@PostMapping
	public Estabelecimento create(@RequestBody Estabelecimento estabelecimento) {
		
		estabelecimento.setAtivo(false);
		estabelecimentoRepository.save(estabelecimento);
		return estabelecimento;
	}
}
