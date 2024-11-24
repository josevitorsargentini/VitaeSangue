package ifsp.vitaesangue.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utilizacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "utilizacao_id")
	private Long id;
	
	@Column(name = "nome_paciente")
	private String nomePaciente;
	
	private String cpf;
	
	private String motivo;
	
	@Column(name = "dt_utilizacao")
	private LocalDateTime dtUtilizacao;
	
	@Column(name = "cod_profisional_retirante")
	private String codProfissionalRetirante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public LocalDateTime getDtUtilizacao() {
		return dtUtilizacao;
	}

	public void setDtUtilizacao(LocalDateTime dtUtilizacao) {
		this.dtUtilizacao = dtUtilizacao;
	}

	public String getCodProfissionalRetirante() {
		return codProfissionalRetirante;
	}

	public void setCodProfissionalRetirante(String codProfissionalRetirante) {
		this.codProfissionalRetirante = codProfissionalRetirante;
	}
	
}
