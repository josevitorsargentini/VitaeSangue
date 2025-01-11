package ifsp.vitaesangue.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
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
import ifsp.vitaesangue.config.SecurityConfiguration;
import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.records.usuario.UsuarioRequest;
import ifsp.vitaesangue.records.usuario.UsuarioResponse;
import ifsp.vitaesangue.records.usuario.UsuarioUpdate;
import ifsp.vitaesangue.repository.EstabelecimentoRepository;
import ifsp.vitaesangue.repository.PerfilRepository;
import ifsp.vitaesangue.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
    @Autowired
    private SecurityConfiguration securityConfiguration;

	@GetMapping
	@RequiredPermission(resource = ResourcesAllow.USUARIO, action = TipoAcaoHistorico.READ)
	public ResponseEntity<Page<UsuarioResponse>> getAll(@PageableDefault(size = 10) Pageable pageable) {
		var page = usuarioRepository.findAll(pageable).map(usuario -> modelMapper.map(usuario, UsuarioResponse.class));
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.USUARIO, action = TipoAcaoHistorico.READ)
	public ResponseEntity<UsuarioResponse> getById(@PathVariable("id") Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		UsuarioResponse usuarioResponse = modelMapper.map(usuario, UsuarioResponse.class);

		return ResponseEntity.ok().body(usuarioResponse);
	}

	@Transactional
	@PostMapping
	@RequiredPermission(resource = ResourcesAllow.USUARIO, action = TipoAcaoHistorico.CREATE)
	public ResponseEntity<UsuarioResponse> create(@RequestBody UsuarioRequest usuarioRequest) {

		Usuario usuario = modelMapper.map(usuarioRequest, Usuario.class);

		Estabelecimento estabelecimento = estabelecimentoRepository.findById(usuarioRequest.getEstabelecimentoId())
				.orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

		usuario.setEstabelecimento(estabelecimento);

		Perfil perfil = perfilRepository.findById(usuarioRequest.getPerfilId())
				.orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

		usuario.setPerfil(perfil);
		
		usuario.setSenha(gerarHashSenha(usuarioRequest.getSenha()));

		Usuario usuarioEntity = usuarioRepository.save(usuario);

		return ResponseEntity.ok().body(modelMapper.map(usuarioEntity, UsuarioResponse.class));
	}
	
	@Transactional
	@PutMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.USUARIO, action = TipoAcaoHistorico.UPDATE)
	public ResponseEntity<UsuarioResponse> edit(@PathVariable("id") Long id, @RequestBody UsuarioUpdate usuarioUpdate) {
		
		if (!id.equals(usuarioUpdate.getId())) {
	        throw new RuntimeException("Os ID's informados nao correspondem");
	    }
		
	    return usuarioRepository.findById(usuarioUpdate.getId())
	        .map(usuarioEntity -> {
	            // Busca as entidades
	            Estabelecimento estabelecimento = estabelecimentoRepository.findById(usuarioUpdate.getEstabelecimentoId())
	                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));
	            
	            Perfil perfil = perfilRepository.findById(usuarioUpdate.getPerfilId())
	                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
	            
	            // Usa o mapper configurado
	            modelMapper.map(usuarioUpdate, usuarioEntity);
	            
	            // Define manualmente as relações
	            usuarioEntity.setEstabelecimento(estabelecimento);
	            usuarioEntity.setPerfil(perfil);
	            
	            usuarioEntity.setSenha(gerarHashSenha(usuarioUpdate.getSenha()));

	            Usuario usuarioSaved = usuarioRepository.save(usuarioEntity);
	            return ResponseEntity.ok().body(modelMapper.map(usuarioSaved, UsuarioResponse.class));
	        })
	        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.USUARIO, action = TipoAcaoHistorico.DELETE)
	public void delete(@PathVariable("id") Long id) {

		usuarioRepository.deleteById(id);

	}
	
	private String gerarHashSenha(String senha) {
		return securityConfiguration.passwordEncoder().encode(senha);
	}

}
