import ar.edu.unahur.obj2.tareas.Empleado
import ar.edu.unahur.obj2.tareas.TareaSimple

// Pueden usar este archivo para hacer pruebas rápidas,
// de la misma forma en que usaban el REPL de Wollok.

// OJO: lo que esté aquí no será tenido en cuenta
// en la corrección ni reemplaza a los tests.

val empleadoResponsable = Empleado(200)

val empleado1 = Empleado(150)
val empleado2= Empleado(150)
val empleado3 = Empleado(150)
val empleado4 = Empleado(150)

val tarea1 = TareaSimple(20,empleadoResponsable,1500)
tarea1.asignarEmpleado(empleado1)
//tarea1.asignarEmpleado(empleado2)
//tarea1.asignarEmpleado(empleado3)
//tarea1.asignarEmpleado(empleado4)

tarea1.nominaDeEmpleados()
