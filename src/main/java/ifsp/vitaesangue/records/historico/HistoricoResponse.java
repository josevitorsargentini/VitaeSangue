package ifsp.vitaesangue.records.historico;

import java.util.Date;

import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.records.usuario.UsuarioIdentificacaoResponse;

public class HistoricoResponse {
	private Long id;
	private TipoAcaoHistorico acao;
	private UsuarioIdentificacaoResponse usuario;
	private Date dtHistorico;
	
	public HistoricoResponse() {
		super();
	}

	public HistoricoResponse(Long id, TipoAcaoHistorico acao, UsuarioIdentificacaoResponse usuario, Date dtHistorico) {
		super();
		this.id = id;
		this.acao = acao;
		this.usuario = usuario;
		this.dtHistorico = dtHistorico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoAcaoHistorico getAcao() {
		return acao;
	}

	public void setAcao(TipoAcaoHistorico acao) {
		this.acao = acao;
	}

	public UsuarioIdentificacaoResponse getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioIdentificacaoResponse usuario) {
		this.usuario = usuario;
	}

	public Date getDtHistorico() {
		return dtHistorico;
	}

	public void setDtHistorico(Date dtHistorico) {
		this.dtHistorico = dtHistorico;
	}
	
}
