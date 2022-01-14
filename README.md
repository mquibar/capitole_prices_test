# Evaluación Técnica Consulta De Precios
## Prueba Tecnica Manuel Quibar

### Tecnología utilizada

Java 11	

Spring Boot 3.6.2	

Swagger 3.0

Lombok

Base de Datos H2

### Sobre el Proyecto

Se implemento clean architecture bajo una arquitectura hexagonal, lo que nos brinda un bajo acomplamiento y una mayor escalabilidad,
y al estar orientado a casos de uso facilita los tests unitarios.

Se implementaron test unitarios con mockito y test de integracion con llamadas a mockmvc,

Una vez levantado el servicio se puede acceder a la documentacion a travez de swagger accediento a: [HOST]:8080/swagger-ui/index.html#

Para el loggeo del endpoint se utilizo AOP permitiendo independizar el controller del loggeo

