package ifsp.vitaesangue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.vitaesangue.model.UserDetailsImpl;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.records.auth.LoginRequest;
import ifsp.vitaesangue.records.auth.LoginResponse;
import ifsp.vitaesangue.records.usuario.UsuarioResponse;
import ifsp.vitaesangue.repository.UsuarioRepository;
import ifsp.vitaesangue.services.JwtTokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;	
    
    @GetMapping("/login")
	public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
    	// Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        
        // Gera um token JWT para o usuário autenticado
        LoginResponse reponse = new LoginResponse(jwtTokenService.generateToken(userDetails));
        
        return new ResponseEntity<>(reponse, HttpStatus.OK);
	}
	
}
