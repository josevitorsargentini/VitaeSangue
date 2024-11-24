package ifsp.vitaesangue.model;

import java.time.LocalDateTime;

import ifsp.vitaesangue.listener.HistoricoListener;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(HistoricoListener.class) 
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contrato_id")
	private Long id;
	
	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;
	
	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name = "hemocentro_id")
	private Hemocentro hemocentro;
	
	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name = "usuario_requerimento")
	private Usuario usuarioRequerimento;
	
	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name = "usuario_requerido")
	private Usuario usuarioRequerido;
	
	@Column(name = "dt_inicio")
	private LocalDateTime inicio;
	
	@Column(name = "dt_fim")
	private LocalDateTime vencimento;
	
	@Column(name = "qtd_sangue_mensal")
	private Integer quantidadeSangue; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Hemocentro getHemocentro() {
		return hemocentro;
	}

	public void setHemocentro(Hemocentro hemocentro) {
		this.hemocentro = hemocentro;
	}

	public Usuario getUsuarioRequerimento() {
		return usuarioRequerimento;
	}

	public void setUsuarioRequerimento(Usuario usuarioRequerimento) {
		this.usuarioRequerimento = usuarioRequerimento;
	}

	public Usuario getUsuarioRequerido() {
		return usuarioRequerido;
	}

	public void setUsuarioRequerido(Usuario usuarioRequerido) {
		this.usuarioRequerido = usuarioRequerido;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDateTime vencimento) {
		this.vencimento = vencimento;
	}

	public Integer getQuantidadeSangue() {
		return quantidadeSangue;
	}

	public void setQuantidadeSangue(Integer quantidadeSangue) {
		this.quantidadeSangue = quantidadeSangue;
	}

	
}
