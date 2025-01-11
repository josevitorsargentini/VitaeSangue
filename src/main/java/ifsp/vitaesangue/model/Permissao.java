package ifsp.vitaesangue.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permissao_id")
    private Long id;

    @Column(name = "controller")
    @Enumerated(EnumType.STRING)
    private ResourcesAllow controller;
    
    @Column(name = "criacao")
    private Boolean criacao;

    @Column(name = "visualizacao")
    private Boolean visualizacao;

    @Column(name = "atualizacao")
    private Boolean atualizacao;
    
    @Column(name = "deletar")
    private Boolean deletar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResourcesAllow getController() {
        return controller;
    }

    public void setController(ResourcesAllow controller) {
        this.controller = controller;
    }

    public Boolean getCriacao() {
        return criacao;
    }

    public void setCriacao(Boolean criacao) {
        this.criacao = criacao;
    }

    public Boolean getVisualizacao() {
        return visualizacao;
    }

    public void setVisualizacao(Boolean visualizacao) {
        this.visualizacao = visualizacao;
    }

    public Boolean getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(Boolean atualizacao) {
        this.atualizacao = atualizacao;
    }

	public Boolean getDeletar() {
		return deletar;
	}

	public void setDeletar(Boolean deletar) {
		this.deletar = deletar;
	}

    
}