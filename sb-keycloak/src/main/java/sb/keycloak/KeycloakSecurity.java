package sb.keycloak;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * seguridad utilizando keycloak.
 *
 * @author Sebastián Ávila A.
 *
 */
@Configuration
@EnableWebSecurity
public class KeycloakSecurity extends KeycloakWebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
    final var kap = keycloakAuthenticationProvider();
    kap.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
    auth.authenticationProvider(kap);
  }

  @Bean
  public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
    return new KeycloakSpringBootConfigResolver();
  }

  @Bean
  @Override
  protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
    return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    super.configure(http);
    http.cors().and().csrf().disable().authorizeRequests().antMatchers("/personas*")
        .hasRole("privilegiado").anyRequest().permitAll();
  }
}
