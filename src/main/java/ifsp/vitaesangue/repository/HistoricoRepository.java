package ifsp.vitaesangue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifsp.vitaesangue.model.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
    List<Historico> findByNomeTabelaAndRegistroId(String nomeTabela, Long registroId);
}
