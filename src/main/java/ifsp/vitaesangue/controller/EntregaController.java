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

import ifsp.vitaesangue.model.Entrega;
import ifsp.vitaesangue.repository.EntregaRepository;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@GetMapping
	public List<Entrega> getAll() {
		
		return entregaRepository.findAll();
	}
	
	@PostMapping
	public Entrega entrega(@RequestBody Entrega entrega) {
		
		entregaRepository.save(entrega);
		return entrega;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		entregaRepository.deleteById(id);
	}
	
}