package lecture037_Recursion_Day7


fun main() {
    val arr = intArrayOf(1,2,3)
    println(subsets(arr))
    println(Subsets().subsets(arr))
}

private fun subsets(nums: IntArray): List<List<Int>> {
    val ans = ArrayList<ArrayList<Int>>()
    val output = ArrayList<Int>()
    subsets(nums, output, 0, ans)

    return ans
}

private fun subsets(nums: IntArray, output: ArrayList<Int>, index: Int, ans: ArrayList<ArrayList<Int>>) {

    // Base case
    if (index >= nums.size) {
        ans.add(ArrayList(output))
        return
    }

    // exclude
    subsets(nums, output, index + 1, ans)

    // Include
    val element = nums[index]
    output.add(element)
    subsets(nums, output, index + 1, ans)

    // Backtracking
    output.removeAt(output.size - 1)

}

private class Subsets {

    private val subsetsList: MutableList<List<Int>> = ArrayList()

    private val tempSubset: MutableList<Int> = ArrayList()

    private lateinit var numbers: IntArray

    fun subsets(nums: IntArray): List<List<Int>> {
        this.numbers = nums
        // Start the Depth-First Search (DFS) with the first index
        depthFirstSearch(0)
        return subsetsList
    }

    private fun depthFirstSearch(index: Int) {

        // Base case
        if (index == numbers.size) {
            subsetsList.add(ArrayList(tempSubset))
            return
        }


        // The current number is excluded from the subset
        depthFirstSearch(index + 1)


        // The current number is included in the subset.
        tempSubset.add(numbers[index])
        depthFirstSearch(index + 1)

        tempSubset.removeAt(tempSubset.size - 1)
    }

}
