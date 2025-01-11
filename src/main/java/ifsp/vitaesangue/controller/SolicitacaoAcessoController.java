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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.vitaesangue.annotations.RequiredPermission;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.SolicitacaoAcesso;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.records.solicitacaoacesso.SolicitacaoAcessoRequest;
import ifsp.vitaesangue.records.solicitacaoacesso.SolicitacaoAcessoResponse;
import ifsp.vitaesangue.repository.SolicitacaoAcessoRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/solicitacaoacesso")
public class SolicitacaoAcessoController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SolicitacaoAcessoRepository solicitacaoAcessoRepository;
	
	@GetMapping
	public ResponseEntity<Page<SolicitacaoAcessoResponse>> getAll(@PageableDefault(size = 10) Pageable pageable) {
		var page = solicitacaoAcessoRepository.findAll(pageable).map(solitacao -> modelMapper.map(solitacao, SolicitacaoAcessoResponse.class));
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.SOLICITACAO_ACESSO, action = TipoAcaoHistorico.READ)
	public ResponseEntity<SolicitacaoAcessoResponse> getById(@PathVariable("id") Long id) {
		SolicitacaoAcesso solicitacao = solicitacaoAcessoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Solicitacao não encontrado"));
		
		SolicitacaoAcessoResponse solicitacaoResponse = modelMapper.map(solicitacao, SolicitacaoAcessoResponse.class);

		return ResponseEntity.ok().body(solicitacaoResponse);
	}
	
	@Transactional
	@PostMapping
	public ResponseEntity<SolicitacaoAcessoResponse> create(@RequestBody SolicitacaoAcessoRequest solicitacaoRequest) {

		SolicitacaoAcesso solicitacao = modelMapper.map(solicitacaoRequest, SolicitacaoAcesso.class);

		SolicitacaoAcesso solicitacaoEntity = solicitacaoAcessoRepository.save(solicitacao);

		return ResponseEntity.ok().body(modelMapper.map(solicitacaoEntity, SolicitacaoAcessoResponse.class));
	}
	
	
	@Transactional
	@DeleteMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.SOLICITACAO_ACESSO, action = TipoAcaoHistorico.DELETE)
	public void delete(@PathVariable("id") Long id) {

		solicitacaoAcessoRepository.deleteById(id);

	}
	
}
