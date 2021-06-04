package ar.edu.unahur.obj2.tareas

interface Tarea {
    fun nominaDeEmpleados() : List<Empleado>
    fun horasNecesariasParaFinalizarTarea() : Int
    fun costoDeTarea() : Int
}
 open class TareaSimple(val horasEstimadas : Int, val responsable : Empleado, val costoDeInfraestructura : Int  ) : Tarea {
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
    override fun nominaDeEmpleados() : List<Empleado> =
        empleadosAsignados.plus(responsableDeLaTarea())

    //REQUERIMIENTO 2
    override fun horasNecesariasParaFinalizarTarea() : Int =
        horasEstimadas / this.cantidadDeEmpleadosAsignados()

    //REQUERIMIENTO 3
    override fun costoDeTarea() : Int =
        costoDeInfraestructura + this.sueldoDelResponsable() + this.sueldoDeLosEmpleados()


}

open class TareasDeIntegracion(val responsableDeTareaDeIntegracion : Empleado) : Tarea {
    val tareasIntegradas = mutableListOf<Tarea>()

    //TODO CORREGIR ESTO!!!
    override fun nominaDeEmpleados(): List<Empleado> {
        return tareasIntegradas.map{it.nominaDeEmpleados()}.flatten().plus(responsableDeTareaDeIntegracion)


    }
    
    override fun horasNecesariasParaFinalizarTarea(): Int {
        TODO("Not yet implemented")
    }

    override fun costoDeTarea(): Int {
        TODO("Not yet implemented")
    }

}