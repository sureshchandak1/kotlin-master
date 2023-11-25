package classes

fun main(args: Array<String>) {
    val mustang = Car("mustang", "petrol", 100.0)
    val beetle = Car("beetle", "diesel", 200.0)

    println("name = ${mustang.name}, type = ${mustang.type}, km = ${mustang.kmRun}")
    println("name = ${beetle.name}, type = ${beetle.type}, km = ${beetle.kmRun}")

    mustang.driveCar()
    beetle.driveCar()

    mustang.applyBrakes()
    beetle.applyBrakes()
}

class Car(val name: String, val type: String, var kmRun: Double) { // name, type, kmRun is class properties

    fun driveCar() { // methods
        println("$name Car is driving")
    }

    fun applyBrakes() {
        println("$name Applied Breaks")
    }
}