package generics

fun main() {
    val obj = IntContainer(3)
    println(obj.getValue())
    val iContainer = Container<Int>(3)
    println(iContainer.getValue())
    val sContainer = Container<String>("Hello")
    println(sContainer.getValue())

    add(1, 2, 3, 4, 5)
}

fun add(vararg values: Int) {
    var sum = 0
    for (i in values) {
        sum += i
    }
    println(sum)
}

class Container<T>(private var data: T) {
    fun setValue(value: T) {
        data = value
    }

    fun getValue() : T {
        return data
    }
}

class IntContainer(private var data: Int) {
    fun setValue(value: Int) {
        data = value
    }

    fun getValue() : Int {
        return data
    }
 }

class StringContainer(private var data: String) {
    fun setValue(value: String) {
        data = value
    }

    fun getValue() : String {
        return data
    }
}