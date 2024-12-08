package ifsp.vitaesangue.records.usuario;

import java.util.ArrayList;
import java.util.List;

import ifsp.vitaesangue.model.Endereco;
import ifsp.vitaesangue.records.telefone.TelefoneRecord;

public record UsuarioRecord(String cpf, String nome, String senha, String email, Endereco endereco, Long perfilId, Long estabelecimentoId) {

}
