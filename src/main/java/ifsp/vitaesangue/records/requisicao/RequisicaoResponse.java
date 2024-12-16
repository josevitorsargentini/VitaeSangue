package ifsp.vitaesangue.records.requisicao;

import java.util.List;

import ifsp.vitaesangue.model.SituacaoRequisicao;
import ifsp.vitaesangue.records.bolsasangue.requisicao.BolsaRequisicaoResponse;
import ifsp.vitaesangue.records.hemocentro.HemocentroIdentificacaoResponse;
import ifsp.vitaesangue.records.hospital.HospitalIdentificacaoResponse;
import ifsp.vitaesangue.records.usuario.UsuarioIdentificacaoResponse;

public class RequisicaoResponse {
	private Long id;
	private HospitalIdentificacaoResponse hospital;
	private HemocentroIdentificacaoResponse hemocentro;
	private UsuarioIdentificacaoResponse usuarioRequerido;
	private UsuarioIdentificacaoResponse usuarioRequerimento;
	private SituacaoRequisicao situacao;
	private List<BolsaRequisicaoResponse> bolsas;
	
	public RequisicaoResponse() {
		super();
	}
	
	public RequisicaoResponse(Long id, HospitalIdentificacaoResponse hospital, HemocentroIdentificacaoResponse hemocentro, UsuarioIdentificacaoResponse usuarioRequerido,
			UsuarioIdentificacaoResponse  usuarioRequerente, SituacaoRequisicao situacao) {
		super();
		this.id = id;
		this.hospital = hospital;
		this.hemocentro = hemocentro;
		this.usuarioRequerido = usuarioRequerido;
		this.usuarioRequerimento = usuarioRequerente;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HospitalIdentificacaoResponse getHospital() {
		return hospital;
	}

	public void setHospital(HospitalIdentificacaoResponse hospital) {
		this.hospital = hospital;
	}

	public HemocentroIdentificacaoResponse getHemocentro() {
		return hemocentro;
	}

	public void setHemocentro(HemocentroIdentificacaoResponse hemocentro) {
		this.hemocentro = hemocentro;
	}

	public UsuarioIdentificacaoResponse getUsuarioRequerido() {
		return usuarioRequerido;
	}

	public void setUsuarioRequerido(UsuarioIdentificacaoResponse usuarioRequerido) {
		this.usuarioRequerido = usuarioRequerido;
	}

	public UsuarioIdentificacaoResponse getUsuarioRequerimento() {
		return usuarioRequerimento;
	}

	public void setUsuarioRequerimento(UsuarioIdentificacaoResponse usuarioRequerente) {
		this.usuarioRequerimento = usuarioRequerente;
	}

	public SituacaoRequisicao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoRequisicao situacao) {
		this.situacao = situacao;
	}

	public List<BolsaRequisicaoResponse> getBolsas() {
		return bolsas;
	}

	public void setBolsas(List<BolsaRequisicaoResponse> bolsas) {
		this.bolsas = bolsas;
	}

}
