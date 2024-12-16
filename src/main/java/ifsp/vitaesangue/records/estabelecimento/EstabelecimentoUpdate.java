package ifsp.vitaesangue.records.estabelecimento;

import ifsp.vitaesangue.model.Endereco;

public class EstabelecimentoUpdate {
	private Long id;
	private String nome; 
    private String email; 
    
    private Endereco endereco;
    private boolean ativo;
    
	public EstabelecimentoUpdate() {
		super();
	}
	
	
	public EstabelecimentoUpdate(Long id,String nome, String email, Endereco endereco, boolean ativo) {
		super();
		this.id=id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.ativo = ativo;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
    
}
