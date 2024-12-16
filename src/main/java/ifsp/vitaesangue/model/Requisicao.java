package ifsp.vitaesangue.model;

import java.util.List;

import ifsp.vitaesangue.listener.HistoricoListener;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@EntityListeners(HistoricoListener.class)
@Table(name = "requisicao")
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requisicao_id")
    private Long id;

    @ManyToOne(targetEntity = Hospital.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne(targetEntity = Hemocentro.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "hemocentro_id")
    private Hemocentro hemocentro;

    @OneToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_requerimento")
    private Usuario usuarioRequerimento;

    @OneToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_requerido")
    private Usuario usuarioRequerido;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "requisicao_id",  nullable = true)
    private List<BolsaRequisicao> bolsas;
    
    @Enumerated(EnumType.STRING)
	private SituacaoRequisicao situacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Hemocentro getHemocentro() {
        return hemocentro;
    }

    public void setHemocentro(Hemocentro hemocentro) {
        this.hemocentro = hemocentro;
    }

    public Usuario getUsuarioRequerimento() {
        return usuarioRequerimento;
    }

    public void setUsuarioRequerimento(Usuario usuarioRequerimento) {
        this.usuarioRequerimento = usuarioRequerimento;
    }

    public Usuario getUsuarioRequerido() {
        return usuarioRequerido;
    }

    public void setUsuarioRequerido(Usuario usuarioRequerido) {
        this.usuarioRequerido = usuarioRequerido;
    }

    public SituacaoRequisicao getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoRequisicao situacao) {
        this.situacao = situacao;
    }

	public List<BolsaRequisicao> getBolsas() {
		return bolsas;
	}

	public void setBolsas(List<BolsaRequisicao> bolsas) {
		this.bolsas = bolsas;
	}
    
}
