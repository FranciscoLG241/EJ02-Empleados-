abstract class Empleado(val nombre: String, val id: String) {

    abstract fun calcularSalario(): Double
}




class EmpleadoPorHora(nombre: String, id: String, val horasTrabajadasAlMes: Int, val tarifaPorHora: Double): Empleado(nombre, id) {

    override fun calcularSalario(): Double {
        return horasTrabajadasAlMes * tarifaPorHora
    }
}



class EmpleadoFijo(nombre: String, id: String, val salarioFijo: Double, val numPagas: Int): Empleado(nombre, id){

    override fun calcularSalario(): Double {
        return salarioFijo / numPagas
    }
}



class Departamento(){

    private val listaEmpleados = mutableListOf<Empleado>()

    fun agregarEmpleado(empleado: Empleado){
        listaEmpleados.add(empleado)
    }


    fun calcularSalarioTotal(): Double{
        return listaEmpleados.sumOf { it.calcularSalario() }
    }


    fun mostrarEmpleados(){
        for (empleado in listaEmpleados){
            println("${empleado.nombre} con ID-${empleado.id.padStart(4, '0')} tiene un salario de ${"%.2f".format(empleado.calcularSalario())} al mes.")
        }
    }
}




fun main(){

    val departamento = Departamento()

    val empleado1 = EmpleadoPorHora("Juan Pérez", "1", 160, 15.50)
    val empleado2 = EmpleadoFijo("María López", "2", 30000.0, 12)
    val empleado3 = EmpleadoPorHora("Carlos Gómez", "3", 120, 18.75)
    val empleado4 = EmpleadoFijo("Ana Ramírez", "4", 40000.0, 14)

    departamento.agregarEmpleado(empleado1)
    departamento.agregarEmpleado(empleado2)
    departamento.agregarEmpleado(empleado3)
    departamento.agregarEmpleado(empleado4)

    departamento.mostrarEmpleados()
    println("Salario total del departamento: ${"%.2f".format(departamento.calcularSalarioTotal())}")

}