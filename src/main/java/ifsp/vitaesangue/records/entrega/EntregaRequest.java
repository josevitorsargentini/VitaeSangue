package ifsp.vitaesangue.records.entrega;

import java.util.List;

import ifsp.vitaesangue.records.bolsasangue.entrega.BolsaEntregaRequest;

public class EntregaRequest {
	private Long requisicaoId;
	private Long usuarioAprovadorId;
	private Long usuarioRecebedorId;
	private boolean emergencia;
	private List<BolsaEntregaRequest> bolsas;
	
	public EntregaRequest() {
	}

	public EntregaRequest(Long requisicaoId, Long usuarioAprovadorId, Long usuarioRecebedorId, boolean emergencia, List<BolsaEntregaRequest> bolsas) {
		super();
		this.requisicaoId = requisicaoId;
		this.usuarioAprovadorId = usuarioAprovadorId;
		this.usuarioRecebedorId = usuarioRecebedorId;
		this.emergencia = emergencia;
		this.bolsas = bolsas;
	}

	public Long getRequisicaoId() {
		return requisicaoId;
	}
	
	public void setRequisicaoId(Long requisicaoId) {
		this.requisicaoId = requisicaoId;
	}
	
	public Long getUsuarioAprovadorId() {
		return usuarioAprovadorId;
	}
	
	public void setUsuarioAprovadorId(Long usuarioAprovadorId) {
		this.usuarioAprovadorId = usuarioAprovadorId;
	}
	
	public Long getUsuarioRecebedorId() {
		return usuarioRecebedorId;
	}
	
	public void setUsuarioRecebedorId(Long usuarioRecebedorId) {
		this.usuarioRecebedorId = usuarioRecebedorId;
	}
	
	public boolean isEmergencia() {
		return emergencia;
	}
	
	public void setEmergencia(boolean emergencia) {
		this.emergencia = emergencia;
	}

	public List<BolsaEntregaRequest> getBolsas() {
		return bolsas;
	}

	public void setBolsas(List<BolsaEntregaRequest> bolsas) {
		this.bolsas = bolsas;
	}
	
}
