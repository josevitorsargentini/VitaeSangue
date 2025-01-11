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
import ifsp.vitaesangue.model.Contrato;
import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Hemocentro;
import ifsp.vitaesangue.model.Hospital;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.records.contrato.ContratoRequest;
import ifsp.vitaesangue.records.contrato.ContratoResponse;
import ifsp.vitaesangue.records.usuario.UsuarioRequest;
import ifsp.vitaesangue.records.usuario.UsuarioResponse;
import ifsp.vitaesangue.repository.ContratoRepository;
import ifsp.vitaesangue.repository.EstabelecimentoRepository;
import ifsp.vitaesangue.repository.HemocentroRepository;
import ifsp.vitaesangue.repository.HospitalRepository;
import ifsp.vitaesangue.repository.UsuarioRepository;
import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/contrato")
public class ContratoController {

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private HemocentroRepository hemocentroRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	@RequiredPermission(resource = ResourcesAllow.CONTRATO, action = TipoAcaoHistorico.READ)
	public ResponseEntity<Page<ContratoResponse>> getAll(@PageableDefault(size = 10) Pageable pageable) {
		var page = contratoRepository.findAll(pageable).map(contrato -> modelMapper.map(contrato, ContratoResponse.class));
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.CONTRATO, action = TipoAcaoHistorico.READ)
	public ResponseEntity<ContratoResponse> getById(@PathVariable("id") Long id) {
		Contrato contrato = contratoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("contrato não encontrado"));

		ContratoResponse contratoResponse = modelMapper.map(contrato, ContratoResponse.class);

		return ResponseEntity.ok().body(contratoResponse);
	}
	
	@Transactional
	@PostMapping
	@RequiredPermission(resource = ResourcesAllow.CONTRATO, action = TipoAcaoHistorico.CREATE)
	public ResponseEntity<ContratoResponse> create(@RequestBody ContratoRequest contratoRequest) {

		Contrato contrato = modelMapper.map(contratoRequest, Contrato.class);

		Hospital hospital = hospitalRepository.findById(contratoRequest.getHospitalResponse())
				.orElseThrow(() -> new RuntimeException("hospital não encontrado"));

		contrato.setHospital(hospital);
		
		Hemocentro hemocentro = hemocentroRepository.findById(contratoRequest.getHemocentro())
				.orElseThrow(() -> new RuntimeException("hemocentro não encontrado"));

		contrato.setHemocentro(hemocentro);
		
		Usuario usuarioRequerimento = usuarioRepository.findById(contratoRequest.getUsuarioRequerimento())
				.orElseThrow(() -> new RuntimeException("usuairo requerimento não encontrado"));

		contrato.setUsuarioRequerimento(usuarioRequerimento);
		
		Usuario usuarioRequerido = usuarioRepository.findById(contratoRequest.getUsuarioRequerido())
				.orElseThrow(() -> new RuntimeException("usuairo requerido não encontrado"));

		contrato.setUsuarioRequerido(usuarioRequerido);
		

		Contrato contratoEntity = contratoRepository.save(contrato);

		return ResponseEntity.ok().body(modelMapper.map(contratoEntity, ContratoResponse.class));
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.CONTRATO, action = TipoAcaoHistorico.DELETE)
	public void  delete(@PathVariable("id") Long id) {
		
		contratoRepository.deleteById(id);
		
	}
}

