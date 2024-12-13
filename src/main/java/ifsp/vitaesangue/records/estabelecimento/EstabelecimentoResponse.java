package ifsp.vitaesangue.records.estabelecimento;

import java.util.List;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.records.telefone.TelefoneResponse;

public class EstabelecimentoResponse {
	private Long id;
    private String nome;
    private String email;
    private Endereco endereco;
    private List<TelefoneResponse> telefones;

    public EstabelecimentoResponse() {
		super();
	}

	public EstabelecimentoResponse(Long id, String nome, String email, Endereco endereco, List<TelefoneResponse> telefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefones = telefones;
	}

	public List<TelefoneResponse> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneResponse> telefones) {
		this.telefones = telefones;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}