package ifsp.vitaesangue.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Hemocentro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hemocentro_id")
	private Long hemocentroId;
	
	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name = "estabelecimento_id")
	private Estabelecimento estabelecimento;

	public Long getHemocentroId() {
		return hemocentroId;
	}

	public void setHemocentroId(Long hemocentroId) {
		this.hemocentroId = hemocentroId;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
}
