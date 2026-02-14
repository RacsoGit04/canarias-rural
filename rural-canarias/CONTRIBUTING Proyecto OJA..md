# Guía de Contribución y Normas del Equipo

Este documento define cómo vamos a trabajar juntos para evitar romper el código, y minimizar conflictos.

---

## 1. La Regla de Oro

**NADIE hace commit directo a `main` ni a `develop`.**

- La rama `main` es sagrada. Solo contiene código en producción.
- La rama `develop` es para integración. Solo se mergea mediante Pull Requests.
- **Si rompemos `main` o `develop`, rompemos el trabajo de todos.**

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

#### **Paso 1: Sincronizarse con `develop`**

Antes de empezar cualquier tarea, bajamos lo último de la nube:

```bash
git checkout develop
git pull origin develop
```

#### **Paso 2: Crear nuestra rama de feature**

Nunca trabajamos directamente en `develop`. Crear una rama con este formato:

**Formato:** `feature/WOJA-XX-descripcion-corta`

**Ejemplos:**

- `feature/WOJA-26-login-backend`
- `feature/WOJA-27-accommodation-card`
- `feature/WOJA-29-zone-filter`

**Comando:**

```bash
git checkout -b feature/WOJA-26-login-backend
```

#### **Paso 3: Programar y hacer commits frecuentes**

Trabajar normalmente y guardar los cambios con commits **atómicos** (un commit = un cambio lógico):

```bash
# Ver qué archivos hemos cambiado
git status

# Añadir archivos al staging
git add src/main/java/com/example/controller/AuthController.java

# Hacer commit con mensaje descriptivo
git commit -m "WOJA-26: Añadir endpoint POST /api/auth/login"

# Continuar trabajando...
git add src/main/java/com/example/service/AuthService.java
git commit -m "WOJA-26: Implementar lógica de autenticación JWT"
```

#### **Paso 4: Subir nuestra rama a GitHub**

```bash
git push origin feature/WOJA-26-login-backend
```

Si es la primera vez que subimos esa rama, Git nos dirá que hagamos:

```bash
git push --set-upstream origin feature/WOJA-26-login-backend
```

#### **Paso 5: Crear Pull Request**

1. Vamos a GitHub
2.  Botón verde "Compare & pull request" → Click
3. **IMPORTANTE:** Asegurarnos de que el PR va hacia `develop`, NO hacia `main`

- Base: `develop`
- Compare: `feature/WOJA-26-login-backend`

4. Rellenamos el template del PR (ver sección 6)
5. Asignamos a UN compañero como revisor
6. Envíamos el PR

#### **Paso 6: Esperar aprobación y mergear**

- **Revisor:** Debe revisar el código y aprobar (ver sección 4)
- **Autor:** Una vez aprobado, click en "Merge pull request"
- **Autor:** Borrar la rama de feature tras el merge

```bash
# Después del merge, actualizamos nuestro develop local
git checkout develop
git pull origin develop

# Borramos nuestra rama local (ya está mergeada)
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

### Prefijos opcionales (si no tenemos número de tarea):

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

### Si subimos el código (autor del PR):

1. **Asegurarse de que funciona** antes de abrir el PR:

- El código compila sin errores
- La aplicación arranca (tanto backend como frontend)
- No hay errores en la consola
- Probamos manualmente la funcionalidad

2. **Avisar al equipo:**

- "Chicos, he subido el Login (WOJA-26), ¿puede alguien revisarlo?"
- Asignar a un revisor específico en GitHub

3. **Responder a los comentarios:**

- Si el revisor pide cambios, hacerlos
- Comentar y explica si no estás de acuerdo
- Volver a notificar cuando se hayan hecho los cambios

### Si revisamos el código (revisor del PR):

1. **Leer los cambios:**

- Ir a la pestaña "Files changed"
- Leer el código línea por línea
- ¿Entiendo lo que hace?
- ¿Los nombres de variables tienen sentido?
- ¿Hay código duplicado?

2. **Probarlo localmente** (si es posible):

```bash
git fetch origin
git checkout feature/WOJA-26-login-backend
# Levantar el proyecto y probar
```

3. **Dejar comentarios constructivos:**

- Si vemos algo mal,  clic en la línea y dejar un comentario
- Ser específico: "Esta variable debería llamarse `userId` en lugar de `id` para ser más claro"
- No ser destructivo: "Esto está mal" → "¿Qué te parece renombrar esto para que sea más claro?"

4. **Aprobar o pedir cambios:**

- Si todo está bien → "Approve"
- Si hay problemas → "Request changes" y explicar qué hay que arreglar
- Si solo son sugerencias → "Comment" (sin bloquear el merge)

---

## 5. Gestión de Conflictos

**"El que llega último, limpia la casa."**

Si GitHub te dice que hay conflictos al intentar mergear tu PR:

### ¿Por qué pasa esto?

Alguien mergeó cambios en `develop` mientras x persona trabajaba y se modificaron las mismas líneas que x persona.

### ¿Qué hacer?

**Es Nuestra responsabilidad** (el autor del PR) resolver los conflictos:

```bash
# 1. Nos aseguramos de tener los cambios guardados
git add .
git commit -m "WOJA-26: guardar cambios antes de resolver conflictos"

# 2. Bajamos los últimos cambios de develop
git checkout develop
git pull origin develop

# 3. Volvemos a nuestra rama
git checkout feature/WOJA-26-login-backend

# 4. Traemos los cambios de develop a nuestra rama
git merge develop

# 5. Git dirá qué archivos tienen conflictos
# Lo abrimos en VS Code - hay marcas como:
# <<<<<<< HEAD
# tu código
# =======
# código de develop
# >>>>>>> develop

# 6. Editamos manualmente y decidimos qué código quedarnos
# VS Code nos ayuda con botones "Accept Current" / "Accept Incoming"

# 7. Marcar los conflictos como resueltos
git add archivo-con-conflicto.java
git commit -m "WOJA-26: resolver conflictos con develop"

# 8. Subir los cambios
git push origin feature/WOJA-26-login-backend
```

### NUNCA hacer:

```bash
git push --force # NUNCA (CONTADAS EXCEPCIONES)
```
---

## 6. Definition of Done (¿Cuándo hemos terminado?)

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

### Reconstruir imágenes (si cambiamos dependencias):

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

Cuando se crea un PR, rellenar esto:

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
# Solo si NO hemos hecho push todavía
git reset --soft HEAD~1 # Deshace el commit pero mantiene los cambios
git checkout -b feature/WOJA-XX-nueva-rama # Crea la rama correcta
git commit -m "mensaje"
```

### "Quiero cambiar el mensaje del último commit"

```bash
# Solo si NO hemos hecho push todavía
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

## 12. Proteger las Ramas en GitHub (SETUP INICIAL)

1. Ir a Settings → Branches
2. Add rule en `main`:
   - ☑ Require pull request before merging
   - ☑ Require approvals (1)
   - ☑ Dismiss stale PR approvals
3. Repetir para `develop`

## 13. Primera Vez Clonando el Proyecto

git clone [url]
cd proyecto
git checkout develop  # Trabajamos desde develop, NO desde main
git checkout -b feature/WOJA-XX-mi-tarea

## Releases 

#### ¿Cuándo subimos a `main`?
- Al final de cada sprint (cada 2 semanas)
- Cuando tengamos un conjunto de features completo
- Solo si `develop` está funcionando sin errores

#### Proceso:
1. Tech Lead crea PR de `develop` → `main`
2. TODO el equipo revisa
3. Se testea en entorno de staging 
4. Se mergea y despliega
5. Se crea tag de versión (v1.0.0, v1.1.0, etc.)

#### Gestión de Conflictos

**Escenario:**

Uno de nosotros mergea esto en develop: archivo.java línea 10: String nombre = "Hotel Barcelona";

Otro de nosotros estaba trabajando en lo mismo: archivo.java línea 10: String nombre = "Alojamiento Barcelona";

CONFLICTO: Git no sabe cuál código mantener

```
# 1. El PR tiene conflictos, GitHub  avisa

# 2. Ir a la terminal:
git checkout develop
git pull origin develop  # Bajamos los cambios del compañero

# 3. Volver a nuestra rama:
git checkout feature/WOJA-26-login-backend

# 4. Traer develop a nuestra rama:
git merge develop
# Git : "CONFLICT in archivo.java"

# 5. Abir archivo.java en VS Code:

<<<<<<< HEAD (tu código)
String nombre = "Alojamiento Barcelona";
=======
String nombre = "Hotel Barcelona";  (código de develop)
>>>>>>> develop

# 6. Después de elegir:
git add archivo.java
git commit -m "WOJA-26: resolver conflictos con develop"
git push origin feature/WOJA-26-login-backend

```

## Borrar ramas locales y remotas ya mergeadas





**GitHub mantiene TODO el historial**

**Dónde ver el trabajo de cada persona**:

* En el Pull Request mergeado:

GitHub → Pull Requests → Closed

Ahí están TODOS los PRs con:

Quién lo hizo
Qué código cambió
Cuándo se mergeó
Los commits individuales


* En la pestaña "Insights" → "Contributors":

GitHub muestra estadísticas de cada miembro
Commits por persona
Líneas añadidas/eliminadas


* En el historial de commits:

```

bash   git log --author="NombreCompañero"

```


### Procedimiento estándar:

#### 1. Borrar rama REMOTA (GitHub):
- En el PR mergeado: Click "Delete branch"
- O automatizar: Settings → ☑ Automatically delete head branches

#### 2. Borrar rama LOCAL (PC):
```bash
git checkout develop
git pull origin develop
git branch -d feature/WOJA-26-login
```

### ¿Por qué borrar ambas?

Remoto:
- Mantener el repositorio limpio y profesional
- Evitar confusión con ramas viejas
- Facilitar encontrar trabajo activo
- Así trabajan equipos reales

Local:

¿Por qué?

- Confusión: "¿En cuál estaba trabajando?"
- Ocupan espacio (aunque poco)
- Podemos trabajar en una rama vieja por error
- git branch se vuelve ilegible


### El historial NO se pierde

### Comando rápido para limpiar locales:
```bash
# Borrar TODAS las ramas locales ya mergeadas
git branch --merged develop | grep -v "develop" | xargs git branch -d
```

## Recursos

- [Git Cheat Sheet](https://education.github.com/git-cheat-sheet-education.pdf)
- [Visualizar Git](https://git-school.github.io/visualizing-git/)
- [Oh Shit, Git!?!](https://ohshitgit.com/) - Soluciones a problemas comunes
