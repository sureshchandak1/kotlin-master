package function

import Wrapper

fun main() {
    var str = "123"
    printValue(str)
    println(str)

    val wrapper = Wrapper("Suresh")
    println(wrapper.value)
    printValue(wrapper)
    println(wrapper.value)
}

private fun printValue(str: String) {
    var str = str
    str = "abc"
    println(str)
}

private fun printValue(str: Wrapper<String>) {
    str.value = "Ramesh"
    println(str.value)
}

