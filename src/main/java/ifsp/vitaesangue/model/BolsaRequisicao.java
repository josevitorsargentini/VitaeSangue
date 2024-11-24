package ifsp.vitaesangue.model;

import ifsp.vitaesangue.listener.HistoricoListener;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(HistoricoListener.class)
public class BolsaRequisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bolsa_requisicao_id")
    private Long id;

    @ManyToOne(targetEntity = Requisicao.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "requisicao_id")
    private Requisicao requisicao;

    @Column(name = "hemocomponente")
    private String hemocomponente;

    @Column(name = "abo")
    private String abo;

    @Column(name = "rh")
    private String rh;

    @Column(name = "qtd_requirida")
    private Integer quantidadeRequirida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public String getHemocomponente() {
        return hemocomponente;
    }

    public void setHemocomponente(String hemocomponente) {
        this.hemocomponente = hemocomponente;
    }

    public String getAbo() {
        return abo;
    }

    public void setAbo(String abo) {
        this.abo = abo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public Integer getQuantidadeRequirida() {
        return quantidadeRequirida;
    }

    public void setQuantidadeRequirida(Integer quantidadeRequirida) {
        this.quantidadeRequirida = quantidadeRequirida;
    }
}