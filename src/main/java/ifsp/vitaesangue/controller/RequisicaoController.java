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

import ifsp.vitaesangue.model.Requisicao;
import ifsp.vitaesangue.repository.RequisicaoRepository;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {
	
	@Autowired
	private RequisicaoRepository requisicaoRepository;
	
	@GetMapping
	public List<Requisicao> getAll() {
		
		return requisicaoRepository.findAll();
	}
	
	@PostMapping
	public Requisicao requisicao(@RequestBody Requisicao requisicao) {
		
		requisicaoRepository.save(requisicao);
		return requisicao;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		requisicaoRepository.deleteById(id);
	}
}
