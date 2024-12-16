package ifsp.vitaesangue.records.contrato;

import java.time.LocalDate;
import java.util.List;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.model.Hemocentro;
import ifsp.vitaesangue.model.Telefone;
import ifsp.vitaesangue.records.hospital.HospitalResponse;
import ifsp.vitaesangue.records.telefone.TelefoneRequest;
import ifsp.vitaesangue.records.usuario.UsuarioResponse;

public class ContratoRequest {
	
	
	private Long id;

	private Long hospitalResponse;

	private Long hemocentro;

	private Long usuarioRequerimento;

	private Long usuarioRequerido;

	private LocalDate inicio;

	private LocalDate vencimento;
	
	private Integer quantidadeSangue;
	
    public ContratoRequest() {
    }


	public ContratoRequest(Long id, Long hospitalResponse, Long hemocentro, Long usuarioRequerimento,
			Long usuarioRequerido, LocalDate inicio, LocalDate vencimento, Integer quantidadeSangue) {
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


	public Integer getQuantidadeSangue() {
		return quantidadeSangue;
	}


	public void setQuantidadeSangue(Integer quantidadeSangue) {
		this.quantidadeSangue = quantidadeSangue;
	}


	public Long getHospitalResponse() {
		return hospitalResponse;
	}


	public void setHospitalResponse(Long hospitalResponse) {
		this.hospitalResponse = hospitalResponse;
	}


	public Long getHemocentro() {
		return hemocentro;
	}


	public void setHemocentro(Long hemocentro) {
		this.hemocentro = hemocentro;
	}


	public Long getUsuarioRequerimento() {
		return usuarioRequerimento;
	}


	public void setUsuarioRequerimento(Long usuarioRequerimento) {
		this.usuarioRequerimento = usuarioRequerimento;
	}


	public Long getUsuarioRequerido() {
		return usuarioRequerido;
	}


	public void setUsuarioRequerido(Long usuarioRequerido) {
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

   
 
}
