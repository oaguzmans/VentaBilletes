Readme reto automatización portal Vueling

Tabla de contenido

1. Introducción
2. Requerimientos
3. Casos automatizados
4. Archivo para data
5. Navegador
6. Utilidades



 (lenguaje, Framework, IDE, etc.)  co.com.Vueling

1. Introducción

El proyecto elaborado consiste en la creación de una solución automatizada que brinda la posibilidad de ingresar al portal de Vueling y hacer la busqueda de un billete ida y seleccionar una de la opciones que ofrece el portal al azar luego seleccionar una tarifa y aplicar.

El patron de diseño implementado fue POM integrando Selinium, Serenity y Cucumber en un arquetipo Maven,  el IDE utilizado fue Intellij Idea y el lenguaje de programación fue Java. Se utilizó lenguaje Gherkin en la redacción del caso de prueba  


2. Requerimientos

Para la construcción de este proyecto se utilizaron las siguientes herramientas
 - Java 8 version 1.8.0_202
 - Maven version 3.6.3
 - Serenity version 2.3.12
 - Cucumber version 6.6.0
 - Intellij Idea 2023.1 (Community edition) 


3. Caso automatizado

 El caso automatizado se encuentra en el feature llamado VentaBilletes.  


4. Archivo para data

Para el caso incluido en el archivo VentaBilletes.feature  la data se provee desde un archivo externo creado en Excel, este archivo se encuentra inmerso
en el codigo fuente y puede ser accedido y modificado por el usuario final. Para  este caso la data se colocó directamente en la tabla Examples del feature.

5. Navegador

El navegador coinfigurado para este proyecto es Google chrome 

6. Utilidades

Para facilitar la reutilización de código se creó una clase llamada Utils en la cual se alojarón los métodos de interacción con los objetos de la página
como cajas de texto, botones y listas desplegables.

 
