package ifsp.vitaesangue.records.descarte;

import java.time.LocalDateTime;
import java.util.List;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoResponse;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoResponseRecord;
import ifsp.vitaesangue.records.telefone.TelefoneResponse;
import jakarta.persistence.Column;

public class DescarteResponse {

	private Long id;

    private String nomeProfissional;

    private String codProfissional;

    private String motivo;

    private LocalDateTime dtDescarte;

	public DescarteResponse() {
		super();
	}

	public DescarteResponse(Long id, String nomeProfissional, String codProfissional, String motivo,
			LocalDateTime dtDescarte) {
		super();
		this.id = id;
		this.nomeProfissional = nomeProfissional;
		this.codProfissional = codProfissional;
		this.motivo = motivo;
		this.dtDescarte = dtDescarte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProfissional() {
		return nomeProfissional;
	}

	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}

	public String getCodProfissional() {
		return codProfissional;
	}

	public void setCodProfissional(String codProfissional) {
		this.codProfissional = codProfissional;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public LocalDateTime getDtDescarte() {
		return dtDescarte;
	}

	public void setDtDescarte(LocalDateTime dtDescarte) {
		this.dtDescarte = dtDescarte;
	}

   
    
    
}
