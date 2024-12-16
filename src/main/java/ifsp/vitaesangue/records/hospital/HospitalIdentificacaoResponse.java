package ifsp.vitaesangue.records.hospital;

public class HospitalIdentificacaoResponse {
	private Long id;
	private String cnes;
	private String nome;
	
	public HospitalIdentificacaoResponse(Long id, String cnes, String nome) {
		super();
		this.id = id;
		this.cnes = cnes;
		this.nome = nome;
	}

	public HospitalIdentificacaoResponse() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
