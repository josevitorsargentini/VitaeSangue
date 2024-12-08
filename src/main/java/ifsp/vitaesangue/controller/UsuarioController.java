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

import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Hospital;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.records.hospital.HospitalRecord;
import ifsp.vitaesangue.records.hospital.HospitalResponseRecord;
import ifsp.vitaesangue.records.usuario.UsuarioRecord;
import ifsp.vitaesangue.records.usuario.UsuarioResponseRecord;
import ifsp.vitaesangue.repository.EstabelecimentoRepository;
import ifsp.vitaesangue.repository.PerfilRepository;
import ifsp.vitaesangue.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@GetMapping
	public ResponseEntity<Page<UsuarioResponseRecord>> getAll(@PageableDefault(size= 10) Pageable pageable) {
		var page = usuarioRepository.findAll(pageable).map(UsuarioResponseRecord::new);
        return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseRecord> getById(@PathVariable("id") Long id) { 
		Usuario usuario  = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException());
		return ResponseEntity.ok().body(new UsuarioResponseRecord(usuario)) ;
	}
	
	
	@PostMapping
	public ResponseEntity<UsuarioResponseRecord> create(@RequestBody UsuarioRecord usuarioRequest) {
		
		Usuario usuario = Usuario.from(usuarioRequest);
		
		Estabelecimento estabelecimento = estabelecimentoRepository.findById(usuarioRequest.estabelecimentoId())
                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));
	
		usuario.setEstabelecimento(estabelecimento);
		
		Perfil perfil = perfilRepository.findById(usuarioRequest.perfilId())
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
	
		usuario.setPerfil(perfil);
		
		usuarioRepository.save(usuario);
		
		return ResponseEntity.ok().body(new UsuarioResponseRecord(usuario));
	}
	
	@PutMapping()
	public Usuario edit(@RequestBody Usuario usuario) {
	    
	    return usuarioRepository.findById(usuario.getId())
	      .map(usuarioEntity -> {
	    	 usuarioEntity.setNome(usuario.getNome());
	        return usuarioRepository.save(usuarioEntity);
	      })
	      .orElseGet(() -> {
	        return usuarioRepository.save(usuario);
	      });
	 }
	

	@DeleteMapping("/{id}")
	public void  delete(@PathVariable("id") Long id) {
		
		usuarioRepository.deleteById(id);
		
	}

}
