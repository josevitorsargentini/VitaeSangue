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
import ifsp.vitaesangue.model.BolsaEntrega;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.repository.BolsaEntregaRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/bolsaentrega")
public class BolsaEntregaController {
	
	@Autowired
	private BolsaEntregaRepository bolsaEntregaRepository;
	
	@GetMapping
	@RequiredPermission(resource = ResourcesAllow.BOLSA_ENTREGA, action = TipoAcaoHistorico.READ)
	public List<BolsaEntrega> getAll() {
		
		return bolsaEntregaRepository.findAll();
	}
	
	@PostMapping
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.BOLSA_ENTREGA, action = TipoAcaoHistorico.CREATE)
	public BolsaEntrega bolsaEntrega(@RequestBody BolsaEntrega bolsaEntrega) {
		
		bolsaEntregaRepository.save(bolsaEntrega);
		return bolsaEntrega;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.BOLSA_ENTREGA, action = TipoAcaoHistorico.DELETE)
	public void delete(@PathVariable("id") Long id) {
		
		bolsaEntregaRepository.deleteById(id);
	}
}
