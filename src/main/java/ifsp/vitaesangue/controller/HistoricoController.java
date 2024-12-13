package ifsp.vitaesangue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ifsp.vitaesangue.model.Historico;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.records.historico.HistoricoResponse;
import ifsp.vitaesangue.records.usuario.UsuarioResponse;
import ifsp.vitaesangue.repository.HistoricoRepository;


@RestController
@RequestMapping("/historico")
public class HistoricoController {

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private HistoricoRepository historicoRepository;
	
	 
    private static final Map<String, String> TABELAS_BD = new HashMap();
    
    static {
    	TABELAS_BD.put("solicitacaoacesso", "solicitacao_acesso");
    	TABELAS_BD.put("estabelecimento", "estabelecimento");
    	TABELAS_BD.put("perfil", "perfil");
    	TABELAS_BD.put("permissao", "permissao");
    	TABELAS_BD.put("usuario", "usuario");
    	TABELAS_BD.put("telefone", "telefone");
    	TABELAS_BD.put("hemocentro", "hemocentro");
    	TABELAS_BD.put("hospital", "hospital");
    	TABELAS_BD.put("contrato", "contrato");
    	TABELAS_BD.put("requisicao", "requisicao");
    	TABELAS_BD.put("bolsarequisicao", "bolsa_requisicao");
    	TABELAS_BD.put("entrega", "entrega");
    	TABELAS_BD.put("utilizacao", "utilizacao");
    	TABELAS_BD.put("descarte", "descarte");
    	TABELAS_BD.put("bolsaentrega", "bolsa_entrega");
    }
		
	
	@GetMapping("/{entidade}/{id}")
	public List<HistoricoResponse> getAll(@PathVariable("entidade") String entidade, @PathVariable("id") Long id) {
		String tabela = TABELAS_BD.get(entidade.toLowerCase());

	    if (tabela.isEmpty() || tabela.isBlank()) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entidade não encontrada");
	    }
		
	    List<Historico> historicos = historicoRepository.findByNomeTabelaAndRegistroId(tabela, id);

	    return historicos.stream()
	                     .map(historico -> modelMapper.map(historico, HistoricoResponse.class))
	                     .collect(Collectors.toList());
	}

}
