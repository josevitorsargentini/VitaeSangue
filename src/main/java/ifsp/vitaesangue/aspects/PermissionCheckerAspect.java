package ifsp.vitaesangue.aspects;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ifsp.vitaesangue.annotations.RequiredPermission;
import ifsp.vitaesangue.model.Permissao;
import ifsp.vitaesangue.model.ResourcesAllow;
import ifsp.vitaesangue.model.TipoAcaoHistorico;
import ifsp.vitaesangue.model.Usuario;
import ifsp.vitaesangue.repository.UsuarioRepository;

@Aspect
@Component
public class PermissionCheckerAspect {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Pointcut("@annotation(ifsp.vitaesangue.annotations.RequiredPermission)")
	public void checkRequiredPermissionPointcut() {}

	@Before("checkRequiredPermissionPointcut() && @annotation(RequiredPermission)")
	public void checkPermission(RequiredPermission requiredPermission) throws Exception {
		 String email = SecurityContextHolder.getContext().getAuthentication().getName();

		 ResourcesAllow resource = requiredPermission.resource();
	     TipoAcaoHistorico action = requiredPermission.action();
	        
	     Usuario user = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
	        
	     boolean hasPermission = user.getPerfil().getPermissoes().stream()
	                .filter(permission -> permission.getController().equals(resource)) 
	                .anyMatch(permission -> hasActionPermission(permission, action)); 
	     	        
	     if (!hasPermission) {
	    	 throw new SecurityException("Usuário não tem permissão para acessar este recurso.");
	     }
	 }	
	
	 private boolean hasActionPermission(Permissao permissao, TipoAcaoHistorico action) {
	        switch (action) {
	            case CREATE:
	                return permissao.getCriacao();  // Verifica permissão de criação
	            case READ:
	                return permissao.getVisualizacao();    // Verifica permissão de leitura
	            case UPDATE:
	                return permissao.getAtualizacao();  // Verifica permissão de atualização
	            case DELETE:
	                return permissao.getDeletar();  // Verifica permissão de exclusão
	            default:
	                throw new UnsupportedOperationException("Ação não suportada: " + action);
	        }
	    }
}
