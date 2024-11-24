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

import ifsp.vitaesangue.model.Descarte;
import ifsp.vitaesangue.repository.DescarteRepository;

@RestController
@RequestMapping("/descarte")
public class DescarteController {

	@Autowired
	private DescarteRepository descarteRepository;
	
	@GetMapping
	public List<Descarte> getAll() {
		
		return descarteRepository.findAll();
	}
	
	@PostMapping
	public Descarte create(@RequestBody Descarte descarte) {
		
		descarteRepository.save(descarte);
		return descarte;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		descarteRepository.deleteById(id);
	}
}
