package ifsp.vitaesangue.records.entrega;

public class EntregaUpdate {
	private Long id;
	private Long usuarioRecebedorId;
	
	public EntregaUpdate(Long id, Long usuarioRecebedorId) {
		super();
		this.id = id;
		this.usuarioRecebedorId = usuarioRecebedorId;
	}
	
	public EntregaUpdate() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuarioRecebedorId() {
		return usuarioRecebedorId;
	}

	public void setUsuarioRecebedorId(Long usuarioRecebedorId) {
		this.usuarioRecebedorId = usuarioRecebedorId;
	}
	
	
}
