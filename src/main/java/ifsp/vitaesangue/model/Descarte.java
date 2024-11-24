package ifsp.vitaesangue.model;

import java.time.LocalDateTime;

import ifsp.vitaesangue.listener.HistoricoListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EntityListeners(HistoricoListener.class) 
public class Descarte {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "descarte_id")
    private Long id;

    @Column(name = "nome_profissional")
    private String nomeProfissional;

    @Column(name = "cod_profissional")
    private String codProfissional;

    private String motivo;

    @Column(name = "dt_descarte")
    private LocalDateTime dtDescarte;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProfissional() {
		return nomeProfissional;
	}

	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}

	public String getCodProfissional() {
		return codProfissional;
	}

	public void setCodProfissional(String codProfissional) {
		this.codProfissional = codProfissional;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public LocalDateTime getDtDescarte() {
		return dtDescarte;
	}

	public void setDtDescarte(LocalDateTime dtDescarte) {
		this.dtDescarte = dtDescarte;
	}
	
}
