package constructors

/*
*  Primary and Secondary
*  use for properties initialize
* */
fun main() {
    val car1 = Automobile("Car1", 4, 5, "Petrol")
    val car2 = Automobile("Car2", 4, 5, "Petrol")
    val car3 = Automobile("Car3", "Diesel")
    val person1 = Person("A", 16)
    println("Name = ${person1.name}, Age = ${person1.age}, isVote = ${person1.canVote}")
    val person2 = Person("B", 28)
    println("Name = ${person2.name}, Age = ${person2.age}, isVote = ${person2.canVote}")
}

class Automobile(val name: String, val tyres: Int, val maxSeating: Int, val engineType: String) {

    init {
        println("$name is created")
    }

    constructor(nameParam: String, engineParam: String) : this(nameParam, 4, 5, engineParam)

    fun drive() {  }
    fun applyBreaks() {  }

    init {
        println("2nd Initializer block")
    }
}

class Empty {  }

class Person(nameParam: String, ageParam: Int) {
    var name: String = nameParam
    var age: Int = ageParam
    val canVote: Boolean = ageParam > 18
}