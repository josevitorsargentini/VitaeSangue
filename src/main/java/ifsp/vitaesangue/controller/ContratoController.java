package ifsp.vitaesangue.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.vitaesangue.model.Contrato;
import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.repository.ContratoRepository;
import ifsp.vitaesangue.repository.EstabelecimentoRepository;


@RestController
@RequestMapping("/contrato")
public class ContratoController {

	@Autowired
	private ContratoRepository contratoRepository;
	
	@GetMapping
	public List<Contrato> getAll() {
		
		return contratoRepository.findAll();
	}
	
	@PostMapping
	public Contrato create(@RequestBody Contrato contrato) {
		
		contratoRepository.save(contrato);
		return contrato;
	}
	
	@DeleteMapping("/{id}")
	public void  delete(@PathVariable("id") Long id) {
		
		contratoRepository.deleteById(id);
		
	}
}

