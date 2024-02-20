import kotlin.math.max
import kotlin.math.min

fun main() {
    val ans: List<IntArray> = pairSum(intArrayOf(2, -3, 3, 3, -2), 0)
    for (value in ans) {
        println(value.asList())
    }
}

private fun pairSum(arr: IntArray, s: Int): List<IntArray> {

    val list: MutableList<IntArray> = mutableListOf()

    for (i in arr.indices) {
        println("-----------  ${arr[i]}  -------------")
        for (j in (i + 1) ..< arr.size) {
            println("i = ${arr[i]}, j = ${arr[j]}")
            if (arr[i] + arr[j] == s) {
                list.add(intArrayOf(
                    min(arr[i], arr[j]),
                    max(arr[i], arr[j])
                ))
            }
        }

    }

    list.sortBy {
        it[0]
    }

    return list

}
