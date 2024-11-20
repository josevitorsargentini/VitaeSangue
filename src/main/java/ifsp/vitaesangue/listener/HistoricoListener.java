package ifsp.vitaesangue.listener;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import ifsp.vitaesangue.model.Historico;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.repository.HistoricoRepository;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class HistoricoListener {
	private HistoricoRepository historicoRepository;
	
	@Autowired
	public HistoricoListener(@Lazy HistoricoRepository historicoRepository) {
	    this.historicoRepository = historicoRepository;
	}
	
	@PostPersist
    public void aposInserir(Object entidade) {
        salvarHistorico(entidade, "CREATE");
    }
    
    @PostRemove
    public void antesDeRemover(Object entidade) {
        salvarHistorico(entidade, "DELETE");
    }
    
    @PostUpdate
    public void antesDeAtualizar(Object entidade) {
        salvarHistorico(entidade, "UPDATE");
    }
    
    private void salvarHistorico(Object entidade, String acao) {
        try {
        	
            Historico historico = new Historico();
            historico.setNomeTabela(getNomeTabela(entidade));
            historico.setRegistroId(getRegistroId(entidade));
            historico.setAcao(TipoAcaoHistorico.valueOf(acao));
            historico.setUsuarioId(1l);
            
            historicoRepository.save(historico);
        } catch (Exception e) {
        	System.out.println("Erro " + e.getMessage());
            System.out.println("Erro ao salvar histórico para ação " + acao + " na entidade " + entidade.getClass().getSimpleName());
        }
    }
    
    private String getNomeTabela(Object entidade) {
    	Table tableAnnotation = entidade.getClass().getAnnotation(Table.class);
        
        if (tableAnnotation != null) {
            String nomeTabela = tableAnnotation.name(); 
            return nomeTabela;
        } else {
            return entidade.getClass().getSimpleName();
        }
    }

    private Long getRegistroId(Object entity) {
        try {
            Field id = entity.getClass().getDeclaredField("id");
            id.setAccessible(true);
            return (Long) id.get(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter ID da entidade", e);
        }
    }
    
}
