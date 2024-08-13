# Conceptos Fundamentales

### ¿Qué es un servicio REST?

Un servicio REST (Representational State Transfer) es una arquitectura de comunicación que utiliza HTTP para interactuar con recursos a través de URLs, siguiendo los principios RESTful.

### ¿Cuáles son los principios del diseño RESTful?

1. **Estateless:** Cada solicitud del cliente al servidor debe contener toda la información necesaria para entender y procesar la solicitud.
2. **Client-Server:** La separación entre cliente y servidor permite que cada uno evolucione de manera independiente.
3. **Cacheable:** Las respuestas deben ser explícitamente marcadas como cacheables o no cacheables para mejorar el rendimiento.
4. **Uniform Interface:** Una interfaz uniforme simplifica y desacopla la arquitectura.
5. **Layered System:** La arquitectura puede estar compuesta por capas que oculten la complejidad del sistema.

### ¿Qué es HTTP y cuáles son los métodos HTTP más comunes?

HTTP (Hypertext Transfer Protocol) es el protocolo de comunicación utilizado en la web para la transmisión de datos. Los métodos HTTP más comunes son:

- **GET:** Recupera datos del servidor.
- **POST:** Envía datos al servidor para crear o actualizar un recurso.
- **PUT:** Actualiza un recurso existente en el servidor.
- **DELETE:** Elimina un recurso del servidor.

### ¿Qué es un recurso en el contexto de un servicio REST?

Un recurso es una entidad o información que puede ser accedida o manipulada a través de una URL en un servicio REST.

### ¿Qué es un endpoint?

Un endpoint es una URL específica que expone un recurso o un conjunto de recursos en un servicio REST.

## Estructura de un Servicio REST

### ¿Qué es un URI y cómo se define?

Un URI (Uniform Resource Identifier) es una cadena que identifica de manera única un recurso en la web. Se define como `http://dominio/recurso`, donde `dominio` es el nombre del servidor y `recurso` es la ruta al recurso específico.

### ¿Qué es una API RESTful?

Una API RESTful es una interfaz de programación que sigue los principios REST para permitir la comunicación entre sistemas a través de HTTP.

### ¿Qué son los códigos de estado HTTP y cómo se usan en REST?

Los códigos de estado HTTP indican el resultado de una solicitud realizada al servidor. Se utilizan en REST para informar al cliente sobre el éxito o fracaso de una solicitud.

#### Tabla de códigos HTTP de respuesta más comunes

| Código | Significado                                                        |
| ------ | ------------------------------------------------------------------ |
| 200    | OK - La solicitud fue exitosa.                                     |
| 201    | Created - Recurso creado con éxito.                                |
| 204    | No Content - Solicitud exitosa pero sin contenido en la respuesta. |
| 400    | Bad Request - Solicitud inválida.                                  |
| 401    | Unauthorized - Falta de autenticación.                             |
| 403    | Forbidden - Acceso prohibido.                                      |
| 404    | Not Found - Recurso no encontrado.                                 |
| 500    | Internal Server Error - Error en el servidor.                      |

### ¿Qué es JSON y por qué se usa comúnmente en APIs REST?

JSON (JavaScript Object Notation) es un formato de intercambio de datos ligero y fácil de leer por humanos. Se usa comúnmente en APIs REST porque es fácil de parsear y generar, y es compatible con muchos lenguajes de programación.
