package ifsp.vitaesangue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.vitaesangue.model.SolicitacaoAcesso;
import ifsp.vitaesangue.repository.SolicitacaoAcessoRepository;

@RestController
@RequestMapping("/solicitacaoacesso")
public class SolicitacaoAcessoController {
	@Autowired
	private SolicitacaoAcessoRepository solicitacaoAcessoRepository;
	
	@GetMapping
	public List<SolicitacaoAcesso> getAll() {
		
		return solicitacaoAcessoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SolicitacaoAcesso> getById(@PathVariable("id") Long id) { 
		return solicitacaoAcessoRepository.findById(id) .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public SolicitacaoAcesso create(@RequestBody SolicitacaoAcesso solitacao) {
		solicitacaoAcessoRepository.save(solitacao);
		return solitacao;
	}
	
	
}
