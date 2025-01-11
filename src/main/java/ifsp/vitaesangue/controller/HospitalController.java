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
import ifsp.vitaesangue.model.Hospital;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.records.hospital.HospitalRequest;
import ifsp.vitaesangue.records.hospital.HospitalResponse;
import ifsp.vitaesangue.repository.EstabelecimentoRepository;
import ifsp.vitaesangue.repository.HospitalRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private HospitalRepository hospitalRepository;

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@GetMapping
	@RequiredPermission(resource = ResourcesAllow.HOSPITAL, action = TipoAcaoHistorico.READ)
	public ResponseEntity<Page<HospitalResponse>> getAll(@PageableDefault(size = 10) Pageable pageable) {
		var page = hospitalRepository.findAll(pageable)
				.map(hospital -> modelMapper.map(hospital, HospitalResponse.class));
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.HOSPITAL, action = TipoAcaoHistorico.READ)
	public ResponseEntity<HospitalResponse> getById(@PathVariable("id") Long id) {
		Hospital hospital = hospitalRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Hospital não encontrado"));

		HospitalResponse usuarioResponse = modelMapper.map(hospital, HospitalResponse.class);

		return ResponseEntity.ok().body(usuarioResponse);
	}
	
	
	@Transactional
	@PostMapping
	@RequiredPermission(resource = ResourcesAllow.HOSPITAL, action = TipoAcaoHistorico.CREATE)
	public ResponseEntity<HospitalResponse> create(@RequestBody HospitalRequest hospitalRequest) {

		Hospital hospital = modelMapper.map(hospitalRequest, Hospital.class);

		Estabelecimento estabelecimento = estabelecimentoRepository.findById(hospitalRequest.getEstabelecimentoId())
				.orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

		hospital.setEstabelecimento(estabelecimento);

		
		Hospital hospitalEntity = hospitalRepository.save(hospital);

		return ResponseEntity.ok().body(modelMapper.map(hospitalEntity, HospitalResponse.class));
	}

	@Transactional
	@PutMapping("/{id}")
	@RequiredPermission(resource = ResourcesAllow.HOSPITAL, action = TipoAcaoHistorico.UPDATE)
	public ResponseEntity<HospitalResponse> edit(@PathVariable("id") Long id,
			@RequestBody HospitalRequest hospitalUpdate) {

		if (!id.equals(hospitalUpdate.getId())) {
			throw new RuntimeException("Os ID's informados nao correspondem");
		}

		return hospitalRepository.findById(hospitalUpdate.getId()).map(hospitalEntity -> {

			Estabelecimento estabelecimento = estabelecimentoRepository.findById(hospitalUpdate.getEstabelecimentoId())
					.orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

			modelMapper.map(hospitalUpdate, hospitalEntity);

			hospitalEntity.setEstabelecimento(estabelecimento);

			Hospital hospitalSaved = hospitalRepository.save(hospitalEntity);
			return ResponseEntity.ok().body(modelMapper.map(hospitalSaved, HospitalResponse.class));
		}).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	}

	@DeleteMapping("/{id}")
	@Transactional
	@RequiredPermission(resource = ResourcesAllow.HOSPITAL, action = TipoAcaoHistorico.DELETE)
	public void delete(@PathVariable("id") Long id) {

		hospitalRepository.deleteById(id);

	}

}
