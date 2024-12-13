package ifsp.vitaesangue.records.usuario;

import java.util.List;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoResponse;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoResponseRecord;
import ifsp.vitaesangue.records.telefone.TelefoneResponse;

public class UsuarioResponse {

    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private Endereco endereco;
    private EstabelecimentoResponse estabelecimento;
    private Perfil perfil;
    private List<TelefoneResponse> telefones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoResponse estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

	public List<TelefoneResponse> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneResponse> telefones) {
		this.telefones = telefones;
	}
    
    
}
