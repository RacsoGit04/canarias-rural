# Guía de Contribución y Normas del Equipo

Este documento define cómo vamos a trabajar juntos para evitar romper el código, minimizar conflictos y aprobar la asignatura con nota.

---

## 1. La Regla de Oro

**NADIE hace commit directo a `main` ni a `develop`.**

- La rama `main` es sagrada. Solo contiene código en producción.
- La rama `develop` es para integración. Solo se mergea mediante Pull Requests.
- **Si rompes `main` o `develop`, rompes el trabajo de todos.**

---

## 2. Flujo de Trabajo (Nuestro Gitflow)

Tenemos 3 tipos de ramas:

```
main (producción, protegida)
 develop (integración, protegida)
 feature/WOJA-26-login-backend
 feature/WOJA-27-accommodation-list
 feature/WOJA-29-zone-filter
```

### Proceso completo para cada tarea:

#### **Paso 1: Sincronizarte con `develop`**

Antes de empezar cualquier tarea, bájate lo último de la nube:

```bash
git checkout develop
git pull origin develop
```

#### **Paso 2: Crear tu rama de feature**

Nunca trabajes directamente en `develop`. Crea una rama con este formato:

**Formato:** `feature/WOJA-XX-descripcion-corta`

**Ejemplos:**

- `feature/WOJA-26-login-backend`
- `feature/WOJA-27-accommodation-card`
- `feature/WOJA-29-zone-filter`

**Comando:**

```bash
git checkout -b feature/WOJA-26-login-backend
```

#### **Paso 3: Programa y haz commits frecuentes**

Trabaja normalmente y guarda tus cambios con commits **atómicos** (un commit = un cambio lógico):

```bash
# Ver qué archivos has cambiado
git status

# Añadir archivos al staging
git add src/main/java/com/example/controller/AuthController.java

# Hacer commit con mensaje descriptivo
git commit -m "WOJA-26: Añadir endpoint POST /api/auth/login"

# Continuar trabajando...
git add src/main/java/com/example/service/AuthService.java
git commit -m "WOJA-26: Implementar lógica de autenticación JWT"
```

#### **Paso 4: Subir tu rama a GitHub**

```bash
git push origin feature/WOJA-26-login-backend
```

Si es la primera vez que subes esa rama, Git te dirá que hagas:

```bash
git push --set-upstream origin feature/WOJA-26-login-backend
```

#### **Paso 5: Crear Pull Request**

1. Ve a GitHub
2. Verás un botón verde "Compare & pull request" → Click
3. **IMPORTANTE:** Asegúrate de que el PR va hacia `develop`, NO hacia `main`

- Base: `develop`
- Compare: `feature/WOJA-26-login-backend`

4. Rellena el template del PR (ver sección 6)
5. Asigna a UN compañero como revisor
6. Envía el PR

#### **Paso 6: Esperar aprobación y mergear**

- **Revisor:** Debe revisar el código y aprobar (ver sección 4)
- **Autor:** Una vez aprobado, haz clic en "Merge pull request"
- **Autor:** Borra la rama de feature tras el merge

```bash
# Después del merge, actualiza tu develop local
git checkout develop
git pull origin develop

# Borra tu rama local (ya está mergeada)
git branch -d feature/WOJA-26-login-backend
```

---

## 3. Estándar de Commits

Los mensajes de commit deben ser claros y seguir este formato:

**Formato:** `WOJA-XX: Descripción clara de qué hace el commit`

### MAL:

```bash
git commit -m "arreglando cosas"
git commit -m "cambios"
git commit -m "asd"
git commit -m "funciona"
```

### BIEN:

```bash
git commit -m "WOJA-26: Añadir endpoint POST /api/auth/login"
git commit -m "WOJA-26: Implementar validación de email en AuthService"
git commit -m "WOJA-27: Crear componente AccommodationCard.jsx"
git commit -m "WOJA-29: Añadir filtro por zona en backend"
```

### Prefijos opcionales (si no tienes número de tarea):

- `feat:` para nuevas funcionalidades
- `fix:` para arreglar errores
- `refactor:` para mejorar código sin cambiar funcionalidad
- `docs:` para documentación
- `test:` para añadir tests

**Ejemplos:**

```bash
git commit -m "feat: añadir componente de tarjeta de alojamiento"
git commit -m "fix: solucionar error en el botón de reserva"
git commit -m "docs: actualizar README con instrucciones de Docker"
```

---

## 4. Code Review (Revisiones de Código)

**Ningún código entra a `develop` sin ser aprobado por AL MENOS 1 compañero.**

### Si TÚ subes el código (autor del PR):

1. **Asegúrate de que funciona** antes de abrir el PR:

- El código compila sin errores
- La aplicación arranca (tanto backend como frontend)
- No hay errores en la consola
- Probaste manualmente la funcionalidad

2. **Avisa al equipo:**

- "Chicos, he subido el Login (WOJA-26), ¿puede alguien revisarlo?"
- Asigna a un revisor específico en GitHub

3. **Responde a los comentarios:**

- Si el revisor pide cambios, hazlos
- Comenta y explica si no estás de acuerdo
- Vuelve a notificar cuando hayas hecho los cambios

### Si TÚ revisas el código (revisor del PR):

1. **Lee los cambios:**

- Ve a la pestaña "Files changed"
- Lee el código línea por línea
- ¿Entiendes lo que hace?
- ¿Los nombres de variables tienen sentido?
- ¿Hay código duplicado?

2. **Pruébalo localmente** (si puedes):

```bash
git fetch origin
git checkout feature/WOJA-26-login-backend
# Levantar el proyecto y probar
```

3. **Deja comentarios constructivos:**

- Si ves algo mal, haz clic en la línea y deja un comentario
- Sé específico: "Esta variable debería llamarse `userId` en lugar de `id` para ser más claro"
- No seas destructivo: "Esto está mal" → "¿Qué te parece renombrar esto para que sea más claro?"

4. **Aprobar o pedir cambios:**

- Si todo está bien → "Approve"
- Si hay problemas → "Request changes" y explica qué hay que arreglar
- Si solo son sugerencias → "Comment" (sin bloquear el merge)

---

## 5. Gestión de Conflictos

**"El que llega último, limpia la casa."**

Si GitHub te dice que hay conflictos al intentar mergear tu PR:

### ¿Por qué pasa esto?

Alguien mergeó cambios en `develop` mientras tú trabajabas, y modificaron las mismas líneas que tú.

### ¿Qué hacer?

**Es TU responsabilidad** (el autor del PR) resolver los conflictos:

```bash
# 1. Asegúrate de tener tus cambios guardados
git add .
git commit -m "WOJA-26: guardar cambios antes de resolver conflictos"

# 2. Bájate los últimos cambios de develop
git checkout develop
git pull origin develop

# 3. Vuelve a tu rama
git checkout feature/WOJA-26-login-backend

# 4. Trae los cambios de develop a tu rama
git merge develop

# 5. Git te dirá qué archivos tienen conflictos
# Ábrelos en VS Code - verás marcas como:
# <<<<<<< HEAD
# tu código
# =======
# código de develop
# >>>>>>> develop

# 6. Edita manualmente y decide qué código quedarte
# VS Code te ayuda con botones "Accept Current" / "Accept Incoming"

# 7. Marca los conflictos como resueltos
git add archivo-con-conflicto.java
git commit -m "WOJA-26: resolver conflictos con develop"

# 8. Sube los cambios
git push origin feature/WOJA-26-login-backend
```

### NUNCA hagas:

```bash
git push --force # NUNCA (a menos que sepas MUY BIEN lo que haces)
```

Si tienes dudas, **pide ayuda al equipo antes de hacer force push**.

---

## 6. Definition of Done (¿Cuándo he terminado?)

Una tarea solo se considera terminada si cumple TODO esto:

### Backend:

- El código compila sin errores
- Los endpoints funcionan (probados con Postman/Thunder Client)
- Hay tests unitarios básicos (al menos para la lógica principal)
- No hay warnings en consola
- Pull Request aprobado por 1 compañero
- Código mergeado en `develop`
- Rama de feature borrada

### Frontend:

- El componente renderiza correctamente
- No hay errores en consola del navegador
- No hay warnings de React
- Es responsivo (funciona en móvil y desktop)
- Pull Request aprobado
- Código mergeado en `develop`
- Rama de feature borrada

---

## 7. Trabajar con Docker

### Levantar el entorno completo:

```bash
# Desde la raíz del proyecto
docker-compose up -d
```

Esto levanta:

- PostgreSQL en puerto 5432
- Backend (Spring Boot) en puerto 8080
- Frontend (React) en puerto 3000

### Ver logs:

```bash
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose logs -f db
```

### Parar todo:

```bash
docker-compose down
```

### Reiniciar un servicio específico:

```bash
docker-compose restart backend
```

### Reconstruir imágenes (si cambias dependencias):

```bash
docker-compose up --build
```

### Si algo no funciona:

```bash
# Parar todo
docker-compose down

# Borrar volúmenes ( borra la base de datos)
docker-compose down -v

# Reconstruir desde cero
docker-compose up --build
```

---

## 8. Template de Pull Request

Cuando crees un PR, rellena esto:

```markdown
## Descripción

WOJA-26: Implementar sistema de login con JWT

## Cambios implementados

- [x] Endpoint POST /api/auth/login
- [x] Generación de token JWT
- [x] Validación de credenciales
- [x] Manejo de errores 401

## Testing

- [x] Tests unitarios añadidos (AuthControllerTest)
- [x] Probado localmente con Postman
- [x] Sin warnings en consola

## Screenshots (si aplica)

<!-- Capturas de pantalla si hay cambios visuales -->

## Tareas relacionadas

Depende de: WOJA-13 (Base de datos)
Bloquea a: WOJA-27 (necesita autenticación)
```

---

## 9. Comandos de Supervivencia

| Acción                                        | Comando                                               |
| --------------------------------------------- | ----------------------------------------------------- |
| **Empezar el día**                            | `git checkout develop` + `git pull origin develop`    |
| **Crear rama**                                | `git checkout -b feature/WOJA-XX-descripcion`         |
| **Ver estado**                                | `git status` (úsalo antes de cada commit)             |
| **Ver cambios**                               | `git diff`                                            |
| **Guardar cambios**                           | `git add .` + `git commit -m "mensaje"`               |
| **Subir cambios**                             | `git push origin nombre-rama`                         |
| **Ver ramas**                                 | `git branch -a`                                       |
| **Cambiar de rama**                           | `git checkout nombre-rama`                            |
| **Actualizar rama actual**                    | `git pull`                                            |
| **Borrar rama local**                         | `git branch -d nombre-rama`                           |
| **Ver historial**                             | `git log --oneline`                                   |
| **Pánico (deshacer cambios NO guardados)**    | `git checkout .` Cuidado, borra todo lo no commiteado |
| **Deshacer último commit (mantener cambios)** | `git reset --soft HEAD~1`                             |
| **Ver diferencias con develop**               | `git diff develop`                                    |

---

## 10. ¿Qué hago si...?

### "He hecho cambios en la rama equivocada"

```bash
# Guarda tus cambios sin commitear
git stash

# Cambia a la rama correcta
git checkout feature/WOJA-XX-correcta

# Recupera tus cambios
git stash pop
```

### "Quiero descartar todos mis cambios y empezar de nuevo"

```bash
# CUIDADO: Esto borra TODOS los cambios no guardados
git checkout .
git clean -fd
```

### "Hice commit en develop por error"

```bash
# Solo si NO has hecho push todavía
git reset --soft HEAD~1 # Deshace el commit pero mantiene los cambios
git checkout -b feature/WOJA-XX-nueva-rama # Crea la rama correcta
git commit -m "mensaje"
```

### "Quiero cambiar el mensaje del último commit"

```bash
# Solo si NO has hecho push todavía
git commit --amend -m "nuevo mensaje"
```

### "Me equivoqué y quiero volver a un commit anterior"

```bash
# Ver historial
git log --oneline

# Volver a un commit específico (copia el hash)
git reset --hard abc1234

# Esto BORRA todos los commits posteriores
```

---

## 11. Protección de Ramas

Las ramas `main` y `develop` están **protegidas** en GitHub:

- No se puede hacer push directo
- Solo se puede mergear mediante Pull Request
- Requiere aprobación de 1 revisor
- Debe pasar los checks automáticos (si los configuramos)

**Si intentas hacer push directo, GitHub te rechazará el push.**

---

## Recursos Útiles

- [Git Cheat Sheet](https://education.github.com/git-cheat-sheet-education.pdf)
- [Visualizar Git](https://git-school.github.io/visualizing-git/)
- [Oh Shit, Git!?!](https://ohshitgit.com/) - Soluciones a problemas comunes
