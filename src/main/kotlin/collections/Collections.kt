package collections

/*
*  - Mutable List (Can be changed i.e. elements can be added/removed/replaced)
*  - Immutable List (Can't be changed)
* */
fun main() {
    val immutableList: List<Int> = listOf(1, 2, 3) // not allow to change add/remove/replace
    println(immutableList.indexOf(3))
    println(immutableList.contains(4))

    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
    mutableList.add(4)
    println(mutableList)
    mutableList.remove(1)
    println(mutableList)
    mutableList.addAll(listOf(5, 6, 7, 8))
    println(mutableList)

    println()
    val students = mutableMapOf<Int, String>()
    students.put(1, "Ryan")
    students.put(2, "John")
    students[3] = "Katie"
    println(students)
    println(students.get(2))

    for ((key, value) in students) {
        println("$key = $value")
    }

    students[1] = "Jones"
    println(students)

    val map = mapOf<Int, String>(1 to "Hello", 2 to "World") // Immutable Map (not allow to change add/remove/replace)
    println(map)
}