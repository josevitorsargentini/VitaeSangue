package ifsp.vitaesangue.model;

import java.security.Timestamp;
import java.util.Date;

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
@Table(name = "historico")
public class Historico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "historico_id")
	private Long id;
	
	@Column(name = "nome_tabela")
	private String nomeTabela;
	
	@Column(name = "registro_id")
	private Long registroId;
	
	@Column(name = "acao")
	@Enumerated(EnumType.STRING)  
	private TipoAcaoHistorico acao;
	
	@ManyToOne(targetEntity = Usuario.class)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name = "dt_historico")
	private Date dtHistorico;
	
	@PrePersist
	void realizadoEm() {
		dtHistorico = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public Long getRegistroId() {
		return registroId;
	}

	public void setRegistroId(Long registroId) {
		this.registroId = registroId;
	}

	public TipoAcaoHistorico getAcao() {
		return acao;
	}

	public void setAcao(TipoAcaoHistorico acao) {
		this.acao = acao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDtHistorico() {
		return dtHistorico;
	}

	public void setDtHistorico(Date dtHistorico) {
		this.dtHistorico = dtHistorico;
	}
	
}

