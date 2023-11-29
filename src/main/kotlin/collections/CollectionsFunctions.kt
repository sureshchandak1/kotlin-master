package collections

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5)

    val filterList1 = numbers.filter(::isOdd)
    println(filterList1)
    val filterList2 = numbers.filter(fun (a: Int): Boolean {
        return a % 2 != 0
    })
    println(filterList2)
    val filterList3 = numbers.filter({ a: Int -> a % 2 != 0 })
    println(filterList3)
    val filterList4 = numbers.filter { a: Int -> a % 2 != 0 }
    println(filterList4)
    val filterList5 = numbers.filter { it % 2 != 0 }
    println(filterList5)

    val userList = listOf(
        User(1, "A"),
        User(2, "B"),
        User(3, "C")
    )
    println(userList.filter { it.id == 2 })

    val mapList1 = numbers.map { it * it }
    println(mapList1)

    val paidUserList = userList.map {
        PaidUser(it.id, it.name, "Paid")
    }
    println(paidUserList)

    numbers.forEach { println(it) }
}

private fun isOdd(a: Int) = a % 2 != 0

private data class User(val id: Int, val name: String)

private data class PaidUser(val id: Int, val name: String, val type: String)


