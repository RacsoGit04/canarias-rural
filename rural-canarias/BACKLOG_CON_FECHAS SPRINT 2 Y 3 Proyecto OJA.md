# BACKLOG CON PLANIFICACIÓN TEMPORAL

## Plataforma de Reservas - Cultura Rural de Canarias

**Equipo:** 3 desarrolladores

**Situación actual:** Pendiente de completar Sprint 2 y Sprint 3

**Próxima entrega:** 23 de febrero de 2025

**Objetivo:** Completar Sprint 2 + Sprint 3 antes de la entrega

---

## PLANIFICACIÓN GENERAL

### Estrategia de recuperación:

**Primera semana (10-16 febrero):** Sprint 2 completo

**Segunda semana (17-23 febrero):** Sprint 3 completo

**Entrega 23 febrero:** Incremento consolidado Sprint 2 + 3

**Siguiente período:** Sprint 4 (planificar después de la entrega)

---

## SPRINT 2 - AUTENTICACIÓN Y GESTIÓN DE USUARIOS

**Período:** 10 febrero - 16 febrero

**Objetivo:** Sistema de registro y login funcional con gestión básica de usuarios

**Estado:** PENDIENTE

---

### PRIMERA SEMANA: SPRINT 2

#### **Inicio de semana (Lunes-Martes): Base de datos y autenticación backend**

| ID            | Tarea                                                              | Responsable   | Deadline | Rama Git                               |
| ------------- | ------------------------------------------------------------------ | ------------- | -------- | -------------------------------------- |
| **WOJA-13.1** | Crear script SQL inicial con tablas `users`, `roles`, `user_roles` | **Persona A** | 10 Feb   | `feature/WOJA-13.1-sql-schema`         |
| **WOJA-13.2** | Crear entidades JPA en Spring Boot (User, Role) con anotaciones    | **Persona B** | 10 Feb   | `feature/WOJA-13.2-jpa-entities`       |
| **WOJA-13.3** | Crear repositorios JPA (UserRepository, RoleRepository)            | **Persona C** | 10 Feb   | `feature/WOJA-13.3-jpa-repos`          |
| **WOJA-26.1** | Backend: Endpoint POST /api/auth/login                             | **Persona A** | 11 Feb   | `feature/WOJA-26.1-login-backend`      |
| **WOJA-26.2** | Backend: Endpoint POST /api/auth/register                          | **Persona B** | 11 Feb   | `feature/WOJA-26.2-register-backend`   |
| **WOJA-26.3** | Backend: Implementar JWT (generación + validación)                 | **Persona A** | 11 Feb   | `feature/WOJA-26.3-jwt-implementation` |
| **WOJA-26.4** | Backend: Middleware de autenticación JWT                           | **Persona C** | 11 Feb   | `feature/WOJA-26.4-jwt-middleware`     |

**Checkpoint:** Backend de autenticación funcional y probado con Postman

---

#### **Mitad de semana (Miércoles-Jueves): Frontend de autenticación**

| ID            | Tarea                                                      | Responsable   | Deadline | Rama Git                             |
| ------------- | ---------------------------------------------------------- | ------------- | -------- | ------------------------------------ |
| **WOJA-26.5** | Frontend: Formulario de login (React + validación)         | **Persona C** | 12 Feb   | `feature/WOJA-26.5-login-form`       |
| **WOJA-26.6** | Frontend: Formulario de registro (React + validación)      | **Persona C** | 12 Feb   | `feature/WOJA-26.6-register-form`    |
| **WOJA-26.7** | Frontend: Context API para gestión de sesión               | **Persona C** | 13 Feb   | `feature/WOJA-26.7-auth-context`     |
| **WOJA-26.8** | Frontend: Protected routes (redirección si no autenticado) | **Persona B** | 13 Feb   | `feature/WOJA-26.8-protected-routes` |
| **WOJA-26.9** | Integración: Conectar login/register con backend           | **Persona C** | 13 Feb   | `feature/WOJA-26.9-integration`      |

**Checkpoint:** Login y registro funcionando end-to-end

---

#### **Viernes: Gestión de usuarios**

| ID            | Tarea                                                   | Responsable   | Deadline | Rama Git                           |
| ------------- | ------------------------------------------------------- | ------------- | -------- | ---------------------------------- |
| **WOJA-31.1** | Backend: Endpoints CRUD para usuarios                   | **Persona A** | 14 Feb   | `feature/WOJA-31.1-user-crud`      |
| **WOJA-31.2** | Backend: Endpoint PUT /api/users/me (actualizar perfil) | **Persona B** | 14 Feb   | `feature/WOJA-31.2-update-profile` |
| **WOJA-31.3** | Frontend: Página de perfil de usuario                   | **Persona C** | 14 Feb   | `feature/WOJA-31.3-profile-page`   |
| **WOJA-31.4** | Frontend: Formulario de edición de perfil               | **Persona C** | 14 Feb   | `feature/WOJA-31.4-edit-profile`   |

---

#### **Fin de semana (Sábado-Domingo): Panel admin y testing**

| ID            | Tarea                                                     | Responsable   | Deadline | Rama Git                             |
| ------------- | --------------------------------------------------------- | ------------- | -------- | ------------------------------------ |
| **WOJA-32.1** | Backend: Endpoints GET/POST/PUT/DELETE para admin         | **Persona A** | 15 Feb   | `feature/WOJA-32.1-admin-endpoints`  |
| **WOJA-32.2** | Backend: Middleware de autorización (verificar rol ADMIN) | **Persona B** | 15 Feb   | `feature/WOJA-32.2-admin-middleware` |
| **WOJA-32.3** | Frontend: Panel de administración - lista de usuarios     | **Persona C** | 15 Feb   | `feature/WOJA-32.3-admin-panel`      |
| **WOJA-32.4** | Frontend: Acciones admin (activar/desactivar usuarios)    | **Persona C** | 15 Feb   | `feature/WOJA-32.4-admin-actions`    |
| **WOJA-47.1** | Tests unitarios de AuthService y UserService              | **Persona A** | 16 Feb   | `feature/WOJA-47.1-unit-tests`       |
| **WOJA-47.2** | Tests de endpoints de autenticación                       | **Persona B** | 16 Feb   | `feature/WOJA-47.2-api-tests`        |
| **WOJA-47.3** | Tests E2E del flujo de login/registro                     | **Rotación**  | 16 Feb   | `feature/WOJA-47.3-e2e-tests`        |

**DEADLINE SPRINT 2: Domingo 16 Feb** - Todo mergeado a `develop`

---

## SPRINT 3 - CATÁLOGO DE ALOJAMIENTOS Y RESERVAS

**Período:** 17 febrero - 23 febrero

**Objetivo:** Catálogo funcional con sistema de reservas completo

**Estado:** PENDIENTE

---

### SEGUNDA SEMANA: SPRINT 3

#### **Inicio de semana (Lunes-Martes): Modelo de alojamientos**

| ID            | Tarea                                                    | Responsable   | Deadline | Rama Git                                  |
| ------------- | -------------------------------------------------------- | ------------- | -------- | ----------------------------------------- |
| **WOJA-14.1** | Backend: Script SQL para tabla `accommodations`          | **Persona A** | 17 Feb   | `feature/WOJA-14.1-accommodations-schema` |
| **WOJA-14.2** | Backend: Entidad JPA Accommodation                       | **Persona B** | 17 Feb   | `feature/WOJA-14.2-accommodation-entity`  |
| **WOJA-14.3** | Backend: AccommodationRepository con queries custom      | **Persona C** | 17 Feb   | `feature/WOJA-14.3-accommodation-repo`    |
| **WOJA-27.1** | Backend: Endpoint GET /api/accommodations (listado)      | **Persona A** | 17 Feb   | `feature/WOJA-27.1-list-endpoint`         |
| **WOJA-27.2** | Backend: Endpoint GET /api/accommodations/{id} (detalle) | **Persona B** | 17 Feb   | `feature/WOJA-27.2-detail-endpoint`       |
| **WOJA-27.3** | Backend: Endpoint POST /api/accommodations (crear)       | **Persona A** | 18 Feb   | `feature/WOJA-27.3-create-endpoint`       |
| **WOJA-27.4** | Backend: AccommodationService con lógica de negocio      | **Persona C** | 18 Feb   | `feature/WOJA-27.4-service`               |

**Checkpoint:** CRUD de alojamientos funcional en backend

---

#### **Martes-Miércoles: Frontend del catálogo**

| ID            | Tarea                                        | Responsable   | Deadline | Rama Git                           |
| ------------- | -------------------------------------------- | ------------- | -------- | ---------------------------------- |
| **WOJA-27.5** | Frontend: Componente AccommodationCard       | **Persona C** | 18 Feb   | `feature/WOJA-27.5-card-component` |
| **WOJA-27.6** | Frontend: Página de lista de alojamientos    | **Persona C** | 19 Feb   | `feature/WOJA-27.6-list-page`      |
| **WOJA-27.7** | Frontend: Página de detalle de alojamiento   | **Persona C** | 19 Feb   | `feature/WOJA-27.7-detail-page`    |
| **WOJA-27.8** | Integración: Conectar frontend con endpoints | **Persona C** | 19 Feb   | `feature/WOJA-27.8-integration`    |

---

#### **Miércoles-Jueves: Filtros y búsqueda**

| ID            | Tarea                                                       | Responsable   | Deadline | Rama Git                            |
| ------------- | ----------------------------------------------------------- | ------------- | -------- | ----------------------------------- |
| **WOJA-29.1** | Backend: Filtros por zona geográfica                        | **Persona A** | 19 Feb   | `feature/WOJA-29.1-zone-filter`     |
| **WOJA-29.2** | Backend: Filtros por rango de precio                        | **Persona B** | 19 Feb   | `feature/WOJA-29.2-price-filter`    |
| **WOJA-29.3** | Backend: Filtros por características (capacidad, servicios) | **Persona A** | 20 Feb   | `feature/WOJA-29.3-features-filter` |
| **WOJA-29.4** | Frontend: Barra de búsqueda y filtros                       | **Persona C** | 20 Feb   | `feature/WOJA-29.4-search-filters`  |
| **WOJA-29.5** | Frontend: Aplicar filtros en tiempo real                    | **Persona C** | 20 Feb   | `feature/WOJA-29.5-apply-filters`   |

**Checkpoint:** Catálogo con filtros funcional

---

#### **Jueves-Viernes: Sistema de reservas**

| ID            | Tarea                                                | Responsable   | Deadline | Rama Git                               |
| ------------- | ---------------------------------------------------- | ------------- | -------- | -------------------------------------- |
| **WOJA-15.1** | Backend: Script SQL para tabla `bookings`            | **Persona A** | 20 Feb   | `feature/WOJA-15.1-bookings-schema`    |
| **WOJA-15.2** | Backend: Entidad JPA Booking                         | **Persona B** | 20 Feb   | `feature/WOJA-15.2-booking-entity`     |
| **WOJA-28.1** | Backend: Endpoint POST /api/bookings (crear reserva) | **Persona A** | 21 Feb   | `feature/WOJA-28.1-create-booking`     |
| **WOJA-28.2** | Backend: Lógica de validación de disponibilidad      | **Persona B** | 21 Feb   | `feature/WOJA-28.2-availability-check` |
| **WOJA-28.3** | Backend: Endpoint GET /api/bookings/my-bookings      | **Persona A** | 21 Feb   | `feature/WOJA-28.3-my-bookings`        |
| **WOJA-28.4** | Frontend: Formulario de reserva (fechas, huéspedes)  | **Persona C** | 21 Feb   | `feature/WOJA-28.4-booking-form`       |
| **WOJA-28.5** | Frontend: Página "Mis Reservas"                      | **Persona C** | 21 Feb   | `feature/WOJA-28.5-my-bookings-page`   |

---

#### **Sábado: Gestión de alojamientos (proveedores)**

| ID            | Tarea                                             | Responsable   | Deadline | Rama Git                                 |
| ------------- | ------------------------------------------------- | ------------- | -------- | ---------------------------------------- |
| **WOJA-33.1** | Backend: Endpoint PUT /api/accommodations/{id}    | **Persona A** | 22 Feb   | `feature/WOJA-33.1-update-accommodation` |
| **WOJA-33.2** | Backend: Endpoint DELETE /api/accommodations/{id} | **Persona B** | 22 Feb   | `feature/WOJA-33.2-delete-accommodation` |
| **WOJA-33.3** | Frontend: Panel de proveedor - mis alojamientos   | **Persona C** | 22 Feb   | `feature/WOJA-33.3-provider-panel`       |
| **WOJA-33.4** | Frontend: Formulario de edición de alojamiento    | **Persona C** | 22 Feb   | `feature/WOJA-33.4-edit-form`            |

---

#### **Domingo: Testing y refinamiento**

| ID              | Tarea                                   | Responsable   | Deadline | Rama Git                                |
| --------------- | --------------------------------------- | ------------- | -------- | --------------------------------------- |
| **WOJA-48.1**   | Tests de AccommodationService           | **Persona A** | 23 Feb   | `feature/WOJA-48.1-accommodation-tests` |
| **WOJA-48.2**   | Tests de BookingService                 | **Persona B** | 23 Feb   | `feature/WOJA-48.2-booking-tests`       |
| **WOJA-48.3**   | Tests E2E del flujo de reserva completo | **Rotación**  | 23 Feb   | `feature/WOJA-48.3-e2e-booking`         |
| **INTEGRACIÓN** | Pruebas finales y corrección de bugs    | **Todos**     | 23 Feb   | N/A                                     |

**DEADLINE SPRINT 3: Domingo 23 Feb** - Todo mergeado a `develop`

---

## DISTRIBUCIÓN DE TRABAJO

### Resumen por desarrollador:

**Persona A (Backend Lead):**

- Enfoque principal en backend y base de datos
- Responsable de endpoints principales y lógica de negocio
- Testing de servicios backend

**Persona B (Backend/Integration):**

- Trabajo en backend complementario
- Integración entre componentes
- Middleware y seguridad
- Testing de APIs

**Persona C (Frontend Lead):**

- Todo el desarrollo frontend React
- Integración frontend-backend
- Diseño de componentes y páginas
- Experiencia de usuario

---

## NOTAS IMPORTANTES

### Gestión de riesgos:

**Tareas críticas (no se pueden saltar):**

- WOJA-13.x (Base de datos)
- WOJA-26.x (Autenticación)
- WOJA-27.x (Catálogo)
- WOJA-28.x (Reservas)

**Tareas opcionales (si hay retrasos):**

- WOJA-32.x (Panel admin) → puede reducirse funcionalidad
- Tests E2E → pueden hacerse más simples
- WOJA-33.4 (Edición de alojamientos) → puede posponerse

### Code Review:

- **Tiempo de respuesta:** Revisar PRs lo antes posible
- **Revisor asignado:** Rotar entre compañeros
- **Aprobación mínima:** 1 persona diferente al autor

### Checkpoints importantes:

- **11 Feb:** Backend autenticación funcional
- **13 Feb:** Login/registro end-to-end
- **16 Feb:** Sprint 2 completo
- **18 Feb:** CRUD alojamientos backend
- **20 Feb:** Catálogo con filtros
- **23 Feb:** Sprint 3 completo
