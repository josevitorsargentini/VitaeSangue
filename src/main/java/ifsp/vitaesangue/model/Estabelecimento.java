package ifsp.vitaesangue.model;

import java.util.List;

import ifsp.vitaesangue.listener.HistoricoListener;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoRecord;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

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
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "estabelecimento_id",  nullable = true)
    private List<Telefone> telefones;
    
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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
}
