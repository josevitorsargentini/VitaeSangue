package ifsp.vitaesangue.model;

import ifsp.vitaesangue.listener.HistoricoListener;
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

    public Estabelecimento(String nome, String email, Endereco endereco, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.ativo = ativo;
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
