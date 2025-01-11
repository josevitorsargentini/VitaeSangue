package ifsp.vitaesangue.model;

import java.util.List;

import ifsp.vitaesangue.listener.HistoricoListener;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@EntityListeners(HistoricoListener.class) 
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perfil_id")
    private Long id;

    @Column(name = "nome")
    private String nome;
    
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "perfil_id",  nullable = false)
    private List<Permissao> permissoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
   
}