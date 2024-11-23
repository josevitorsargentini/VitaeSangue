package ifsp.vitaesangue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.vitaesangue.model.Historico;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.repository.HistoricoRepository;


@RestController
@RequestMapping("/historico")
public class HistoricoController {
	@Autowired
	private HistoricoRepository historicoRepository;
	
	@GetMapping("/{entidade}/{id}")
	public List<Historico> getAll(@PathVariable("entidade") String entidade, @PathVariable("id") Long id) {
		return historicoRepository.findByNomeTabelaAndRegistroId(entidade, id);
	}

}
