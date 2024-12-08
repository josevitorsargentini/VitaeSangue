package ifsp.vitaesangue.records.usuario;

import java.util.ArrayList;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Perfil;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoRecord;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoResponseRecord;
import ifsp.vitaesangue.records.telefone.TelefoneResponseRecord;

public record UsuarioResponseRecord(Long id, String cpf, String nome, String email, Endereco endereco, EstabelecimentoResponseRecord estabelecimento, Perfil perfil) {
	public UsuarioResponseRecord(Usuario usuario) {
		this(
				usuario.getId(),
				usuario.getCpf(),
				usuario.getNome(),
				usuario.getEmail(), 
				usuario.getEndereco(), 
				new EstabelecimentoResponseRecord(usuario.getEstabelecimento()),
				usuario.getPerfil()
				
		);
	}
}
