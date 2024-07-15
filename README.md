# ForoHub Challenge Alura

## Introducción
ForoHub es un proyecto de foro desarrollado como una API REST utilizando Spring Boot y otras tecnologías de Java. El objetivo de este proyecto es proporcionar una plataforma donde los usuarios puedan registrarse, iniciar sesión, crear y participar en discusiones a través de tópicos y respuestas.

## Índice
- [Desarrollo del Proyecto](#Desarrollo-del-proyecto)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Acerca del Desarrollador](#acerca-del-desarrollador)

## Desarrollo del Proyecto
![Captura de Pantalla de ForoHub](/BD_Un_Topico.png)
En la imagen de arriba puede apreciar que solo hay un tópico en la base de datos. La idea es hacer un login y luego crear un tópico.

![Captura de Pantalla de ForoHub](/Login_Insomnia.png)
Aquí realizamos el login con Insomnia, sobre un usuario ya creado, y podemos ver que nos debuelve el Token para validar.

![Captura de Pantalla de ForoHub](/Crear_Topico.png)
En la imagen de arriba podemos ver cómo se crea el tópico y que la respuesta es un 200 OK.

![Captura de Pantalla de ForoHub](/Obtener_Topicos.png)
Aquí podemos ver los dos topicos de la base de datos, una creado anteriormente y otro, el de Id = 3, creado recientemente. Es Id 3 dado que antes hice una prueba para fijarme que esté todo correcto.

![Captura de Pantalla de ForoHub](/Actualizar_Topico.png)
En esta imagen podemos ver cómo actualizamos la Topico. Arriba en la iderección vemos el Id, en este caso el 3, y vemos cómo el la respuesta es un 200 OK.

![Captura de Pantalla de ForoHub](/BD_Topico_Actualizado.png)
Aquí podemos ver la Base de Datos, donde vemos cómo se actualizó el tópico de Id numero 3.

![Captura de Pantalla de ForoHub](/Borrar_Topico.png)
En esta imagen podemos ver la solicitud DELETE en insmonia, apreciando que tiene el token de verificacion y el Id 3 en la direccion.

![Captura de Pantalla de ForoHub](/BD_Borrar_Topico.png)
En esta última imagen podemos ver cómo se borró exitosamente de la base de datos, y se puede apreciar la hora, abajo a la derecha.


## Tecnologías Utilizadas
ForoHub se ha desarrollado utilizando las siguientes tecnologías y librerías:
- Java 17
- Spring Boot
- Maven
- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security

## Acerca del Desarrollador
Soy Jeremías Huber Beisel, disfruté mucho realizando este proyecto. En la actualidad estoy intentando realizar un cambio de rubro en mi vida, hacia el sector tecnológico. La verdad fué muy desafiante este proyecto y si bien aprendí mucho aún me queda más por aprender. Dado que trabajo en otro rubro, me ocurrio que pensé el proyecto completo, pero por falta de tiempo y algunas razones personales, no llegué a completarlo. El proyrcto queda abierto a todo aquel que lo desee usar, estudiar, etc. Gracias AluraLatam y Gracias Oracle Next Education por esta oportunidad.
