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


    fun agregarTarea(tarea : Tarea){
        tareasIntegradas.add(tarea)
    }


    override fun nominaDeEmpleados(): List<Empleado> {
        return tareasIntegradas.map{it.nominaDeEmpleados()}.flatten().plus(responsableDeTareaDeIntegracion)


    }

    fun cantidadDeHorasDePlanificacion(sumaDeHoras : Int) : Int{
        return (sumaDeHoras / 8).toInt()
    }

    override fun horasNecesariasParaFinalizarTarea(): Int {
        val sumaDeHoras = tareasIntegradas.sumBy{it.horasNecesariasParaFinalizarTarea()}

        return this.cantidadDeHorasDePlanificacion(sumaDeHoras) + sumaDeHoras


    }

    override fun costoDeTarea(): Int {
        
    }

}