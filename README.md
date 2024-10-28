https://github.com/Parcial-1-PDE/MisTareas2.git

# Aplicación de Lista de Tareas - MisTareas2

## Descripción

Esta aplicación permite al usuario gestionar una lista de tareas organizadas en dos categorías: tareas "Pendientes" y tareas "Hechas". La aplicación permite agregar nuevas tareas, ver los detalles de cada tarea, y marcar tareas como completadas o eliminarlas. El diseño de la interfaz es intuitivo y está dividido en varias actividades, lo que facilita la navegación y el uso de la aplicación.

## Funcionalidades

- **Añadir Tarea**: El usuario puede añadir una nueva tarea proporcionando detalles como nombre, descripción, fecha, prioridad y coste aproximado.
- **Visualizar Tareas Pendientes**: Las tareas pendientes se muestran en la lista principal. El usuario puede alternar entre tareas pendientes y tareas completadas usando los botones en la parte inferior de la pantalla.
- **Marcar Tarea como Hecha**: Manteniendo presionada una tarea en la lista de pendientes, el usuario puede marcarla como "Hecha", moviéndola a la lista de tareas completadas.
- **Eliminar Tarea**: El usuario puede eliminar una tarea de la lista (tanto en pendientes como en hechas) manteniendo presionada la tarea y seleccionando "Eliminar".
- **Ver Detalles de la Tarea**: Al hacer clic en una tarea, se abre una nueva pantalla que muestra los detalles completos de la tarea seleccionada.

## Estructura de la Aplicación

La aplicación consta de tres actividades principales:

1. **MainActivity**: La pantalla principal que muestra la lista de tareas pendientes o hechas, y permite la navegación entre ambas listas. Desde aquí, el usuario puede acceder al formulario para añadir nuevas tareas.
2. **RegistroTareaActivity**: La actividad donde el usuario puede agregar una nueva tarea con los campos necesarios.
3. **DetallesTareaActivity**: La actividad que muestra los detalles completos de una tarea seleccionada.


## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Android SDK**: Plataforma para el desarrollo de aplicaciones móviles en Android.
- **PlantUML**: Herramienta para generar los diagramas UML de clases y casos de uso.
- **Intents y Listeners**: Para la comunicación entre actividades y gestión de eventos en la interfaz.



