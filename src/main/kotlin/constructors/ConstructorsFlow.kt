package constructors

private class AutoMobile(val name: String, val tyres: Int, val maxSeating: Int, val engineType: String) {

    init {
        println("$name is created")
    }

    constructor(nameParam: String, engineParam: String) :
            this(nameParam, 4, 5, engineParam) {
        println("Secondary Constructor")
    }

    fun drive() {  }
    fun applyBreaks() {  }

    init {
        println("2nd Initializer block")
    }
}

fun main() {
    val o1 = AutoMobile("ABC", "Petrol")
}