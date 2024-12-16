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
import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoResponse;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoUpdate;
import ifsp.vitaesangue.repository.EstabelecimentoRepository;
import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@GetMapping
	public ResponseEntity<Page<EstabelecimentoResponse>> getAll(@PageableDefault(size = 10) Pageable pageable) {
		var page = estabelecimentoRepository.findAll(pageable).map(estabelecimento -> modelMapper.map(estabelecimento, EstabelecimentoResponse.class));
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstabelecimentoResponse> getById(@PathVariable("id") Long id) {
		Estabelecimento estabelecimento = estabelecimentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

		EstabelecimentoResponse estabelecimentoResponse = modelMapper.map(estabelecimento, EstabelecimentoResponse.class);

		return ResponseEntity.ok().body(estabelecimentoResponse);
	}
	
	@PostMapping
	public Estabelecimento create(@RequestBody Estabelecimento estabelecimento) {
		
		estabelecimentoRepository.save(estabelecimento);
		return estabelecimento;
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<EstabelecimentoResponse> edit(@PathVariable("id") Long id, @RequestBody EstabelecimentoUpdate estabelecimentoUpdate) {
		
		if (!id.equals(estabelecimentoUpdate.getId())) {
	        throw new RuntimeException("Os ID's informados nao correspondem");
	    }
		
	    return estabelecimentoRepository.findById(estabelecimentoUpdate.getId())
	        .map(estabelecimentoEntity -> {
	            modelMapper.map(estabelecimentoUpdate, estabelecimentoEntity);
	            Estabelecimento estabelecimentoSaves = estabelecimentoRepository.save(estabelecimentoEntity);
	            return ResponseEntity.ok().body(modelMapper.map(estabelecimentoSaves, EstabelecimentoResponse.class));
	        })
	        .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));
	}
	
	@DeleteMapping("/{id}")
	public void  delete(@PathVariable("id") Long id) {
		
		estabelecimentoRepository.deleteById(id);
		
	}
}

