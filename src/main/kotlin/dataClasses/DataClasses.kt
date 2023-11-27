package dataClasses

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