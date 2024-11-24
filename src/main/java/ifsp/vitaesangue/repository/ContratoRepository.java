package ifsp.vitaesangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifsp.vitaesangue.model.Contrato;


@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

}
