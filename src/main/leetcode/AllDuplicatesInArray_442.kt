fun main() {
    val arr = intArrayOf(4,3,2,7,8,2,3,1)
    println(findDuplicates(arr))
}

private fun findDuplicates(arr: IntArray): List<Int> {

    val countMap: MutableMap<Int, Int> = HashMap()
    val list: MutableList<Int> = mutableListOf()

    for (number in arr) {
        if (countMap.contains(number)) {
            list.add(number)
        } else {
            countMap[number] = 1
        }
    }

    return list
}

private fun findDuplicates1(arr: IntArray): List<Int> {

    var ans = 0

    for (element in arr) {
        print("$ans xor $element = ")
        ans = ans xor element
        print("$ans")
        println()
    }

    println()

    for (index in 1..<arr.size) {
        print("$ans xor $index = ")
        ans = ans xor index
        print("$ans")
        println()
    }

    println()

    return listOf()

}