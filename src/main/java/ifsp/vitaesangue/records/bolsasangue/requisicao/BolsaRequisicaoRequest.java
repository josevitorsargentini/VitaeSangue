package ifsp.vitaesangue.records.bolsasangue.requisicao;

import ifsp.vitaesangue.model.TipoHemocomponente;
import ifsp.vitaesangue.model.TipoSangue;

public class BolsaRequisicaoRequest {
	
	private TipoHemocomponente hemocomponente;
	private TipoSangue abo;
	private String rh;
	private int qtdRequirida;
	
	public BolsaRequisicaoRequest() {
	}
	
	public BolsaRequisicaoRequest(TipoHemocomponente hemocomponente, TipoSangue abo, String rh,
			int qtdRequirida) {
		super();
		this.hemocomponente = hemocomponente;
		this.abo = abo;
		this.rh = rh;
		this.qtdRequirida = qtdRequirida;
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
