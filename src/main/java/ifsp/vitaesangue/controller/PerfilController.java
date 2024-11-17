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

import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.repository.PerfilRepository;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@GetMapping
	public List<Perfil> getAll() {
		
		return perfilRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Perfil> getById(@PathVariable("id") Long id) { 
		return perfilRepository.findById(id) .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Perfil create(@RequestBody Perfil perfil) {
		perfilRepository.save(perfil);
		return perfil;
	}
	
	@PutMapping()
	public Perfil edit(@RequestBody Perfil perfil) {
	    
	    return perfilRepository.findById(perfil.getPerfilId())
	      .map(perfilEntity -> {
	    	perfilEntity.setNome(perfil.getNome());
	        return perfilRepository.save(perfilEntity);
	      })
	      .orElseGet(() -> {
	        return perfilRepository.save(perfil);
	      });
	 }

}
