package ifsp.vitaesangue.records.telefone;

import ifsp.vitaesangue.model.Telefone;

public record TelefoneResponseRecord(int ddd, int numero, boolean isWhatsapp, String descricao) {
	public TelefoneResponseRecord(Telefone telefone) {
		this(telefone.getDdd(), telefone.getNumero(), telefone.isWhatsapp(), telefone.getDescricao());
	}
}
