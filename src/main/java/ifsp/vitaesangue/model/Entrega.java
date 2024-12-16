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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@EntityListeners(HistoricoListener.class)
@Table(name = "entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrega_id")
    private Long id;

    @OneToOne(targetEntity = Requisicao.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "requisicao_id")
    private Requisicao requisicao;

    @OneToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_aprovador")
    private Usuario usuarioAprovador;

    @OneToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_recebedor")
    private Usuario usuarioRecebedor;

    private Boolean emergencia;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "entrega_id",  nullable = true)
    private List<BolsaEntrega> bolsas;

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

    public Usuario getUsuarioAprovador() {
        return usuarioAprovador;
    }

    public void setUsuarioAprovador(Usuario usuarioAprovador) {
        this.usuarioAprovador = usuarioAprovador;
    }

    public Usuario getUsuarioRecebedor() {
        return usuarioRecebedor;
    }

    public void setUsuarioRecebedor(Usuario usuarioRecebedor) {
        this.usuarioRecebedor = usuarioRecebedor;
    }

    public Boolean getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(Boolean emergencia) {
        this.emergencia = emergencia;
    }

	public List<BolsaEntrega> getBolsas() {
		return bolsas;
	}

	public void setBolsas(List<BolsaEntrega> bolsas) {
		this.bolsas = bolsas;
	}
    
}