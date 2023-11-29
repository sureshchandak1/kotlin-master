fun main() {
    println("Hello world".formattedString())

    val list = mutableListOf(1, 2, 3)
    println(list)
    list.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'list'
    println(list)
}

fun String.formattedString() : String {
    // not allow to excess String class private members
    val builder = StringBuilder()
    for (i in 1..this.length) {
        builder.append("-")
    }
    return "$builder\n$this\n$builder"
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

/*fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}*/


