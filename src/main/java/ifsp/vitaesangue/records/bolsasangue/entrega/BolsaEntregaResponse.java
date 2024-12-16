package ifsp.vitaesangue.records.bolsasangue.entrega;

import ifsp.vitaesangue.model.TipoHemocomponente;
import ifsp.vitaesangue.model.TipoSangue;

public class BolsaEntregaResponse {
	
	private Long id;
	private TipoHemocomponente hemocomponente;
	private TipoSangue abo;
	private String rh;
	private int qtdUtilizada;
	private int qtdDescarte;
	
	public BolsaEntregaResponse(Long id, TipoHemocomponente hemocomponente, TipoSangue abo, String rh,
			int qtdUtilizada, int qtdDescarte) {
		super();
		this.id = id;
		this.hemocomponente = hemocomponente;
		this.abo = abo;
		this.rh = rh;
		this.qtdUtilizada = qtdUtilizada;
		this.qtdDescarte = qtdDescarte;
	}

	public BolsaEntregaResponse() {
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

	public int getQtdUtilizada() {
		return qtdUtilizada;
	}

	public void setQtdUtilizada(int qtdUtilizada) {
		this.qtdUtilizada = qtdUtilizada;
	}

	public int getQtdDescarte() {
		return qtdDescarte;
	}

	public void setQtdDescarte(int qtdDescarte) {
		this.qtdDescarte = qtdDescarte;
	}
	
	
}
