package lecture120_Maximum_Height_by_Stacking_Cuboid

import java.util.*

/**
 *    https://leetcode.com/problems/maximum-height-by-stacking-cuboids/description/
 *    T.C = O(n (log n))
 *    S.C = O(n)
 */
fun main() {
    var cuboids = arrayOf(
        intArrayOf(50, 45, 20), intArrayOf(95, 37, 53), intArrayOf(45, 23, 12)
    )
    println(maxHeight(cuboids))

    cuboids = arrayOf(
        intArrayOf(38, 25, 45), intArrayOf(76, 35, 3)
    )
    println(maxHeight(cuboids))

    cuboids = arrayOf(
        intArrayOf(7, 11, 17), intArrayOf(7, 17, 11), intArrayOf(11, 7, 17),
        intArrayOf(11, 17, 7), intArrayOf(17, 7, 11), intArrayOf(17, 11, 7)
    )
    println(maxHeight(cuboids))
}

private fun maxHeight(cuboids: Array<IntArray>): Int {

    // step1: sort all dimenstions for every cuboid
    for (a in cuboids) {
        Arrays.sort(a)
    }

    // step2: sort all cuboids basis on w or l
    Arrays.sort(cuboids) { a, b ->
        if (a[0] != b[0]) a[0] - b[0]
        else if (a[1] != b[1]) a[1] - b[1]
        else a[2] - b[2]
    }

    // step3: use LIS solution
    return lisSolution(cuboids)
}

private fun lisSolution(nums: Array<IntArray>): Int {

    val n = nums.size

    val currRow = IntArray(n + 1)
    var nextRow = IntArray(n + 1)

    for (curr in n - 1 downTo 0) {
        for (prev in curr - 1 downTo -1) {

            var include = 0
            if (prev == -1 || check(nums[curr], nums[prev])) {
                include = nums[curr][2] + nextRow[curr + 1]
            }

            val exclude = 0 + nextRow[prev + 1]

            currRow[prev + 1] = Math.max(include, exclude)

        }

        nextRow = currRow.copyOf(currRow.size)
    }

    return nextRow[0]
}

private fun check(base: IntArray, newBox: IntArray): Boolean {
    if (newBox[0] <= base[0] && newBox[1] <= base[1] && newBox[2] <= base[2]) {
        return true
    }
    return false
}







