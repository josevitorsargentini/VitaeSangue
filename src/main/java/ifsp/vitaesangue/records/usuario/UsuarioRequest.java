package ifsp.vitaesangue.records.usuario;

import java.util.List;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.model.Telefone;
import ifsp.vitaesangue.records.telefone.TelefoneRequest;

public class UsuarioRequest {
    private String cpf;
    private String nome;
    private String senha;
    private String email;
    private Endereco endereco;
    private Long perfilId;
    private Long estabelecimentoId;
    private List<TelefoneRequest> telefones;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String cpf, String nome, String senha, String email, Endereco endereco, Long perfilId, Long estabelecimentoId, List<TelefoneRequest> telefones) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
        this.perfilId = perfilId;
        this.estabelecimentoId = estabelecimentoId;
        this.telefones = telefones;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Long perfilId) {
        this.perfilId = perfilId;
    }

    public Long getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(Long estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

	public List<TelefoneRequest> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneRequest> telefones) {
		this.telefones = telefones;
	}
 
}
