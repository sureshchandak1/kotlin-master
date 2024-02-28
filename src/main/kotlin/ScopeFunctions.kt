import kotlin.random.Random

/*
* - When you call such a function on an object with a lambda expression provided, it forms a temporary scope.
*   In this scope, you can access the object without its name.
*   Such functions are called scope functions.
*
*    let, run, with, apply, also
* */
fun main() {
    val emp = Employee()
    emp.name = "John"
    emp.age = 20
    println(emp)

    emp.apply {
        age = 30
        name = "Sean"
    }
    println(emp)

    emp.let {
        println(it.name)
        println(it.age)
    }

    with(emp) {
        age = 40
        name = "XYZ"
    }
    println(emp)

    emp.run {
        age = 50
        name = "PQR"
    }
    println(emp)

    val numbers = mutableListOf("one", "two", "three")
    numbers.also { println("The list elements before adding new one: $it") }.add("four")
    println(numbers)

    var a: String? = null

    a?.let {
        // not null do something
        println(it)
        println("a is not null")
    }
    // Elvis operator - ?:
    a ?: println("a is null")

    a ?: run {
        println("a is null")
        println("The King has left the building")
    }

    // Combining the two
    a?.let {
        println("a is not null")
        println("Wop-bop-a-loom-a-boom-bam-boom")
    } ?: run {
        println("a is null")
        println("When things go null, don't go with them")
    }

}

private data class Employee(var name: String = "", var age: Int = 18)




