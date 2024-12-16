package ifsp.vitaesangue.records.hospital;

import java.util.List;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.model.TipoHospital;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoResponse;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoResponseRecord;
import ifsp.vitaesangue.records.telefone.TelefoneResponse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class HospitalResponse {

	private Long id;

	private String cnes;

	@Enumerated(EnumType.STRING)
	private TipoHospital tipo;

	private String diretorResponsavel;

	private Long estabelecimentoId;

	public HospitalResponse() {
		super();
	}

	public HospitalResponse(Long id, String cnes, TipoHospital tipo, String diretorResponsavel,
			Long estabelecimentoId) {
		super();
		this.id = id;
		this.cnes = cnes;
		this.tipo = tipo;
		this.diretorResponsavel = diretorResponsavel;
		this.estabelecimentoId = estabelecimentoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	public TipoHospital getTipo() {
		return tipo;
	}

	public void setTipo(TipoHospital tipo) {
		this.tipo = tipo;
	}

	public String getDiretorResponsavel() {
		return diretorResponsavel;
	}

	public void setDiretorResponsavel(String diretorResponsavel) {
		this.diretorResponsavel = diretorResponsavel;
	}

	public Long getEstabelecimentoId() {
		return estabelecimentoId;
	}

	public void setEstabelecimentoId(Long estabelecimentoId) {
		this.estabelecimentoId = estabelecimentoId;
	}

	

}
