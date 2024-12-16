package ifsp.vitaesangue.records.hemocentro;

import ifsp.vitaesangue.model.Estabelecimento;

public class HemocentroRequest {
    private Long id;
    private Long estabelecimentoId;

    public HemocentroRequest() {
        super();
    }

    public HemocentroRequest(Long id, Long estabelecimentoId) {
        super();
        this.id = id;
        this.estabelecimentoId = estabelecimentoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(Long estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }
}
