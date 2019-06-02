package sb.keycloak;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sebastián Ávila A.
 *
 */
@SpringBootApplication
@RequestMapping
@CrossOrigin(allowCredentials="true")
public class SbKeycloakApplication {

  @GetMapping(path = "/")
  public ResponseEntity<Persona> saludo() {
    return ResponseEntity.ok(new Persona(3, "tres"));
  }

  @GetMapping(path = "/personas")
  public ResponseEntity<List<Persona>> customers(final Principal principal, final Model model) {
    final var personas = new ArrayList<Persona>();
    personas.add(new Persona(1, "uno"));
    personas.add(new Persona(2, "dos"));
    return ResponseEntity.ok(personas);
  }

  public static void main(final String[] args) {
    SpringApplication.run(SbKeycloakApplication.class, args);
  }

}
