package ifsp.vitaesangue.records.telefone;

public class TelefoneRequest {
	 	private int ddd;
	    private int numero;
	    private boolean isWhatsapp;
	    private String descricao;	    

	    public TelefoneRequest() {
			super();
		}

		public TelefoneRequest(int ddd, int numero, boolean isWhatsapp, String descricao) {
			super();
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
}
