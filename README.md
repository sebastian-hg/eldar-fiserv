# Proyecto de prueba
Implementación de un e-commerce de ejemplo

## Sobre este proyecto
proyecto realizado y pensado validar datos sobre tarjetas de credito, 
en Fiserv, logrando validar por fecha de vencimientos, montos de transacciones, obtener datos generales.
### Tecnologias utilizadas:
* Spring Boot
* Postgresql
* Maven
* JDK 17

### Consultas
* Sebastian Hernández (sebastianhg479@gmail.com)

## Ejecución de la aplicación
### Tests

./mvnw test

### Ambiente local
dentro de la raiz del proyecto se encuentra el dockerFile de la app para generar la imagen y el docker-compose 
para levantar el servicio de manera local, de manera tal que al ingresar a la app por consola debera ejecutar los
siguiente comandos:

docker_compose build java_app -> este creara la imagen de la app localmente

docker-compose up -> levanta los servicios, gerando el container localmente

IMPORTANTE: en caso de tener un servicio o servidor localmente de postgres puede causar error al momento de levantar
el contenedor, por favor para el servicio con el comando :
sudo systemctl stop  postgresql

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


