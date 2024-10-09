# Proyecto de Gestión de Notas

## Tecnologías Utilizadas:

### Backend:
- Spring Boot (Java 17)
- MySQL (Base de datos)
- JPA (Java Persistence API)

### Frontend:
- React (con Vite)
- Axios (para la comunicación con la API)
- Material UI (para el diseño de la interfaz)

## Funcionalidades:
- Agregar nuevas notas proporcionando nombre de estudiante, actividades, parciales y examen final.
- Ver todas las notas en una lista con su información completa.
- Editar la información de una nota existente.
- Eliminar notas.
- Calcular el puntaje total automáticamente.

## Instrucciones para la Instalación y Ejecución:

### Backend (Spring Boot)

**1. Clona el repositorio:**
git clone https://github.com/Sebasmiumg/PROYECTOINDIVUAL2-DEFINITIVO.git

**2. Dirígete al directorio del backend:**
cd PROYECTOINDIVUAL2-DEFINITIVO/demo

**3. Configura la base de datos MySQL. Asegúrate de que el archivo `application.properties` tenga la configuración adecuada:**
spring.application.name=demo spring.datasource.url=jdbc:mysql://localhost:3306/nueva_base_notas 
spring.datasource.username=root spring.datasource.password=tu_contraseña 
spring.jpa.hibernate.ddl-auto=update spring.jpa.show-sql=true

**4. Compila y ejecuta el proyecto:**
mvn spring-boot

**5. El backend correrá en `http://localhost:8080`.**

### Frontend (React con Vite)

**1. Dirígete al directorio del frontend:**
cd PROYECTOINDIVUAL2-DEFINITIVO/frontend

**2. Instala las dependencias:**
npm install

**3. Inicia el servidor de desarrollo:**
npm run dev

El frontend estará disponible en `http://localhost:5173`.

## Capturas de Pantalla
A continuación, se presentan algunas capturas de pantalla de la aplicación:

**1.** **Formulario para agregar una nueva nota**
   <img width="959" alt="image" src="https://github.com/user-attachments/assets/e08f0324-da97-429d-8aec-2353aa50584a">

**2.** **Lista de notas registradas**
 <img width="407" alt="image" src="https://github.com/user-attachments/assets/acac0690-f6e5-4995-ae95-8e393081917e">
<img width="958" alt="image" src="https://github.com/user-attachments/assets/44f941e6-3d06-4e10-9de6-9b4c50ab2ddb">

**3.** **Prueba de la API con Postman**
<img width="959" alt="image" src="https://github.com/user-attachments/assets/a3fa24c7-6695-4fde-8357-1bfb475ad6cb">
<img width="959" alt="image" src="https://github.com/user-attachments/assets/fa0029bb-c698-4be1-86a6-d9be18111248">

## Despliegue

Para el despliegue en producción, asegúrate de que tu servidor tenga Java, MySQL y Node.js instalados. Sigue los mismos pasos mencionados anteriormente para ejecutar tanto el backend como el frontend.






