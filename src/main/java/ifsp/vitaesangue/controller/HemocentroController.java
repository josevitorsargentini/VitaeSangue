package ifsp.vitaesangue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Hemocentro;
import ifsp.vitaesangue.repository.EstabelecimentoRepository;
import ifsp.vitaesangue.repository.HemocentroRepository;

@RestController
@RequestMapping("/hemocentro")
public class HemocentroController {
	
	@Autowired
	private HemocentroRepository hemocentroRepository;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@GetMapping
	public List<Hemocentro> getAll() {
		
		return hemocentroRepository.findAll();
	}
	
	@PostMapping
	public Hemocentro create(@RequestBody Hemocentro hemocentro) {
		Estabelecimento estabelecimento = estabelecimentoRepository.findById(hemocentro.getEstabelecimento().getId())
				.orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

		hemocentro.setEstabelecimento(estabelecimento);
		
		hemocentroRepository.save(hemocentro);
		return hemocentro;
	}
	
}
