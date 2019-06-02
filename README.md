# Spring boot + React + Keycloak

Este proyecto está formado por 3 componentes:
- Spring boot en el backend ([https://github.com/sebastian4j/spring-keycloak/tree/master/sb-keycloak](https://github.com/sebastian4j/spring-keycloak/tree/master/sb-keycloak))
- React para la vista ([https://github.com/sebastian4j/react/tree/master/keycloak-react](https://github.com/sebastian4j/react/tree/master/keycloak-react))
- Keycloak para la seguridad ([https://github.com/sebastian4j/vertx-keycloak-jwt](https://github.com/sebastian4j/vertx-keycloak-jwt), [https://github.com/sebastian4j/demo-microprofile-starter](https://github.com/sebastian4j/demo-microprofile-starter))


### Configuración:
* En Keycloak en necesario crear el Realm llamado sso
* Luego crear un cliente llamado cliente-uno para react junto con la configuración de las url de acceso
* Y un cliente cliente-dos para spring boot junto con la configuración de las url de acceso
* Crear el grupo user
* También un usuario que esté asociado al grupo user


### Enlace al blog:
https://javasofias.blogspot.com/2019/06/spring-boot-spring-security-react.html