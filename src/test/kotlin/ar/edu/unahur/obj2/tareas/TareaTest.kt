package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {

    val empleadoResponsable = Empleado(200)

    val empleado1 = Empleado(150)
    val empleado2= Empleado(150)
    val empleado3 = Empleado(150)
    val empleado4 = Empleado(150)

    val tarea1 = Tarea(20,empleadoResponsable,1500)
    tarea1.asignarEmpleado(empleado1)
    tarea1.asignarEmpleado(empleado2)
    tarea1.asignarEmpleado(empleado3)
    tarea1.asignarEmpleado(empleado4)



    it("poder consultar la nomina de empleados de una tarea"){
      tarea1.nominaDeEmpleados().shouldContainExactly(
        empleado1,
        empleado2,
        empleado3,
        empleado4,
        empleadoResponsable
      )
    }

    it("saber cuantas horas se necesitan para realizar una tarea"){
    tarea1.horasNecesariasParaFinalizarTarea().shouldBe(5)
    }

    it("obtener el costo de una tarea"){
    tarea1.costoDeTarea().shouldBe(8500)
    }


  }
})
