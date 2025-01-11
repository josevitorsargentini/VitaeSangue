package ifsp.vitaesangue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.vitaesangue.annotations.RequiredPermission;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.records.usuario.UsuarioResponse;
import ifsp.vitaesangue.repository.PerfilRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@GetMapping
	@RequiredPermission(resource = ResourcesAllow.PERFIL, action = TipoAcaoHistorico.READ)
	public ResponseEntity<Page<Perfil>>  getAll(@PageableDefault(size = 10) Pageable pageable) {
		return ResponseEntity.ok().body(perfilRepository.findAll(pageable));
	}

	
	@GetMapping("/{id}")
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.PERFIL, action = TipoAcaoHistorico.READ)
	public ResponseEntity<Perfil> getById(@PathVariable("id") Long id) { 
		return perfilRepository.findById(id) .map(ResponseEntity::ok).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
	}
	
	@PostMapping
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.PERFIL, action = TipoAcaoHistorico.CREATE)
	public  ResponseEntity<Perfil> create(@RequestBody Perfil perfilRequest) {
		return ResponseEntity.ok().body(perfilRepository.save(perfilRequest));
	}
	
	@PutMapping()
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.PERFIL, action = TipoAcaoHistorico.UPDATE)
	public ResponseEntity<Perfil> edit(@RequestBody Perfil perfil) {
	    return perfilRepository.findById(perfil.getId())
	      .map(perfilEntity -> {
	    	perfilEntity.setNome(perfil.getNome());
	        return ResponseEntity.ok().body(perfilRepository.save(perfilEntity));
	      }).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
	 }

	@Transactional
	@DeleteMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.PERFIL, action = TipoAcaoHistorico.DELETE)
	public void delete(@PathVariable("id") Long id) {
		perfilRepository.deleteById(id);
	}
}
