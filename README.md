# Backend de aplicación de un arquetipo con Spring Boot

## Descripción del proyecto
Es un arquetipo de un proyecto en angular con una 3 funcionalidade básicas
	* Un servicio de registro público que puede llamar todo el mundo
	* Un servicio para login también público
	* Un servicio para extraer todos los usuarios de la base de datos. Este sí está securizado y es necesario tener token para llamarlo
	

## Punto de partida

Las siguientes instrucciones te permitirán tener una copia de este proyecto corriendo en tu máquina local con fines de desarrollo y testeo. Para tener este proyecto instalado en un entorno de PRE o PROducción, hay que seguir las indicaciones de CD/CI.

### Prerequisitos

* Java 1.8
* Maria DB 10.5.X
* Para que la aplicación pueda funcionar es necesario ejecutar el script ubicado en [sql](https://git.intef.es/rea-de-aprendizaje-a-lo-largo-de-la-vida/cve/backend/-/tree/PRE/src/main/resources/sql) llamado creacion_aula_mentor.sql
* Para actualizar la bbdd a su ultima versión es necesario ejecutar de forma secuencial los scripts ubicados en [updates-sql](https://git.intef.es/rea-de-aprendizaje-a-lo-largo-de-la-vida/cve/backend/-/tree/PRE/src/main/resources/sql/updates-sql)

### Instalación

Definir el proceso de instalación del código 


## Realizar el plan de pruebas

La realización de las pruebas se hará acorde a los procedimientos de CD/CI

### Tests según metodología *end-to-end*



### Tests de calidad de código


Entre otras herramientas se puede utilizar SonarQube a través de sus plugins: * [https://docs.sonarqube.org/display/PLUG/Plugin+Library](https://docs.sonarqube.org/display/PLUG/Plugin+Library)

## Despliegue

Pasos del despliegue:

1. Ejecutar comando maven install, esto generará un fichero llamado "archetype-X.X.X.jar" en el path "_RUTA_PROYECTO_/target/"
2. Colocar el ejecutable resultante en el servidor donde se va a alojar la aplicación.
3. Modificar el fichero application.properties para tener las configuraciones correctas de BBDD. Lo puedes ubicar donde quieras "_RUTA_FICHERO_PROPERTIES_SOBREESCRIBIR".
4. Ejecutar comando shell java -jar "archetype-X.X.X.jar" --spring.config.location="_RUTA_FICHERO_PROPERTIES_SOBREESCRIBIR"

## Compilado con

Maven

## Versionado

Usar el versionado que se desee

## Autores

Modificarlo

## Licencia

Este proyecto se encuentra licenciado bajo * [EUPL](https://eupl.eu/1.2/es/) 

## Reconocimientos

