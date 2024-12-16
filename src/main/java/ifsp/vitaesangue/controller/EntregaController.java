package ifsp.vitaesangue.controller;

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

import ifsp.vitaesangue.model.Entrega;
import ifsp.vitaesangue.model.Requisicao;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.records.entrega.EntregaRequest;
import ifsp.vitaesangue.records.entrega.EntregaResponse;
import ifsp.vitaesangue.records.entrega.EntregaUpdate;
import ifsp.vitaesangue.repository.EntregaRepository;
import ifsp.vitaesangue.repository.RequisicaoRepository;
import ifsp.vitaesangue.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RequisicaoRepository requisicaoRepository;
	
	@GetMapping
	public ResponseEntity<Page<EntregaResponse>> getAll(@PageableDefault(size = 10) Pageable pageable) {
		var page = entregaRepository.findAll(pageable).map(entrega -> modelMapper.map(entrega, EntregaResponse.class));
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaResponse> getById(@PathVariable("id") Long id) {
	    Entrega entrega = entregaRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));

	    EntregaResponse entregaResponse = modelMapper.map(entrega, EntregaResponse.class);

	    return ResponseEntity.ok().body(entregaResponse);
	}

	
	@Transactional
	@PostMapping
	public ResponseEntity<EntregaResponse> create(@RequestBody EntregaRequest entregaRequest) {
		
		Entrega entrega = modelMapper.map(entregaRequest, Entrega.class);
		
		Requisicao requisicao = requisicaoRepository.findById(entregaRequest.getRequisicaoId())
				.orElseThrow(() -> new RuntimeException("Requisição não encontrada"));
		
		entrega.setRequisicao(requisicao);
		
		if (entregaRequest.getUsuarioRecebedorId() != 0) {
			Usuario usuarioRecebedor = usuarioRepository.findById(entregaRequest.getUsuarioRecebedorId())
					.orElseThrow(() -> new RuntimeException("Usuário recebedor não encontrado"));
			
			entrega.setUsuarioRecebedor(usuarioRecebedor);
	    }
		
		Usuario usuarioAprovador = usuarioRepository.findById(entregaRequest.getUsuarioAprovadorId())
				.orElseThrow(() -> new RuntimeException("Usuário aprovador não encontrado"));
		
		entrega.setUsuarioAprovador(usuarioAprovador);
		
		Entrega entregaEntity = entregaRepository.save(entrega);
		
		return ResponseEntity.ok().body(modelMapper.map(entregaEntity, EntregaResponse.class));
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<EntregaResponse> edit(@PathVariable("id") Long id, @RequestBody EntregaUpdate entregaUpdate) {
		
		if (!id.equals(entregaUpdate.getId())) {
	        throw new RuntimeException("Os ID's informados nao correspondem");
	    }
		
	    return entregaRepository.findById(entregaUpdate.getId())
	        .map(entregaEntity -> {
	        	
	        	Usuario usuarioRecebedor = usuarioRepository.findById(entregaUpdate.getUsuarioRecebedorId())
	    				.orElseThrow(() -> new RuntimeException("Usuário recebedor não encontrado"));
	    		
	            modelMapper.map(entregaUpdate, entregaEntity);
	            
	            entregaEntity.setUsuarioRecebedor(usuarioRecebedor);

	            Entrega entregaSaved = entregaRepository.save(entregaEntity);
	            return ResponseEntity.ok().body(modelMapper.map(entregaSaved, EntregaResponse.class));
	        })
	        .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		entregaRepository.deleteById(id);
	}
	
}
