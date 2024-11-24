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
public class BolsaEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bolsa_entrega_id")
    private Long id;

    @ManyToOne(targetEntity = Entrega.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "entrega_id")
    private Entrega entrega;

    private String hemocomponente;

    private String abo;

    private String rh;

    @Column(name = "qtd_utilizada")
    private Integer quantidadeUtilizada;

    @ManyToOne(targetEntity = Utilizacao.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "utilizacao_id")
    private Utilizacao utilizacao;

    @Column(name = "qtd_descartada")
    private Integer quantidadeDescarte;

    @ManyToOne(targetEntity = Descarte.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "descarte_id")
    private Descarte descarte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
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

    public Integer getQuantidadeUtilizada() {
        return quantidadeUtilizada;
    }

    public void setQuantidadeUtilizada(Integer quantidadeUtilizada) {
        this.quantidadeUtilizada = quantidadeUtilizada;
    }

    public Utilizacao getUtilizacao() {
        return utilizacao;
    }

    public void setUtilizacao(Utilizacao utilizacao) {
        this.utilizacao = utilizacao;
    }

    public Integer getQuantidadeDescarte() {
        return quantidadeDescarte;
    }

    public void setQuantidadeDescarte(Integer quantidadeDescarte) {
        this.quantidadeDescarte = quantidadeDescarte;
    }

    public Descarte getDescarte() {
        return descarte;
    }

    public void setDescarte(Descarte descarte) {
        this.descarte = descarte;
    }
}