package ifsp.vitaesangue.records.entrega;

import java.util.List;

import ifsp.vitaesangue.model.Requisicao;
import ifsp.vitaesangue.records.bolsasangue.entrega.BolsaEntregaResponse;
import ifsp.vitaesangue.records.requisicao.RequisicaoIdentificacaoResponse;
import ifsp.vitaesangue.records.usuario.UsuarioIdentificacaoResponse;

public class EntregaResponse {
	private Long id;
	private RequisicaoIdentificacaoResponse requisicao;
	private UsuarioIdentificacaoResponse usuarioAprovador;
	private UsuarioIdentificacaoResponse usuarioRecebedor;
	private Boolean emergencia;
	private List<BolsaEntregaResponse> bolsas;
	
	public EntregaResponse() {
	}
	
	public EntregaResponse(Long id, RequisicaoIdentificacaoResponse requisicao, UsuarioIdentificacaoResponse usuarioAprovador,
			UsuarioIdentificacaoResponse usuarioRecebedor, Boolean emergencia, List<BolsaEntregaResponse> bolsas) {
		super();
		this.id = id;
		this.requisicao = requisicao;
		this.usuarioAprovador = usuarioAprovador;
		this.usuarioRecebedor = usuarioRecebedor;
		this.emergencia = emergencia;
		this.bolsas = bolsas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RequisicaoIdentificacaoResponse getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(RequisicaoIdentificacaoResponse requisicao) {
		this.requisicao = requisicao;
	}

	public UsuarioIdentificacaoResponse getUsuarioAprovador() {
		return usuarioAprovador;
	}

	public void setUsuarioAprovador(UsuarioIdentificacaoResponse usuarioAprovador) {
		this.usuarioAprovador = usuarioAprovador;
	}

	public UsuarioIdentificacaoResponse getUsuarioRecebedor() {
		return usuarioRecebedor;
	}

	public void setUsuarioRecebedor(UsuarioIdentificacaoResponse usuarioRecebedor) {
		this.usuarioRecebedor = usuarioRecebedor;
	}

	public Boolean getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(Boolean emergencia) {
		this.emergencia = emergencia;
	}

	public List<BolsaEntregaResponse> getBolsas() {
		return bolsas;
	}

	public void setBolsas(List<BolsaEntregaResponse> bolsas) {
		this.bolsas = bolsas;
	}

	
}
