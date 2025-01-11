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
import ifsp.vitaesangue.model.BolsaRequisicao;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.repository.BolsaRequisicaoRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/bolsarequisicao")
public class BolsaRequisicaoController {

	@Autowired
	private BolsaRequisicaoRepository bolsaRequisicaoRepository;
	
	@GetMapping
	@RequiredPermission(resource = ResourcesAllow.BOLSA_REQUISICAO, action = TipoAcaoHistorico.READ)
	public List<BolsaRequisicao> getAll() {

		return bolsaRequisicaoRepository.findAll();
	}
	
	@PostMapping
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.BOLSA_REQUISICAO, action = TipoAcaoHistorico.CREATE)
	public BolsaRequisicao bolsaRequisicao(@RequestBody BolsaRequisicao bolsaRequisicao) {
		
		bolsaRequisicaoRepository.save(bolsaRequisicao);
		return bolsaRequisicao;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.BOLSA_REQUISICAO, action = TipoAcaoHistorico.DELETE)
	public void delete(@PathVariable("id") Long id) {
		
		bolsaRequisicaoRepository.deleteById(id);
	}
}
