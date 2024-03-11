package collections

import java.util.*


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

    val accountMap: MutableMap<String, Int> = HashMap()
    accountMap["1"] = 400
    accountMap["2"] = 200
    accountMap["3"] = 1000
    accountMap["4"] = 100
    accountMap["5"] = 1200
    println(accountMap.toString())

    val sortedMap1: Map<String, Int> = accountMap.toList().sortedBy { it.second }.toMap()
    val sortedMap2: Map<String, Int> =
        accountMap.toList().sortedWith(compareBy( { it.second }, { it.second } ) ).toMap()
    val sortedMap3: Map<String, Int> =
        accountMap.toList().sortedWith(compareByDescending { it.second } ).toMap()

    println(sortedMap1.toString())
    println(sortedMap2.toString())
    println(sortedMap3.toString())

}