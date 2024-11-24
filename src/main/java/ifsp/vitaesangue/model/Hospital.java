package ifsp.vitaesangue.model;

import ifsp.vitaesangue.listener.HistoricoListener;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(HistoricoListener.class) 
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hospital_id")
	private Long id;

	private String cnes;

	@Enumerated(EnumType.STRING)
	private TipoHospital tipo;

	@Column(name = "diretor_responsavel")
	private String diretorResponsavel;

	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name = "estabelecimento_id") 
	private Estabelecimento estabelecimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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