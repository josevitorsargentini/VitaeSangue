package ifsp.vitaesangue.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private Long permissaoId;

    @ManyToOne(targetEntity = Perfil.class)
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @Column(name = "controller")
    private String controller;

    @Column(name = "endpoint")
    private String endpoint;

    @Column(name = "criacao")
    private Boolean criacao;

    @Column(name = "visualizacao")
    private Boolean visualizacao;

    @Column(name = "atualizacao")
    private Boolean atualizacao;

    public Long getPermissaoId() {
        return permissaoId;
    }

    public void setPermissaoId(Long permissaoId) {
        this.permissaoId = permissaoId;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
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
    
}