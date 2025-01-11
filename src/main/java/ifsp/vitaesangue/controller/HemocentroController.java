package ifsp.vitaesangue.controller;

import org.modelmapper.ModelMapper;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import ifsp.vitaesangue.annotations.RequiredPermission;
import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Hemocentro;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.records.hemocentro.HemocentroRequest;
import ifsp.vitaesangue.records.hemocentro.HemocentroResponse;
import ifsp.vitaesangue.repository.EstabelecimentoRepository;
import ifsp.vitaesangue.repository.HemocentroRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/hemocentro")
public class HemocentroController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private HemocentroRepository hemocentroRepository;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@GetMapping
	@RequiredPermission(resource = ResourcesAllow.HEMOCENTRO, action = TipoAcaoHistorico.READ)
	public ResponseEntity<Page<HemocentroResponse>> getAll(@PageableDefault(size = 10) Pageable pageable) {
		var page = hemocentroRepository.findAll(pageable)
				.map(hemocentro -> modelMapper.map(hemocentro, HemocentroResponse.class));
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.HEMOCENTRO, action = TipoAcaoHistorico.READ)
	public ResponseEntity<HemocentroResponse> getById(@PathVariable("id") Long id) {
	    Hemocentro hemocentro = hemocentroRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Hemocentro não encontrado"));

	    HemocentroResponse hemocentroResponse = modelMapper.map(hemocentro, HemocentroResponse.class);

	    return ResponseEntity.ok().body(hemocentroResponse);
	}
	
	@Transactional
	@PostMapping
	@RequiredPermission(resource = ResourcesAllow.HEMOCENTRO, action = TipoAcaoHistorico.CREATE)
	public ResponseEntity<HemocentroResponse> create(@RequestBody HemocentroRequest hemocentroRequest) {
		
		Hemocentro hemocentro = modelMapper.map(hemocentroRequest, Hemocentro.class);
		
		Estabelecimento estabelecimento = estabelecimentoRepository.findById(hemocentroRequest.getEstabelecimentoId())
				.orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));
		
		hemocentro.setEstabelecimento(estabelecimento);
		
		Hemocentro hemocentroEntity = hemocentroRepository.save(hemocentro);
		
		return ResponseEntity.ok().body(modelMapper.map(hemocentroEntity, HemocentroResponse.class));
	}
	
	@Transactional
	@PutMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.HEMOCENTRO, action = TipoAcaoHistorico.UPDATE)
	public ResponseEntity<HemocentroResponse> edit(@PathVariable("id") Long id,
	        @RequestBody HemocentroRequest hemocentroUpdate) {

	    if (!id.equals(hemocentroUpdate.getId())) {
	        throw new RuntimeException("Os ID's informados nao correspondem");
	    }

	    return hemocentroRepository.findById(hemocentroUpdate.getId()).map(hemocentroEntity -> {

	        Estabelecimento estabelecimento = estabelecimentoRepository.findById(hemocentroUpdate.getEstabelecimentoId())
	                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

	        modelMapper.map(hemocentroUpdate, hemocentroEntity);

	        hemocentroEntity.setEstabelecimento(estabelecimento);

	        Hemocentro hemocentroSaved = hemocentroRepository.save(hemocentroEntity);
	        return ResponseEntity.ok().body(modelMapper.map(hemocentroSaved, HemocentroResponse.class));
	    }).orElseThrow(() -> new RuntimeException("Hemocentro não encontrado"));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.HEMOCENTRO, action = TipoAcaoHistorico.DELETE)
	public void delete(@PathVariable("id") Long id) {

		hemocentroRepository.deleteById(id);

	}
	
}
