package ifsp.vitaesangue.records.hemocentro;

import ifsp.vitaesangue.model.Estabelecimento;

public class HemocentroRequest {
    private Long id;
    private Estabelecimento estabelecimento;

    public HemocentroRequest() {
        super();
    }

    public HemocentroRequest(Long id, Estabelecimento estabelecimento) {
        super();
        this.id = id;
        this.estabelecimento = estabelecimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}
