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

import ifsp.vitaesangue.annotations.RequiredPermission;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.model.Utilizacao;
import ifsp.vitaesangue.repository.UtilizacaoRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/utilizacao")
public class UtilizacaoController {

	@Autowired
	private UtilizacaoRepository utilizacaoRepository;
	
	@GetMapping
	@RequiredPermission(resource = ResourcesAllow.BOLSA_UTILIZACAO, action = TipoAcaoHistorico.READ)
	public List<Utilizacao> getAll() {
		
		return utilizacaoRepository.findAll();
	}
	
	@PostMapping
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.BOLSA_UTILIZACAO, action = TipoAcaoHistorico.CREATE)
	public Utilizacao create(@RequestBody Utilizacao utilizacao) {
		
		utilizacaoRepository.save(utilizacao);
		return utilizacao;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.BOLSA_UTILIZACAO, action = TipoAcaoHistorico.DELETE)
	public void delete(@PathVariable("id") Long id) {
		
		utilizacaoRepository.deleteById(id);
	}
}
