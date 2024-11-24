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
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(HistoricoListener.class)
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrega_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requisicao_id")
    private Requisicao requisicao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_aprovador")
    private Usuario usuarioAprovador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_recebedor")
    private Usuario usuarioRecebedor;

    private Boolean emergencia;

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
}