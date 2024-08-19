# Sección 1: Introducción a Servicios en Quarkus

### ¿Qué es `@ApplicationScoped` en Quarkus?

`@ApplicationScoped` es una anotación en Quarkus que define el ciclo de vida de un bean. Los beans anotados con `@ApplicationScoped` son instanciados una vez por la aplicación y se mantienen durante todo el tiempo que la aplicación esté en ejecución. Esto asegura que se comparte una única instancia del bean entre todos los usuarios.

### ¿Cómo funciona la inyección de dependencias en Quarkus?

La inyección de dependencias en Quarkus sigue el modelo CDI (Contexts and Dependency Injection). Quarkus administra los beans y sus dependencias, creando instancias de ellos cuando es necesario y los inyecta en los puntos de uso, como en controladores o servicios. Esto facilita la reutilización de componentes y el desacoplamiento del código.

### ¿Cuál es la diferencia entre `@ApplicationScoped`, `@RequestScoped`, y `@Singleton` en Quarkus?

- **`@ApplicationScoped`**: Una instancia del bean es creada y compartida durante todo el ciclo de vida de la aplicación.
- **`@RequestScoped`**: Una nueva instancia del bean es creada para cada solicitud HTTP y destruida al finalizar la solicitud.
- **`@Singleton`**: Similar a `@ApplicationScoped`, crea una única instancia del bean para toda la aplicación, pero es administrado por el contenedor directamente y no es parte de CDI.

### ¿Cómo se define un servicio en Quarkus utilizando `@ApplicationScoped`?

Un servicio en Quarkus se define utilizando la anotación `@ApplicationScoped` sobre la clase del servicio. Esto indica que la clase tendrá una única instancia que será compartida a través de la aplicación.

```java
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyService {
    // Lógica del servicio
}
```

### ¿Por qué es importante manejar correctamente los alcances (scopes) en Quarkus al crear servicios?

Manejar correctamente los _scopes_ es crucial para garantizar el uso eficiente de los recursos y evitar problemas como la fuga de memoria o la creación innecesaria de instancias. Por ejemplo, un `@RequestScoped` puede ser útil para servicios que manejan datos de usuario temporal, mientras que un `@ApplicationScoped` es más adecuado para servicios que deben mantenerse a lo largo del ciclo de vida de la aplicación.

# Sección 2: Creación de un ApiResponse Genérico

### ¿Qué es un ApiResponse genérico y cuál es su propósito en un servicio REST?

Un `ApiResponse` genérico es una clase que envuelve la respuesta del servidor y estructura los datos en un formato consistente. Su propósito es estandarizar las respuestas de la API, facilitando la gestión de errores y éxitos de manera uniforme en todos los endpoints del servicio REST.

### ¿Cómo se implementa una clase ApiResponse genérica en Quarkus?

Se puede implementar una clase `ApiResponse` genérica utilizando plantillas de tipo (generics) para encapsular datos y mensajes de estado:

```java
public class ApiResponse<T> {
    private String message;
    private T data;
    private boolean success;

    // Constructor, getters, y setters

    public ApiResponse(String message, T data, boolean success) {
        this.message = message;
        this.data = data;
        this.success = success;
    }
}
```

### ¿Cómo se modifica un recurso REST en Quarkus para que utilice un ApiResponse genérico?

Para modificar un recurso REST en Quarkus y utilizar `ApiResponse`, se debe devolver la respuesta envuelta en esta clase genérica. Un ejemplo podría verse así:

```java
@Path("/example")
public class ExampleResource {

    @GET
    public ApiResponse<String> getResponse() {
        return new ApiResponse<>("Operation successful", "Hello, World!", true);
    }
}

```

### ¿Qué beneficios ofrece el uso de un ApiResponse genérico en términos de mantenimiento y consistencia de código?

El uso de un `ApiResponse` genérico ofrece varios beneficios:

- **Mantenimiento**: Permite modificar el formato de las respuestas en un solo lugar, en lugar de hacerlo en múltiples controladores o servicios.
- **Consistencia**: Garantiza que todas las respuestas sigan el mismo formato, mejorando la claridad para los desarrolladores y los consumidores de la API.

### ¿Cómo manejarías diferentes tipos de respuestas (éxito, error, etc.) utilizando la clase ApiResponse?

Se pueden manejar diferentes tipos de respuestas creando métodos estáticos dentro de la clase `ApiResponse` para distintos casos (éxito, error, advertencia, etc.). Un ejemplo podría ser:

```java
public class ApiResponse<T> {
    private String message;
    private T data;
    private boolean success;

    // Constructores, getters y setters

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("Operation successful", data, true);
    }

    public static ApiResponse<Object> error(String message) {
        return new ApiResponse<>(message, null, false);
    }
}

```

# Sección 3: Integración y Buenas Prácticas

### ¿Qué consideraciones se deben tener al inyectar servicios en un recurso REST en Quarkus?

Al inyectar servicios en un recurso REST en Quarkus, es importante tener en cuenta lo siguiente:

- **Scope**: Asegurarse de que el alcance del servicio (`@ApplicationScoped`, `@RequestScoped`, etc.) sea apropiado para evitar problemas de concurrencia o de uso excesivo de recursos.
- **Ciclo de Vida**: Asegurar que los servicios inyectados tengan un ciclo de vida acorde al contexto en el que serán utilizados. Por ejemplo, un servicio que mantiene estado debería tener un alcance más amplio como `@ApplicationScoped`.
- **Inyección de Dependencias**: La inyección de dependencias debe ser eficiente y manejada adecuadamente, evitando la inyección innecesaria de servicios que no se usarán.

### ¿Cómo se pueden manejar excepciones en un servicio REST utilizando ApiResponse?

Para manejar excepciones en un servicio REST utilizando `ApiResponse`, se pueden seguir estos enfoques:

#### Try-Catch Bloques

Dentro del recurso REST, se pueden capturar excepciones específicas o genéricas y devolver una instancia de `ApiResponse` con un mensaje de error y un código de estado HTTP adecuado.

```java
@Path("/example")
public class ExampleResource {

    @GET
    public ApiResponse<String> getResponse() {
        try {
            // Lógica de negocio
            return ApiResponse.success("Hello, World!");
        } catch (Exception e) {
            return ApiResponse.error("An error occurred");
        }
    }
}

```
