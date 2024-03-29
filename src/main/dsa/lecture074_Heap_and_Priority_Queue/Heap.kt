package lecture074_Heap_and_Priority_Queue

fun main() {
    val heap = Heap()

    heap.insert(50)
    heap.insert(55)
    heap.insert(53)
    heap.insert(52)
    heap.insert(54)
    heap.print()

    heap.delete()
    heap.print()
}

private class Heap {

    val arr = IntArray(100)
    var size = 0

    init {
        arr[0] = -1
    }

    fun insert(value: Int) {
        size += 1
        var index = size
        arr[index] = value

        while (index > 1) {
            val parent = index / 2 // getting parent index

            if (arr[parent] < arr[index]) {
                // a = 1, b = 2 swap value  a = b.also { b = a }
                arr[parent] = arr[index].also { arr[index] = arr[parent] } // swap value
                index = parent
            } else {
                return
            }
        }
    }

    fun delete() {
        if (size == 0) {
            println("Nothing to delete")
            return
        }

        // put last element into first index
        arr[1] = arr[size]
        // remove last element
        size--

        // take root node to its correct position
        var i = 1
        while (i < size) {
            val leftIndex = 2 * i
            val rightIndex = 2 * i + 1

            if (leftIndex < size && arr[i] < arr[leftIndex]) {
                arr[i] = arr[leftIndex].also { arr[leftIndex] = arr[i] } // swap
                i = leftIndex
            } else if (rightIndex < size && arr[i] < arr[rightIndex]) {
                arr[i] = arr[rightIndex].also { arr[rightIndex] = arr[i] } //swap
                i = rightIndex
            } else {
                return
            }
        }
    }

    fun print() {
        for (i in 1 .. size) {
            print("${arr[i]}  ")
        }
        println()
    }
}