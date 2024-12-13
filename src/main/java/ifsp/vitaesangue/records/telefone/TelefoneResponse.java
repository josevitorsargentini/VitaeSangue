package ifsp.vitaesangue.records.telefone;

public class TelefoneResponse {
	private Long id;
	private int ddd;
    private int numero;
    private boolean isWhatsapp;
    private String descricao;	    

    public TelefoneResponse() {
		super();
	}

	public TelefoneResponse(Long id, int ddd, int numero, boolean isWhatsapp, String descricao) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.isWhatsapp = isWhatsapp;
		this.descricao = descricao;
	}

	// Getters e Setters
    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isWhatsapp() {
        return isWhatsapp;
    }

    public void setWhatsapp(boolean isWhatsapp) {
        this.isWhatsapp = isWhatsapp;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
}
