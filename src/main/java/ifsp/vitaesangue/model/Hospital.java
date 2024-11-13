package ifsp.vitaesangue.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hospital_id")
	private Long hospitalId;

	private String cnes;

	@Enumerated(EnumType.STRING)
	private TipoHospital tipo;

	@Column(name = "diretor_responsavel")
	private String diretorResponsavel;

	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name = "estabelecimento_id") 
	private Estabelecimento estabelecimento;

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
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
}