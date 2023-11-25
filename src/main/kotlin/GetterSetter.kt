fun main() {
    val person = Person("a", 21)
    println(person.age)
    person.age = 25
    person.age = -12
    println("Name = ${person.name}, Age = ${person.age}")
}

class Person(nameParam: String, ageParam: Int) {
    val name: String = nameParam
        get() {
            return field.uppercase()
        }

    var age: Int = ageParam
        set(value) {
            if (value > 0) {
                field = value
            } else {
                println("Age can't be negative")
            }
        }

    var email: String = "" // Default declaration
        get() = field
        set(value) { field = value }
}