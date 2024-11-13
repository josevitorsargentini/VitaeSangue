package ifsp.vitaesangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifsp.vitaesangue.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
