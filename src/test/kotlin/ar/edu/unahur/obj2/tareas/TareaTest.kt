package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {

    val empleadoResponsable = Empleado(200)

    val empleado1 = Empleado(150)
    val empleado2= Empleado(150)
    val empleado3 = Empleado(150)
    val empleado4 = Empleado(150)

    val tarea1 = TareaSimple(20,empleadoResponsable,1500)
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

  describe ("una tarea de integracion"){
    val encargadoJuan = Empleado(200)
    val encargadaRosa = Empleado(200)
    val encargadaJazmin = Empleado(300)

    val tarea1 = TareaSimple(30,encargadoJuan,1500) //1500+6000+4500 = 12000
    val tarea2 = TareaSimple(16,encargadaRosa,1500) //2400 + 1500+3200 = 7100
    val tarea3 = TareaSimple(24,encargadaJazmin,1500) //3600 + 1500 + 7200= 12300 === 31400 + 9420 == 42680

    val antonio = Empleado(150)
    val fede = Empleado(150)
    val maria = Empleado(150)
    val carla = Empleado(150)
    val marita = Empleado(150)
    val juana = Empleado(150)
    val fernando = Empleado(150)
    val sonia = Empleado(150)

    tarea1.asignarEmpleado(antonio)
    tarea1.asignarEmpleado(fede)

    tarea2.asignarEmpleado(maria)
    tarea2.asignarEmpleado(carla)

    tarea3.asignarEmpleado(marita)
    tarea3.asignarEmpleado(juana)
    tarea3.asignarEmpleado(fernando)
    tarea3.asignarEmpleado(sonia)

    val encargadoGeneral = Empleado(500)
    val tareaIntegrada = TareasDeIntegracion(encargadoGeneral)

    tareaIntegrada.agregarTarea(tarea1)
    tareaIntegrada.agregarTarea(tarea2)
    tareaIntegrada.agregarTarea(tarea3)


    it ("consultar la nomina de una tarea de integración"){


      tareaIntegrada.nominaDeEmpleados().shouldContainExactlyInAnyOrder(
        encargadoGeneral,
        antonio,
        fede,
        encargadoJuan,
        maria,
        carla,
        encargadaRosa,
        marita,
        juana,
        fernando,
        sonia,
        encargadaJazmin
      )
    }

    it("Suma de horas necesarias para finalizar tarea"){
      tareaIntegrada.horasNecesariasParaFinalizarTarea().shouldBe(32)
    }

    it("Costo de Tarea en Tarea de Integracion"){
      tareaIntegrada.costoDeTarea().shouldBe(40820)
    }

  }
})
