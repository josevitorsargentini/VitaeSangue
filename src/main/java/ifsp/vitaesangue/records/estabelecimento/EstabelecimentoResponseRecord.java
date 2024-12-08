package ifsp.vitaesangue.records.estabelecimento;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.model.Estabelecimento;

public record EstabelecimentoResponseRecord( String nome, String email, Endereco endereco){
	public EstabelecimentoResponseRecord(Estabelecimento estabelecimento) {
		this(
				estabelecimento.getNome(),
				estabelecimento.getEmail(),
				estabelecimento.getEndereco()
		);
	}
}
