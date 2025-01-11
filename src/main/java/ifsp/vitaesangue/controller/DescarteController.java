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

import ifsp.vitaesangue.annotations.RequiredPermission;
import ifsp.vitaesangue.model.Descarte;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.records.descarte.DescarteResponse;
import ifsp.vitaesangue.repository.DescarteRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/descarte")
public class DescarteController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DescarteRepository descarteRepository;

	@GetMapping
	@RequiredPermission(resource = ResourcesAllow.BOLSA_DESCARTE, action = TipoAcaoHistorico.READ)
	public ResponseEntity<Page<DescarteResponse>> getAll(@PageableDefault(size = 10) Pageable pageable) {
		var page = descarteRepository.findAll(pageable)
				.map(descarte -> modelMapper.map(descarte, DescarteResponse.class));
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.BOLSA_DESCARTE, action = TipoAcaoHistorico.READ)
	public ResponseEntity<DescarteResponse> getById(@PathVariable("id") Long id) {
		Descarte descarte = descarteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Descarte não encontrado"));

		DescarteResponse descarteResponse = modelMapper.map(descarte, DescarteResponse.class);

		return ResponseEntity.ok().body(descarteResponse);
	}

	@Transactional
	@PostMapping
	@RequiredPermission(resource = ResourcesAllow.BOLSA_DESCARTE, action = TipoAcaoHistorico.CREATE)
	public ResponseEntity<DescarteResponse> create(@RequestBody DescarteResponse descarteResponse) {

		Descarte descarte = modelMapper.map(descarteResponse, Descarte.class);

		return ResponseEntity.ok().body(modelMapper.map(descarteRepository.save(descarte), DescarteResponse.class));
	}

	@Transactional
	@PutMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.BOLSA_DESCARTE, action = TipoAcaoHistorico.UPDATE)
	public ResponseEntity<DescarteResponse> edit(@PathVariable("id") Long id,
			@RequestBody DescarteResponse descarteUpdate) {

		if (!id.equals(descarteUpdate.getId())) {
			throw new RuntimeException("Os ID's informados nao correspondem");
		}

		return descarteRepository.findById(descarteUpdate.getId()).map(descarteEntity -> {

			modelMapper.map(descarteUpdate, descarteEntity);

			Descarte descarteSaved = descarteRepository.save(descarteEntity);
			return ResponseEntity.ok().body(modelMapper.map(descarteSaved, DescarteResponse.class));
		}).orElseThrow(() -> new RuntimeException("Descarte não encontrado"));
	}

	@Transactional
	@DeleteMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.BOLSA_DESCARTE, action = TipoAcaoHistorico.DELETE)
	public void delete(@PathVariable("id") Long id) {

		descarteRepository.deleteById(id);
	}
}
