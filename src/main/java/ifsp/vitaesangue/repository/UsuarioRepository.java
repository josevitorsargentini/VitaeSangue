package ifsp.vitaesangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifsp.vitaesangue.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
