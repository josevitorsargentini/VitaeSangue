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
@Table(name = "bolsa_requisicao")
public class BolsaRequisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bolsa_requisicao_id")
    private Long id;

    @ManyToOne(targetEntity = Requisicao.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "requisicao_id")
    private Requisicao requisicao;

    @Column(name = "hemocomponente")
    @Enumerated(EnumType.STRING)
   	private TipoHemocomponente hemocomponente;

    @Column(name = "abo")
    @Enumerated(EnumType.STRING)
   	private TipoSangue abo;

    @Column(name = "rh")
    private String rh;

    @Column(name = "qtd_requirida")
    private int qtdRequirida;

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

	public int getQtdRequirida() {
		return qtdRequirida;
	}

	public void setQtdRequirida(int qtdRequirida) {
		this.qtdRequirida = qtdRequirida;
	}

}