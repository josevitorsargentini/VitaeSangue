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

import ifsp.vitaesangue.model.Hemocentro;
import ifsp.vitaesangue.model.Hospital;
import ifsp.vitaesangue.model.Requisicao;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.records.requisicao.RequisicaoRequest;
import ifsp.vitaesangue.records.requisicao.RequisicaoResponse;
import ifsp.vitaesangue.records.requisicao.RequisicaoUpdate;
import ifsp.vitaesangue.repository.HemocentroRepository;
import ifsp.vitaesangue.repository.HospitalRepository;
import ifsp.vitaesangue.repository.RequisicaoRepository;
import ifsp.vitaesangue.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RequisicaoRepository requisicaoRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private HemocentroRepository hemocentroRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<Page<RequisicaoResponse>> getAll(@PageableDefault(size = 10) Pageable pageable) {
		var page = requisicaoRepository.findAll(pageable).map(requisicao -> modelMapper.map(requisicao, RequisicaoResponse.class));
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RequisicaoResponse> getById(@PathVariable("id") Long id) {
		Requisicao requisicao = requisicaoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Requisição não encontrada"));

		RequisicaoResponse requisicaoResponse = modelMapper.map(requisicao, RequisicaoResponse.class);
		
		return ResponseEntity.ok().body(requisicaoResponse);
	}
	
	@Transactional
	@PostMapping
	public ResponseEntity<RequisicaoResponse> create(@RequestBody RequisicaoRequest requisicaoRequest) {
		
		Requisicao requisicao = modelMapper.map(requisicaoRequest, Requisicao.class);
		
		Hospital hospital = hospitalRepository.findById(requisicaoRequest.getHospitalId())
				.orElseThrow(() -> new RuntimeException("Hospital não encontrado"));
		
		requisicao.setHospital(hospital);
		
		Hemocentro hemocentro = hemocentroRepository.findById(requisicaoRequest.getHemocentroId())
				.orElseThrow(() -> new RuntimeException("Hemocentro não encontrado"));
		
		requisicao.setHemocentro(hemocentro);
		
		if (requisicaoRequest.getUsuarioRequeridoId() != 0) {
			Usuario usuarioRequerido = usuarioRepository.findById(requisicaoRequest.getUsuarioRequeridoId())
					.orElseThrow(() -> new RuntimeException("Usuário requerido não encontrado"));
			
			requisicao.setUsuarioRequerido(usuarioRequerido);
	    }
		
		Usuario usuarioRequerimento = usuarioRepository.findById(requisicaoRequest.getUsuarioRequerimentoId())
				.orElseThrow(() -> new RuntimeException("Usuário requerente não encontrado"));
		
		requisicao.setUsuarioRequerimento(usuarioRequerimento);
		
		Requisicao requisicaoEntity = requisicaoRepository.save(requisicao);
		
		return ResponseEntity.ok().body(modelMapper.map(requisicaoEntity, RequisicaoResponse.class));
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<RequisicaoResponse> edit(@PathVariable("id") Long id, @RequestBody RequisicaoUpdate requisicaoUpdate) {
		
		if (!id.equals(requisicaoUpdate.getId())) {
	        throw new RuntimeException("Os ID's informados nao correspondem");
	    }
		
	    return requisicaoRepository.findById(requisicaoUpdate.getId())
	        .map(requisicaoEntity -> {
	        	
	        	Usuario usuarioRequerido = usuarioRepository.findById(requisicaoUpdate.getUsuarioRequeridoId())
	    				.orElseThrow(() -> new RuntimeException("Usuário requerido não encontrado"));
	    		
	            modelMapper.map(requisicaoUpdate, requisicaoEntity);
	            
	            requisicaoEntity.setUsuarioRequerido(usuarioRequerido);

	        	Requisicao requisicaoSaved = requisicaoRepository.save(requisicaoEntity);
	            return ResponseEntity.ok().body(modelMapper.map(requisicaoSaved, RequisicaoResponse.class));
	        })
	        .orElseThrow(() -> new RuntimeException("Requisição não encontrada"));
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		requisicaoRepository.deleteById(id);
	}
}
