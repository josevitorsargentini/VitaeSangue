package ifsp.vitaesangue.records.usuario;

import ifsp.vitaesangue.model.Endereco;

public class UsuarioUpdate {
	private Long id;
    private String cpf;
    private String nome;
    private String senha;
    private String email;
    private Endereco endereco;
    private Long perfilId;
    private Long estabelecimentoId;
    
	public UsuarioUpdate() {
		super();
	}
	
	public UsuarioUpdate(Long id, String cpf, String nome, String senha, String email, Endereco endereco, Long perfilId,
			Long estabelecimentoId) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.endereco = endereco;
		this.perfilId = perfilId;
		this.estabelecimentoId = estabelecimentoId;
	}
	
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
    
    
}
