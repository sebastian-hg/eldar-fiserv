# Proyecto de prueba
Implementación de un e-commerce de ejemplo

## Sobre este proyecto
proyecto realizado y pensado validar datos sobre tarjetas de credito, 
en Fiserv, logrando validar por fecha de vencimientos, montos de transacciones, obtener datos generales.
### Tecnologias utilizadas:
* Spring Boot
* h2
* Maven
* JDK 17

### Consultas
* Sebastian Hernández (sebastianhg479@gmail.com)

## Ejecución de la aplicación
### Tests

./mvnw test

### Ambiente local
ejectar el siguien comando para levantar por consola

./mvnw spring-boot:run

El servidor levantará en el puerto 8100.

### Postman
Importar la colección de postman que se encuentra en la carpeta /postman, donde podran probar todos los endpoints
disponibles de la app


### Datos para probar 

en la raiz del proyecto se encuenta un archivo data.sql, este al momento de levantar la aplicacion 
genera una serie de inserts en la base de datos para poder generar pruebas, los datos de los mismos son:
- 4540730045321266 Visa
- 5895620045321266 Amex
- 3766317300453212 Naranja


