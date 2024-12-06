package ifsp.vitaesangue.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import ifsp.vitaesangue.model.Hospital;
import ifsp.vitaesangue.records.hospital.HospitalRecord;
import ifsp.vitaesangue.records.hospital.HospitalResponseRecord;
import ifsp.vitaesangue.repository.HospitalRepository;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	
	
	@GetMapping
	public ResponseEntity<Page> list(@PageableDefault(size= 10) Pageable pageable) {
        var page = hospitalRepository.findAll(pageable).map(HospitalResponseRecord::new);
        return ResponseEntity.ok(page);
    }
	
	
	@GetMapping("/{hospitalId}")
	public ResponseEntity<HospitalResponseRecord> getHospitalByID(@PathVariable("hospitalId") Long hospitalId) {
		Hospital hospital  = hospitalRepository.findById(hospitalId).orElseThrow(() -> new RuntimeException());
		return ResponseEntity.ok().body(new HospitalResponseRecord(hospital)) ;
	}
	
	
	@PostMapping
	public ResponseEntity<HospitalRecord> create(@RequestBody HospitalRecord hospital) {
		hospitalRepository.save(Hospital.from(hospital));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{id}")
	public void  delete(@PathVariable("id") Long id) {
		
		hospitalRepository.deleteById(id);
		
	}

}
