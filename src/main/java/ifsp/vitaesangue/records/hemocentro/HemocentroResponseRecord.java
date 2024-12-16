package ifsp.vitaesangue.records.hemocentro;

import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Hemocentro;

public record HemocentroResponseRecord(Long id, Estabelecimento estabelecimento) {
	public HemocentroResponseRecord(Hemocentro hemocentro) {
		this(hemocentro.getId(), hemocentro.getEstabelecimento());
	}
}
