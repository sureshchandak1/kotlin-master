package easy

fun main() {
    val arr1 = listOf(1, 2, 3, 4, 5)
    val arr2 = listOf(3, 4, 5)

    val ans = findArrayIntersection2(arr1, arr1.size, arr2, arr2.size)
    println(ans)
}

private fun findArrayIntersection1(
    arr1: ArrayList<Int>, n: Int,
    arr2: ArrayList<Int>, m: Int
): ArrayList<Int> {
    val ans = ArrayList<Int>()

    for (i in 0..<n) {
        val element = arr1[i]

        for (j in 0..<m) {
            if (arr2[j] > element) {
                break
            }

            if (element == arr2[j]) {
                ans.add(element)
                arr2[j] = Int.MIN_VALUE
                break
            }
        }
    }

    return ans
}

private fun findArrayIntersection2(
    arr1: List<Int>, n: Int,
    arr2: List<Int>, m: Int
): ArrayList<Int> {
    val ans = ArrayList<Int>()

    var i = 0
    var j = 0

    while (i < n && j < m) {
        if (arr1[i] == arr2[j]) {
            ans.add(arr1[i])
            i++
            j++
        } else if (arr1[i] < arr2[j]) {
            i++
        } else {
            j++
        }
    }

    return ans
}
