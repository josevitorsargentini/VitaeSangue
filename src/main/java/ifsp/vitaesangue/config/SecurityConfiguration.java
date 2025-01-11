package ifsp.vitaesangue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ifsp.vitaesangue.filter.UserAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
    private UserAuthenticationFilter userAuthenticationFilter;
	
	public static final String[] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
		    "/auth/login",
		    "/solicitacaoacesso",
		    "/swagger-ui/**",            // Todos os recursos do Swagger UI
		    "/webjars/**",               // Arquivos do Swagger UI em WebJars
		    "/v3/api-docs/**",            // Endpoints de documentação do Swagger
		    "/h2-console/**",            // Garante que todos os subcaminhos de /h2-console/** sejam liberados
		};

	  
	  	@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	        return httpSecurity.csrf().disable()
	                .headers().frameOptions().sameOrigin().and() 
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                .and().authorizeHttpRequests() 
	                .requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).permitAll()
	                .anyRequest().authenticated()
	                .and().addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
	                .build();
	    }

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
