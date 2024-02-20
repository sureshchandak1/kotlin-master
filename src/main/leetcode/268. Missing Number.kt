fun main() {
    val arr = intArrayOf(9,6,4,2,3,5,7,0,1)
    println(missingNum2(arr))
}

private fun missingNum1(nums: IntArray): Int {

    val size = nums.size
    val numCount = IntArray(size + 1) { -1 }

    for (value in nums) {
        numCount[value] = 1
    }

    for (index in numCount.indices) {
        if (numCount[index] == -1) {
            return index
        }
    }

    return -1
}

private fun missingNum2(nums: IntArray): Int {

    val size = nums.size
    var ans = 0

    for (i in 1 .. size) {
        println("Ans = $ans, i = $i")
        ans = ans xor i
    }
    println("Ans = $ans")

    for (value in nums) {
        println("Ans = $ans, i = $value")
        ans = ans xor value
    }

    return ans

}