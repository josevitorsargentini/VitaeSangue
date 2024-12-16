package ifsp.vitaesangue.records.requisicao;

import ifsp.vitaesangue.model.SituacaoRequisicao;

public class RequisicaoUpdate {
	private Long id;
	private Long usuarioRequeridoId;
	private SituacaoRequisicao situacao;
	
	public RequisicaoUpdate(Long id, Long usuarioRequeridoId, SituacaoRequisicao situacao) {
		super();
		this.id = id;
		this.usuarioRequeridoId = usuarioRequeridoId;
		this.situacao = situacao;
	}
	
	public RequisicaoUpdate() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuarioRequeridoId() {
		return usuarioRequeridoId;
	}

	public void setUsuarioRequeridoId(Long usuarioRequeridoId) {
		this.usuarioRequeridoId = usuarioRequeridoId;
	}

	public SituacaoRequisicao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoRequisicao situacao) {
		this.situacao = situacao;
	}
	
}
