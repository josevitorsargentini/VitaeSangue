package ifsp.vitaesangue.records.solicitacaoacesso;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.model.TipoEstabelecimento;
import ifsp.vitaesangue.model.TipoHospital;

public class SolicitacaoAcessoResponse {
	private Long id;
	private String nome;
	private String email;
	private Endereco endereco;
	private int ddd;
	private int numeroTelefone;
	private TipoEstabelecimento tipoEstabelecimento;
	private TipoHospital tipoHospital;
	private String diretorResponsavel;
	
	public SolicitacaoAcessoResponse() {}

	public SolicitacaoAcessoResponse(Long id, String nome, String email, Endereco endereco, int ddd, int numeroTelefone,
			TipoEstabelecimento tipoEstabelecimento, TipoHospital tipoHospital, String diretorResponsavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.ddd = ddd;
		this.numeroTelefone = numeroTelefone;
		this.tipoEstabelecimento = tipoEstabelecimento;
		this.tipoHospital = tipoHospital;
		this.diretorResponsavel = diretorResponsavel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public TipoEstabelecimento getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public TipoHospital getTipoHospital() {
		return tipoHospital;
	}

	public void setTipoHospital(TipoHospital tipoHospital) {
		this.tipoHospital = tipoHospital;
	}

	public String getDiretorResponsavel() {
		return diretorResponsavel;
	}

	public void setDiretorResponsavel(String diretorResponsavel) {
		this.diretorResponsavel = diretorResponsavel;
	}

}
