package ifsp.vitaesangue.records.requisicao;

import java.util.List;

import ifsp.vitaesangue.model.SituacaoRequisicao;
import ifsp.vitaesangue.records.bolsasangue.requisicao.BolsaRequisicaoRequest;

public class RequisicaoRequest {
	private Long hospitalId;
	private Long hemocentroId;
	private Long usuarioRequeridoId;
	private Long usuarioRequerimentoId;
	private SituacaoRequisicao situacao;
	private List<BolsaRequisicaoRequest> bolsas;
	
	public RequisicaoRequest() {
		super();
	}

	public RequisicaoRequest(Long hospitalId, Long hemocentroId, Long usuarioRequeridoId,
			Long usuarioRequerimentoId, SituacaoRequisicao situacao) {
		super();
		this.hospitalId = hospitalId;
		this.hemocentroId = hemocentroId;
		this.usuarioRequeridoId = usuarioRequeridoId;
		this.usuarioRequerimentoId = usuarioRequerimentoId;
		this.situacao = situacao;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getHemocentroId() {
		return hemocentroId;
	}

	public void setHemocentroId(Long hemocentroId) {
		this.hemocentroId = hemocentroId;
	}

	public Long getUsuarioRequeridoId() {
		return usuarioRequeridoId;
	}

	public void setUsuarioRequeridoId(Long usuarioRequeridoId) {
		this.usuarioRequeridoId = usuarioRequeridoId;
	}

	public Long getUsuarioRequerimentoId() {
		return usuarioRequerimentoId;
	}

	public void setUsuarioRequerimentoId(Long usuarioRequerimentoId) {
		this.usuarioRequerimentoId = usuarioRequerimentoId;
	}

	public SituacaoRequisicao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoRequisicao situacao) {
		this.situacao = situacao;
	}

	public List<BolsaRequisicaoRequest> getBolsas() {
		return bolsas;
	}

	public void setBolsas(List<BolsaRequisicaoRequest> bolsas) {
		this.bolsas = bolsas;
	}
	
}