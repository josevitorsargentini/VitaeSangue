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

import ifsp.vitaesangue.model.BolsaEntrega;
import ifsp.vitaesangue.repository.BolsaEntregaRepository;

@RestController
@RequestMapping("/bolsaentrega")
public class BolsaEntregaController {
	
	@Autowired
	private BolsaEntregaRepository bolsaEntregaRepository;
	
	@GetMapping
	public List<BolsaEntrega> getAll() {
		
		return bolsaEntregaRepository.findAll();
	}
	
	@PostMapping
	public BolsaEntrega bolsaEntrega(@RequestBody BolsaEntrega bolsaEntrega) {
		
		bolsaEntregaRepository.save(bolsaEntrega);
		return bolsaEntrega;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		bolsaEntregaRepository.deleteById(id);
	}
}
