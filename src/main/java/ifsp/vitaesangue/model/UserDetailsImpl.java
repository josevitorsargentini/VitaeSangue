package ifsp.vitaesangue.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

    private Usuario usuario; 
    
    public UserDetailsImpl(Usuario user) {
        this.usuario = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(usuario.getPerfil().getNome()));
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    } 

    @Override
    public String getUsername() {
        return usuario.getEmail().toString();
    } 

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}