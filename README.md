# Proyecto multiplataforma Saecio Climbing

## Descripción del proyecto
El siguiente proyecto contiene código para una página web, un servicio Restful y una aplicación para controlar el servicio Restful.

### Saecio Climbing, página web
Saecio Climbing es el nombre principal de este proyecto, el cuál también se usa para la página web. Dicha página es un portal de escalada, un archivo para visualizar los sectores y las vías de la provincia que podemos encontrar en entornos naturales, además de un pequeño recuerdo histórico de las hazañas de los y las montañeros de nuestra tierra. También cuenta con opciones para que los usuarios puedan crear una cuenta y registrar sus ascensiones, pudiendo así compartir con el resto de usuarios sus avances basándose en un sistema de clasificación específico conocido como sistema redpoint.

### La API con el servicio Restful
Para poder controlar los datos que se vuelcan a la página web se desarrolla un servicio Restful que conecta a una base de datos. Esta base de datos contiene la información de sierras, zonas, sectores, vías, usuarios, aperturistas y ascensiones, todo lo necesario para que la página sea funcional.

### La aplicación para controlar la API
Por último, se presenta una aplicación con una interfaz gráfica que se conectará al servicio Restful y desde donde se podrá controlar la base de datos realizando operaciones básicas como añadir, eliminar o modificar entradas. Así se pueden renovar los datos para que la página web pueda crecer según las necesidades de la comunidad escaladora, y también para poder moderar a los usuarios.

## Desarrollo del proyecto
La página web se construye desde cero haciendo uso de HTML, CSS y Javascript puro, así como jQuery en alguna ocasión. Los iconos vienen de parte de Font Awesome y hay un elemento llamado carrusel, desarrollado por Ken Wheeler

## Despliegue
### Servicio Restful, base de datos y servidor web
En una Raspberry Pi, usando Apache para el servidor web. Todo se construye en Docker por capas, y la Raspberry hace uso de Raspian como sistema operativo.

### Interfaz
Con Maven

## Construído con
- IntelliJ idea
- Visual Studio Code
- Java 17
- JavaFX
- Spring Boot
- MySQL
- HTML, CSS y Javascript
- jQuery

## Versionado
Fase beta

## Autores
### Desarrollo del código
Pepe Hinojo Caparrós

### Logo de la página
[Pierre-Louis Anceau](https://www.behance.net/planceau)

# Licencias
