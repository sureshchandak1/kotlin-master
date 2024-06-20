package array

/**
 *   https://leetcode.com/problems/next-permutation/description/
 *   https://www.naukri.com/code360/problems/893046
 *   Time Complexity: O(N), where N is the size of the given array.
 *   Auxiliary Space: O(1)
 */
fun main() {
    var arr = arrayListOf(1, 2, 3)
    println(nextPermutation(arr))
    arr = arrayListOf(1, 2, 3)
    println(nextPermutation1(arr))

    arr = arrayListOf(4, 1, 7, 5, 3, 2, 0)
    println(nextPermutation(arr))
    arr = arrayListOf(4, 1, 7, 5, 3, 2, 0)
    println(nextPermutation1(arr))
}

private fun nextPermutation(permutation: ArrayList<Int>): ArrayList<Int> {

    val size = permutation.size

    // find pivot index
    var pivotIndex = size - 2
    while (pivotIndex >= 0 && permutation[pivotIndex] >= permutation[pivotIndex + 1]) {
        pivotIndex--
    }

    if (pivotIndex >= 0) {
        // find successor index
        var successorIndex = size - 1
        while (successorIndex > pivotIndex && permutation[successorIndex] <= permutation[pivotIndex]) {
            successorIndex--
        }

        swap(permutation, pivotIndex, successorIndex)
    }

    reverse(permutation, pivotIndex + 1, size - 1)

    return permutation
}

private fun nextPermutation1(permutation: ArrayList<Int>): ArrayList<Int> {

    val size = permutation.size

    // find pivot index
    var pivotIndex = size - 2
    while (pivotIndex >= 0) {
        if (permutation[pivotIndex] >= permutation[pivotIndex + 1]) {
            pivotIndex--
        } else {
            break
        }
    }

    if (pivotIndex < 0) {
        reverse(permutation, 0, size - 1)
    } else {
        // find successor index
        var successorIndex = size - 1
        while (successorIndex > pivotIndex) {
            if (permutation[successorIndex] <= permutation[pivotIndex]) {
                successorIndex--
            } else {
                break
            }
        }

        swap(permutation, pivotIndex, successorIndex)

        reverse(permutation, pivotIndex + 1, size - 1)
    }

    return permutation
}

private fun reverse(arr: ArrayList<Int>, start: Int, end: Int) {
    var start = start
    var end = end
    while (start < end) {
        swap(arr, start, end)

        start++
        end--
    }
}

private fun swap(arr: ArrayList<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}






