# Backend – Control de Ingreso y Egreso de Personal

## Descripción
API REST desarrollada en Java para registrar y gestionar el ingreso y egreso de empleados. 
Proyecto backend sin interfaz gráfica, probado mediante Postman.


## Tecnologías utilizadas
- Java 17
- Spring Boot
- Maven
- JPA / Hibernate
- MySQL

## Funcionalidades
- Alta y baja de empleados
- Registro de ingreso
- Registro de egreso
- Consulta de registros por empleado

## Cómo ejecutar el proyecto
1. Clonar el repositorio
2. Configurar la base de datos en `application.properties`
3. Ejecutar la aplicación

## Endpoints principales
- POST /employees/create
- POST /check-in/{dni}
- POST /check-out/{dni}
- GET /reports/monthly?month=10&year=2025

## Autor
Romina Baglivo
Backend Developer Junior

## Ejemplos de uso (Postman)

### Crear empleado
![Crear empleado](docs/postman/create-empleado.png)

### Registrar ingreso
![Ingreso](docs/postman/ingreso.png)

### Registrar egreso
![Egreso](docs/postman/egreso.png)

### Consultar registros
![Registros](docs/postman/registros.png)
