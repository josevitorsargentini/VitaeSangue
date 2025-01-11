package ifsp.vitaesangue.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ifsp.vitaesangue.model.UserDetailsImpl;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return new UserDetailsImpl(user);
    }

}