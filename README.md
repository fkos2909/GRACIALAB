# GRACIALAB
Buen día, aquí adjunto mi prueba práctica.

Debo aclarar para que puedan evaluar, que yo no tengo experiencia con Spring Boot ni con Vue.js (o cualquier framework de frontend), que son las herramientas que intente usar para la prueba. Realmente si pude implementar el Vue.js pero no me dio tiempo de aprender a implicarlo para el frontend pero si esta activo en el proyecto.
Se que comentaron que darían tiempo extra a casos excepcionales, en mi caso por el trabajo comence la prueba el Lunes, pero no me parecio un caso excepcional, así que hice lo mejor que pude.

La aplicación utiliza Bootstrap, ya que lo use mientras probaba la logica y utiliza mysql para la bd.
La aplicación es capaz de Agregar una reserva y valida si el usuario (por el correo) ya existe, en ese caso solo agrega la relación, en caso contrario crea el nuevo usuario y la relación.
Por defecto, coloque que todo nuevo usuario se cree con el rol de cliente.
Puede confirmar la reserva y editarla desde la tabla. (si la hora da error hay que poner en 00 los segundos, creo que ese campo esta de más pero lo deje así)

Debido a que  no tengo experiencia con las herramientas, tuve que inventarme soluciones a errores que aparecieron, se que algunos son fallos en la logica pero me enfoque en lograr los requerimientos. No me dio tiempo de implementar el login, parece que la dependecia que pensaba usar ya esta obsoleta y me quede sin tiempo. Claramente sin login no hay validación de acceso.
Mi diagrama de base de datos, hace unas horas pense "¿El nombre, apellido y esos datos de Persona no sería otra clase? tipo user_detalles ¿o son parte de la reserva?" pero ya no habia tiempo jajaja.

![Diagrama en blanco](https://github.com/fkos2909/GRACIALAB/assets/92612247/efb0996b-0fbd-4c9c-9819-7cf6fcbc216f)

Igualmente me emocionó conocer nuevas herramientas, ojala sean parte de lo que utilizan en GLAB para aprender a usarlas de forma correcta. Me gustó la estructura de Spring Boot.

Si logro hacer un video de demostración agregaré el link a drive aqui abajo:



