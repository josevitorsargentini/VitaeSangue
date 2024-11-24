package ifsp.vitaesangue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Hospital;
import ifsp.vitaesangue.repository.EstabelecimentoRepository;
import ifsp.vitaesangue.repository.HospitalRepository;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	
	
	@GetMapping
	public List<Hospital> getAll() {
		
		return hospitalRepository.findAll();
	}
	
	@PostMapping
	public Hospital create(@RequestBody Hospital hospital) {

		hospitalRepository.save(hospital);
		return hospital;
	}
	
	@DeleteMapping("/{id}")
	public void  delete(@PathVariable("id") Long id) {
		
		hospitalRepository.deleteById(id);
		
	}

}
