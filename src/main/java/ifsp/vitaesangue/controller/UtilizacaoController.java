package ifsp.vitaesangue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.vitaesangue.model.Utilizacao;
import ifsp.vitaesangue.repository.UtilizacaoRepository;

@RestController
@RequestMapping("/utilizacao")
public class UtilizacaoController {

	@Autowired
	private UtilizacaoRepository utilizacaoRepository;
	
	@GetMapping
	public List<Utilizacao> getAll() {
		
		return utilizacaoRepository.findAll();
	}
	
	@PostMapping
	public Utilizacao create(@RequestBody Utilizacao utilizacao) {
		
		utilizacaoRepository.save(utilizacao);
		return utilizacao;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		utilizacaoRepository.deleteById(id);
	}
}
