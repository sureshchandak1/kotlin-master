package lecture054_Stack_Implementation

fun main() {

}

private class TwoStack(s: Int) {

    private val arr = IntArray(s)
    private var top1 = -1
    private var top2 = s
    private val size = s

    // Push in stack 1.
    fun push1(num: Int) {
        if (top2 - top1 > 1) {
            top1++
            arr[top1] = num
        }
    }

    // Push in stack 2.
    fun push2(num: Int) {
        if (top2 - top1 > 1) {
            top2--
            arr[top2] = num
        }
    }

    // Pop from stack 1 and return popped element.
    fun pop1(): Int {
        if (top1 >= 0) {
            val ans = arr[top1]
            top1--
            return ans
        }
        return -1
    }

    // Pop from stack 2 and return popped element.
    fun pop2(): Int {
        if (top2 < size) {
            val ans = arr[top2]
            top2++
            return ans
        }
        return -1
    }
}