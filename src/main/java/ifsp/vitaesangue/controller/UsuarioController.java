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

import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.model.Usuario;
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
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable("id") Long id) { 
		return usuarioRepository.findById(id) .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		Estabelecimento estabelecimento = estabelecimentoRepository.findById(usuario.getEstabelecimento().getId())
                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));
	
		usuario.setEstabelecimento(estabelecimento);
		
		Perfil perfil = perfilRepository.findById(usuario.getPerfil().getPerfilId())
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
	
		usuario.setPerfil(perfil);
		
		usuarioRepository.save(usuario);
		return usuario;
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

}
