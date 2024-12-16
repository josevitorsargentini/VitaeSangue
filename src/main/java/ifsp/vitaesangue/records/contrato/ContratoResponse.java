package ifsp.vitaesangue.records.contrato;

import java.time.LocalDate;
import java.util.List;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.model.Hemocentro;
import ifsp.vitaesangue.model.Hospital;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoResponse;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoResponseRecord;
import ifsp.vitaesangue.records.hospital.HospitalResponse;
import ifsp.vitaesangue.records.telefone.TelefoneResponse;
import ifsp.vitaesangue.records.usuario.UsuarioResponse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ContratoResponse {

	private Long id;

	private HospitalResponse hospitalResponse;

	private Hemocentro hemocentro;

	private UsuarioResponse usuarioRequerimento;

	private UsuarioResponse usuarioRequerido;

	private LocalDate inicio;

	private LocalDate vencimento;

	private Integer quantidadeSangue;

	public ContratoResponse() {
		super();
	}

	public ContratoResponse(Long id, HospitalResponse hospitalResponse, Hemocentro hemocentro,
			UsuarioResponse usuarioRequerimento, UsuarioResponse usuarioRequerido, LocalDate inicio,
			LocalDate vencimento, Integer quantidadeSangue) {
		super();
		this.id = id;
		this.hospitalResponse = hospitalResponse;
		this.hemocentro = hemocentro;
		this.usuarioRequerimento = usuarioRequerimento;
		this.usuarioRequerido = usuarioRequerido;
		this.inicio = inicio;
		this.vencimento = vencimento;
		this.quantidadeSangue = quantidadeSangue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HospitalResponse getHospitalResponse() {
		return hospitalResponse;
	}

	public void setHospitalResponse(HospitalResponse hospitalResponse) {
		this.hospitalResponse = hospitalResponse;
	}

	public Hemocentro getHemocentro() {
		return hemocentro;
	}

	public void setHemocentro(Hemocentro hemocentro) {
		this.hemocentro = hemocentro;
	}

	public UsuarioResponse getUsuarioRequerimento() {
		return usuarioRequerimento;
	}

	public void setUsuarioRequerimento(UsuarioResponse usuarioRequerimento) {
		this.usuarioRequerimento = usuarioRequerimento;
	}

	public UsuarioResponse getUsuarioRequerido() {
		return usuarioRequerido;
	}

	public void setUsuarioRequerido(UsuarioResponse usuarioRequerido) {
		this.usuarioRequerido = usuarioRequerido;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public Integer getQuantidadeSangue() {
		return quantidadeSangue;
	}

	public void setQuantidadeSangue(Integer quantidadeSangue) {
		this.quantidadeSangue = quantidadeSangue;
	}

}
