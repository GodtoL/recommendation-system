# Proyecto de Microservicios de Recomendación de Productos

Este proyecto implementa un sistema básico de microservicios que recomienda productos a usuarios. Fue desarrollado como una práctica de aprendizaje para comprender la arquitectura de microservicios, la comunicación entre servicios, y la implementación de conceptos básicos como `Circuit Breaker` y `Service Discovery` con Eureka.

## Arquitectura del Proyecto

El proyecto está compuesto por los siguientes microservicios:

- **microservice-config**: Servicio de configuración centralizada para todos los microservicios, facilitando la gestión de configuraciones.
- **microservice- eureka**: Servicio de descubrimiento (Eureka) que permite registrar y localizar los microservicios.
- **microservice-inventory**: Microservicio de inventario que gestiona la disponibilidad de productos.
- **microservice-recommendation**: Servicio que genera recomendaciones de productos basadas en el perfil del usuario.
- **microservice-users**: Servicio que gestiona la información y preferencias de los usuarios.

## Tecnologías y Herramientas

- **Java**: Lenguaje de programación principal del proyecto.
- **Spring Boot**: Framework utilizado para construir y ejecutar cada microservicio.
- **Eureka**: Servicio de descubrimiento que permite la comunicación entre microservicios.
- **Circuit Breaker**: Implementado para gestionar fallos y prevenir la sobrecarga de servicios.
- **Maven**: Utilizado para la gestión de dependencias y la construcción del proyecto.

## Características

- **Sistema de Recomendación Básico**: Basado en las preferencias del usuario, el servicio de recomendación sugiere productos disponibles en el inventario.
- **Circuit Breaker**: Implementado en los microservicios críticos para manejar fallas y mantener el sistema estable.
- **Descubrimiento de Servicios**: Los microservicios se registran en Eureka para permitir la comunicación entre ellos.
- **Configuración Centralizada**: El microservicio de configuración permite gestionar de forma centralizada los parámetros de los otros microservicios.

## Instalación y Configuración

1. Clona este repositorio:
    ```bash
    git clone https://github.com/GodtoL/recommendation-system
    ```
2. Navega a cada carpeta de los microservicios y construye los artefactos usando Maven:
    ```bash
    cd microservice-nombre
    mvn clean install
    ```
3. Ejecuta cada microservicio en el siguiente orden:
    - **microservice-config**
    - **microservice-eureka**
    - **microservice-inventory**
    - **microservice-recommendation**
    - **microservice-users**
4. Accede al servicio Eureka en `http://localhost:8761` para ver los microservicios registrados.

## Uso

1. Agrega usuarios y sus preferencias en el servicio **microservice-users**.
2. Consulta recomendaciones para los usuarios en el servicio **microservice-recommendation**.
3. Observa la interacción entre los microservicios en el panel de Eureka.

## Contribución

Este proyecto es de código abierto y cualquier contribución es bienvenida. Por favor, crea una "issue" antes de realizar cambios importantes.

## Contacto

Proyecto desarrollado por Elías Vera.
