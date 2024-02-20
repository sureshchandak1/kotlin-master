import java.util.*


fun main() {
    val arr1 = intArrayOf(4, 3, 1, 1, 3, 3, 2)
    val arr2 = intArrayOf(5, 5, 4)
    printArray(arr1)
    println(findUniqueInts(arr1, 3))
}

private fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
    Arrays.sort(arr)
    printArray(arr)

    val size = arr.size

    var kIndex = k
    var end = size - 1
    var removeValue = 0
    while (kIndex > 0 && end >= 0) {
        if (removeValue == 0 || arr[end] != removeValue) {
            removeValue = arr[end]
            arr[end] = -1

            kIndex--
        }

        end--
    }

    printArray(arr)

    val set = HashSet<Int>()
    for (value in arr) {
        if (value != -1) {
            set.add(value)
        }
    }

    return set.size
}

private fun findUniqueInts(arr: IntArray, k: Int): Int {
    var k = k

    val countMap = HashMap<Int, Int>()
    for (value in arr) {
        countMap.merge(value, 1) { a, b ->
            Integer.sum(a, b)
        }
    }

    val valueList: MutableCollection<Int> = countMap.values
    printArray<Int>(valueList)
    val minHeap: Queue<Int> = PriorityQueue(countMap.values)
    println("PriorityQueue = $minHeap")

    while (k > 0) k -= minHeap.poll()

    return minHeap.size + (if (k < 0) 1 else 0)
}
