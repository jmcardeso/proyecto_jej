# SAN CLEMENTE BATTLE

Juego de lucha entre alumnos y profesores del IES San Clemente

**Participantes:** Elías Parada (idea original), Julio Pillado y Juan Cardeso

**Librerías usadas:** AWT, Swing, IO, JavaX.Sound.Sampled, com.Sun.media.Sound, Thread e interfaz Runnable

## To-Do
- Crear un repo :heavy_check_mark:
- Centrarnos en la pantalla de lucha :heavy_check_mark:
- Mirar el multihilo :heavy_check_mark:
- Mirar sprites
- Sonido y música :heavy_check_mark:
- definir el bucle principal de combate :heavy_check_mark:
- cuando el personaje vence, se va del escenario, hay un fundido y aparece el nuevo escenario
- antes de empezar, la conserje explica la historia
- diseñar un algoritmo de puntuación y guardar las mejores puntuaciones
- mirar una fuente de texto tipo gameboy
- investigar cómo imprimir el texto en pantalla :heavy_check_mark:

## DATOS IMPORTANTES - VISTA

- La ventana principal del juego tiene formato de 16:9, con un tamaño de 1025x576 píxeles. 
- Aunque el diseño se adapta al tamaño de la pantalla que se esté usando, tenemos que mantener el formato 16:9 y esa resolución, ya que en principio solo se va a ejecutar en nuestros ordenadores y los de clase, con la ventana sin maximizar y sin poder cambiarla de tamaño.
- Los iconos de habilidades y los sprites de personajes van a tener un tamaño de 64x64 píxeles.
- Los iconos para las habilidades los estamos descargando de: https://www.flaticon.com
- Los sprites de personaje los vamos a generar en: http://gaurav.munjal.us/Universal-LPC-Spritesheet-Character-Generator/#

## CLASES
- ide a utilizar: eclipse
- lenguaje: Java
- notación: estándar, lowerCamelCase(tm)
- refactorizar las clases: encapsular bien las clases, crear constructores, getter y setter
- separar bien los recursos del código, etc...
- Juan: investigar el multihilo
- Elías: investigar los sprites
- Julio: desarrollar las rutinas de los personajes (refactorizarlas, getters y setters, etc...)

## TIPOS DE ATAQUES
- Un ataque defensivo
- Uno curativo
- Un ataque estándar
- Un ultimate que se vaya acumulando entre combates
