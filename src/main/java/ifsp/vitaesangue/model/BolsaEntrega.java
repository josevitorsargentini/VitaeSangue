package ifsp.vitaesangue.model;

import ifsp.vitaesangue.listener.HistoricoListener;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@EntityListeners(HistoricoListener.class)
@Table(name = "bolsa_entrega")
public class BolsaEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bolsa_entrega_id")
    private Long id;

    @ManyToOne(targetEntity = Entrega.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "entrega_id")
    private Entrega entrega;

    @Column(name = "hemocomponente")
    @Enumerated(EnumType.STRING)
   	private TipoHemocomponente hemocomponente;

    @Column(name = "abo")
    @Enumerated(EnumType.STRING)
   	private TipoSangue abo;

    @Column(name = "rh")
    private String rh;

    @Column(name = "qtd_utilizada")
    private Integer qtdUtilizada;

    @ManyToOne(targetEntity = Utilizacao.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "utilizacao_id")
    private Utilizacao utilizacao;

    @Column(name = "qtd_descarte")
    private Integer qtdDescarte;

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

    public TipoHemocomponente getHemocomponente() {
		return hemocomponente;
	}

	public void setHemocomponente(TipoHemocomponente hemocomponente) {
		this.hemocomponente = hemocomponente;
	}

	public TipoSangue getAbo() {
		return abo;
	}

	public void setAbo(TipoSangue abo) {
		this.abo = abo;
	}


    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public Integer getQtdUtilizada() {
        return qtdUtilizada;
    }

    public void setQtdUtilizada(Integer qtdUtilizada) {
        this.qtdUtilizada = qtdUtilizada;
    }

    public Utilizacao getUtilizacao() {
        return utilizacao;
    }

    public void setUtilizacao(Utilizacao utilizacao) {
        this.utilizacao = utilizacao;
    }

    public Integer getQtdDescarte() {
        return qtdDescarte;
    }

    public void setQtdDescarte(Integer qtdDescarte) {
        this.qtdDescarte = qtdDescarte;
    }

    public Descarte getDescarte() {
        return descarte;
    }

    public void setDescarte(Descarte descarte) {
        this.descarte = descarte;
    }
}