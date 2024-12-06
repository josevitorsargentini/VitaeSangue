package ifsp.vitaesangue.model;

import ifsp.vitaesangue.listener.HistoricoListener;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoRecord;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EntityListeners(HistoricoListener.class) 
public class Estabelecimento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estabelecimento_id")
    private Long id;
	
	private String nome; 
    private String email; 
    
    @Embedded
    private Endereco endereco;
    private boolean ativo;
    
    public Estabelecimento() {
    }
    
    public static Estabelecimento from(EstabelecimentoRecord record) {
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setNome(record.nome());
        estabelecimento.setEmail(record.email());
        estabelecimento.setEndereco(record.endereco()); 
        return estabelecimento;
    }

    public Long getId() {
        return id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
   

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
