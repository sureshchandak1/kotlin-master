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

    val p1 = Person("A", 21)
    val p2 = Person("B", 17)

    println("is p1 vote = ${ p1.canVote() }")
    println("is p2 vote = ${ p2.canVote() }")

    p2.age = 26
    println("is p2 vote = ${ p2.canVote() }")

}

class Car(val name: String, val type: String, var kmRun: Double) { // name, type, kmRun is class properties

    fun driveCar() { // methods
        println("$name Car is driving")
    }

    fun applyBrakes() {
        println("$name Applied Breaks")
    }
}

class Person(val name: String, var age: Int) {

    fun canVote() = age > 18
}