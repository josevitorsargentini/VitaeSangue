package ifsp.vitaesangue.records.hospital;


import ifsp.vitaesangue.model.TipoHospital;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class HospitalRequest {
	private Long id;

	private String cnes;

	@Enumerated(EnumType.STRING)
	private TipoHospital tipo;

	@Column(name = "diretor_responsavel")
	private String diretorResponsavel;

	private Long estabelecimentoId;

	public HospitalRequest() {
		super();
	}

	public HospitalRequest(Long id, String cnes, TipoHospital tipo, String diretorResponsavel, Long estabelecimentoId) {
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
