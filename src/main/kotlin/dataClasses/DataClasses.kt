package dataClasses

/*
*  - Data classes in Kotlin are classes whose main purpose is to hold data
*  - The primary constructor must have at least one parameter.
*  - All primary constructor parameters must be marked as val or var
*  - Data classes can't be abstract, open, sealed, or inner
* */
fun main() {
    val p1 = Person(1, "John")
    val p2 = Person(1, "John")

    println(p1)
    println(p2)
    println(p1 == p2)

    val p3 = p1.copy(id = 3)
    println(p3)
    println(p1 == p3)

    val (id, name) = p1
    println(id)
    println(name)
    println(p1.component1())
}

data class Person(val id: Int, val name: String) {  }