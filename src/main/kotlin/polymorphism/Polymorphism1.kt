package polymorphism

fun main() {
    val hyundai: Hyundai = Hyundai()
    println(hyundai.color())
    println(hyundai.engine())

    val car1: Car = Hyundai()
    println(car1.color())
    //println(car1.engine()) // Not allow engine method call

    val car2: Car = Car()
    println(car2.color())
    //println(car2.engine()) // Not allow engine method call
}

open class Car {

    open fun color() : String {
        return "White"
    }

}

class Hyundai : Car() {

    override fun color(): String {
        return "Black"
    }

    fun engine(): String {
        return "BS6"
    }

}