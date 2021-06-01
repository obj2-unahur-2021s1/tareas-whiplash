package ar.edu.unahur.obj2.tareas

open class Tarea(val horasEstimadas : Int, val responsable : Empleado, val costoDeInfraestructura : Int  ) {
    val empleadosAsignados = mutableListOf<Empleado>()

    fun asignarEmpleado(empleado : Empleado) =
        empleadosAsignados.add(empleado)

    fun cantidadDeEmpleadosAsignados() : Int = empleadosAsignados.size

    fun sueldoDelResponsable(): Int =
        responsable.sueldoPorHoraTrabajada * horasEstimadas

    fun sueldoDeLosEmpleados() : Int =
        this.horasNecesariasParaFinalizarTarea() * empleadosAsignados.sumBy{it.sueldoPorHoraTrabajada}

    fun responsableDeLaTarea() : Empleado = responsable

    //REQUERIMIENTO 1
    fun nominaDeEmpleados() : List<Empleado> =
        empleadosAsignados.plus(responsableDeLaTarea())

    //REQUERIMIENTO 2
    fun horasNecesariasParaFinalizarTarea() : Int =
        horasEstimadas / this.cantidadDeEmpleadosAsignados()

    //REQUERIMIENTO 3
    fun costoDeTarea() : Int =
        costoDeInfraestructura + this.sueldoDelResponsable() + this.sueldoDeLosEmpleados()


}

class TareasDeIntegracion(horasEstimadas: Int, responsable: Empleado, costoDeInfraestructura: Int) :
    Tarea(horasEstimadas, responsable, costoDeInfraestructura) {

}