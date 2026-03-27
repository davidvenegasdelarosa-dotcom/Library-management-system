# 📖 Gestión de biblioteca - Spring-boot CRUD
  Una aplicación web sencilla y funcional para la gestión de una colección de libros, desarrollada como 
  proyecto de aprendizaje para profundizar en el ecosistema de **Java Spring-boot**.
  
  # 🚀 Funcionalidades:
  * Visualización dinámica: Listado completo de libros con ID (único), título y autor.
  * Operaciones CRUD:
    * Añadir: Formulario con validación para evitar campos vacios.
    * Eliminar: Borrado de registros en tiempo real con JavaScript.
    * Filtrado: Buscador por nombre de autor para localizar libros específicos.
  
  # 🛠️ Tecnologías utilizadas:
  * Backend: Java 17, Spring-boot 3.x
  * Persistencia: Spring Data JPA / hibernate
  * Frontend: Thymeleaf (motor de plantillas), HTML5, CSS3
  * Scripts: JavaScript (AJAX/Fetch) para funciones asíncronas
  * Gestión de dependencias: Maven
  * PostgreSQL: es el motor de la base de datos utilizada

  # 📦 Instalación y ejecución:
  * 1. Es necesario tener instalado Java 17 o superior y PostgreSQL.
  * 2. Ejecutaremos el siguiente comando en la terminal de PostgreSQL: CREATE DATABASE biblioteca_bd;
  * 3. Revisaremos el archivo src/main/resources/application.properties, y nos aseguramos de que spring.datasource.username y spring.datasource.password coinciden      con la configuración de PostgreSQL.
  * 4. Clonamos el repositorio: git clone [https://github.com/davidvenegasdelarosa-dotcom/web-biblioteca.git]
  * 5. Entramos en la carpeta del proyecto: cd name_folder.
  * 6. Lanza la aplicación: .\mvnw.cmd spring-boot:run
  * 7. Abre en tu navegador: http://localhost:8081/libros
