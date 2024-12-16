package ifsp.vitaesangue.records.bolsasangue.requisicao;

import ifsp.vitaesangue.model.TipoHemocomponente;
import ifsp.vitaesangue.model.TipoSangue;

public class BolsaRequisicaoResponse {
	
	private Long id;
	private TipoHemocomponente hemocomponente;
	private TipoSangue abo;
	private String rh;
	private int qtdRequirida;
	
	public BolsaRequisicaoResponse() {
		super();
	}
	
	public BolsaRequisicaoResponse(Long id, TipoHemocomponente hemocomponente, TipoSangue abo, String rh,
			int qtdRequirida) {
		super();
		this.id = id;
		this.hemocomponente = hemocomponente;
		this.abo = abo;
		this.rh = rh;
		this.qtdRequirida = qtdRequirida;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
