# 🔤 ⭐ ForoHub 
## Descripcion
Este proyecto es una API REST de un Foro desarrollada con SpringBoot que se centra especificamente en los Tópicos ya sea dudas y/o preguntas dentro del foro, permite las funciones básicas del CRUD (CREATE, READ, UPDATE, DELETE):
- Crear un nuevo tópico
- Mostrar todos los tópicos creados
- Mostrar un tópico específico
- Actualizar un tópico
- Eliminar un tópico
  
# Funcionalidades

- API con rutas implementadas siguiendo las mejores prácticas del modelo REST
- Validaciones realizadas según las reglas de negocio
- Implementación de una base de datos relacional para la persistencia de la información
- Servicio de autenticación/autorización para restringir el acceso a la información
- Documentación con Swagger
  
### Diagrama de EER de la base de datos

![basedatos](https://github.com/user-attachments/assets/590eae51-dbaa-45f6-baef-5987be8eca8e)

# 🟠 Demostracion de funciones 

Para hacer la demostracion se uso la aplicacion de insomia, se puede descargar el link https://insomnia.rest/download
### Autenticacion/Autorizacion. 

Para realizar las solicitudes a la API REST se debe de iniciar sesion con usuario y contraseña para autenticarse y obtener el JWT Token que debemos de ingresar en cada solicitud en el encabezado de 
`Authorization`.

![jwtToken](https://github.com/user-attachments/assets/0294e6f4-e0b9-4a7a-b672-422314cd5221)

🔴 403 : Forbidden

Al mostrar este error es porque no se ha introducido el token.

![image](https://github.com/user-attachments/assets/3e8827ea-b629-4ccf-8025-e5fe963fe0f2)


# Probando rutas implementadas: 

  ### Topicos: http://localhost:8080/topicos
  
- ### `Crear nuevo topico`.

  Para crear nuevo topico se uso uso el metodo POST en la URI ' /topicos' con los datos del topico para registrarlo en la base de datos.

  Los datos del tópico (título, mensaje, idAutor y idCurso) deben ser enviados en el cuerpo de la solicitud, en formato JSON. 
  Es estatus obtenido al guardar correctamente los datos es 201 Created.
   
  ![listar](https://github.com/user-attachments/assets/914e40fe-5a96-4192-abfd-0b118ead9d64)
  
  ![image](https://github.com/user-attachments/assets/d9965b20-3280-4560-8ec0-144595069bab)
  
  En el JSON que se muestra despues de registrar el topico, tambien se muestran los datos del curso y del usuario que lo creo.
  
- ### `Listar topicos creados`.
  
  La API debe cuenta con un endpoint para el listado de todos los tópicos, y aceptar solicitudes del tipo GET para la URI /tópicos.
  En respuesta a la solicitud se muestra los datos de cada topico en formato JSON. Se uso la anotacion @Pageable para mostrar los primeros 10 resultados ordenados en ASC.
  
  ☑️ Estatus: 200 OK

  ![image](https://github.com/user-attachments/assets/11cac23a-2cb6-4d7a-afb8-39d6307795e7)

- ### `Mostrar topico en especifico por id`
  
  Por medio del id se verifica si el topico esta registrado en la base de datos, en caso de que si, se retorna como respuesta los datos del topico que se proporciono por el URI     
  http://localhost:8080/topicos/{id}
  
  Metodo: GET
  
  Estatus: ☑️ 200 OK
  
  ![image](https://github.com/user-attachments/assets/6c749a05-13d4-46c3-8516-240ff464f88b)

  🔴 Estatus: 400 BAD REQUEST 

  Al ingresar un id que no existe en la base de datos , se muestra lo siguiente. 
  
  ![image](https://github.com/user-attachments/assets/92ae0158-1009-42ef-b0bb-4fdd3000302b)
  
- ### `Actualizar topico`.
  
  La API cuenta con un endpoint para la actualización de los datos de un determinado tópico, acepta las solicitudes del tipo PUT para la URI /tópicos/{id}.
  
  Se solicita y se verifica el id del topico ingresado en la uri.
  
  ![image](https://github.com/user-attachments/assets/1f99c497-80f4-45e2-aec7-0ce04b7f5c57)

  En caso de que se ingrese un id que no esta registrado en la base de datos se muestra el siguiente mensaje de error.
  
  🔴 Estatus: 400 BAD REQUEST
  
  ![image](https://github.com/user-attachments/assets/266284c8-df5f-4d81-870a-4084fed2a99c)

- ### `Eliminar topico`.
  
  La API cuenta con un endpoint para la eliminacion de un topico, para esto se usa el metodo deleteById del JpaRepository.
  Para eliminar un topico se debe de agregar el id en la uri por ejemplo: http://localhost:8080/topicos/3
  
  Para la demostracion del proyecto se va a eliminar el topico con id 3, listado antes de eliminar el topico.
  
  ![image](https://github.com/user-attachments/assets/6b57fb0a-36c8-4b7f-a168-1cd464aee65a)

  Eliminacion del topico:
  
    🟢 Estatus: 204 Not Content
    
    ![image](https://github.com/user-attachments/assets/9876e729-e29d-43ae-b976-2595dcbd60cd)
    
    Listado después de la eliminación del tópico con id=3:
    
    ![image](https://github.com/user-attachments/assets/b8478d48-51ba-4762-87c1-97a0e4c6f456)
  
    🔴 Estatus: 400 BAD REQUEST
    Si el id que se ingrese en la uri no está registrado en la base de datos se muestra el siguiente mensaje de error.

 ![image](https://github.com/user-attachments/assets/2f72dd8a-209b-4f63-b4c6-e91deeeaf722)

## Documentacion con Swagger 
 
Para la documentación de esta API REST se utilizó la libreria de springdoc-open-api

Se debe de ingresar al liguiente link para visualizar e interactuar : http://localhost:8080/swagger-ui/index.html

### Integración con la interfaz de usuario Swagger

La dependencia springdoc-openapi ya incluye Swagger UI, que nos permite interactuar con nuestra especificación API y probar los endpoints.

Al igual que en insomia se debe de ingresar el token generado al iniciar sesion con un usuario.

![image](https://github.com/user-attachments/assets/d5f0df35-264c-4e0a-a640-92ffcf555aab)

Después de ingresar el token se muestra la siguientes opciones donde se pueden hacer las pruebas con cada controlador del api.

![image](https://github.com/user-attachments/assets/1ab266dc-312c-4cfe-bd2c-9e8f57e357fb)

* Obtener por un topico por id:
  
![image](https://github.com/user-attachments/assets/ab57add4-d212-4d9d-b998-02046a8046bf)

* Actualizar un topico:
  
![image](https://github.com/user-attachments/assets/f7013eb1-1bf8-413c-ac00-260010d7acd3)
 
![image](https://github.com/user-attachments/assets/f2a7495e-6045-4484-983e-83f5b6906ce2)

* Eliminar un topico por id:
  
![image](https://github.com/user-attachments/assets/b8e7f500-438b-4204-8144-74c4601c34bb)

* Obtener listado de topicos registrados:

![image](https://github.com/user-attachments/assets/0f1f0448-0303-401b-849c-a050a70b1d62)

![image](https://github.com/user-attachments/assets/af551a23-3bb4-40dc-9c58-db65c4d5aab1)

* Registrar topico:

![image](https://github.com/user-attachments/assets/2d2c2efd-4855-4729-9cbf-20bb20865caf)

![image](https://github.com/user-attachments/assets/4ed691b6-c3d9-4c10-8103-1d7767c9ec9e)



# Acceso al proyecto

El proyecto se puede clonar o descargar desde este repositorio para después abrirlo en un IDE, por ejemplo, Intenllij IDEA y Eclipse. 
Antes de ejecutar la aplicacion se debe de crear la base de datos y cambiar las variables de entorno establecidas en el archivo ubicado en --> src/main/resources/application.yml

```
spring:
  datasource:
    url: jdbc:mysql://localhost/forohub_api
    username: 'ingrese el nombre de usuario de la base de datos'
    password: 'la contrasenia de la base de datos'
```


# ☑ Tecnologías y dependencias usadas

- Java (versión 17 en adelante)
- Maven
- Spring Boot
- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security
- Insomia (para hacer pruebas de caja blanca)

# Personas desarrolladoras del proyecto

Maria Torres 🐈 @Keatnis
