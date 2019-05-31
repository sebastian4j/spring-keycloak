package sb.keycloak;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@RequestMapping
public class SbKeycloakApplication {
  @GetMapping(path = "/customers")
  @ResponseBody
  public ResponseEntity<List<Persona>> customers(Principal principal, Model model) {
    final var personas = new ArrayList<Persona>();
    personas.add(new Persona(1, "uno"));
    personas.add(new Persona(2, "dos"));
    return ResponseEntity.ok(personas);
  }

  public static void main(String[] args) {
    SpringApplication.run(SbKeycloakApplication.class, args);
  }

}
