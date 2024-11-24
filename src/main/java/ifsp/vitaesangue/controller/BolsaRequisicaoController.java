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

import ifsp.vitaesangue.model.BolsaRequisicao;
import ifsp.vitaesangue.repository.BolsaRequisicaoRepository;

@RestController
@RequestMapping("/bolsarequisicao")
public class BolsaRequisicaoController {

	@Autowired
	private BolsaRequisicaoRepository bolsaRequisicaoRepository;
	
	@GetMapping
	public List<BolsaRequisicao> getAll() {
		
		return bolsaRequisicaoRepository.findAll();
	}
	
	@PostMapping
	public BolsaRequisicao bolsaRequisicao(@RequestBody BolsaRequisicao bolsaRequisicao) {
		
		bolsaRequisicaoRepository.save(bolsaRequisicao);
		return bolsaRequisicao;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		bolsaRequisicaoRepository.deleteById(id);
	}
}
