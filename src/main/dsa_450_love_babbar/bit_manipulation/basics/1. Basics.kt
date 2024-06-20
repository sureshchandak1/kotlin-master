package bit_manipulation.basics

fun main() {
    val bitwiseOperator = BitwiseOperator()
    bitwiseOperator.andOperator()
    bitwiseOperator.orOperator()
    bitwiseOperator.xorOperator()

    println("Enter number for on/off/toggle/check bit operation: ")
    val n = readln().toInt()
    println("Enter bit position for perform operation: ")
    val position: Int = readln().toInt()

    println("n = ${n.to32bitString()}")

    bitwiseOperator.onBit(n, position)
    bitwiseOperator.offBit(n, position)
    bitwiseOperator.toggleBit(n, position)
    bitwiseOperator.checkBit(n, position)
}

private class BitwiseOperator {

    fun andOperator() {
        println("------------- AND --------------")
        println("0 and 0 = ${0 and 0}")
        println("0 and 1 = ${0 and 1}")
        println("1 and 0 = ${1 and 0}")
        println("1 and 1 = ${1 and 1}")
    }

    fun orOperator() {
        // Switch bits on
        println("------------- OR --------------")
        println("0 or 0 = ${0 or 0}")
        println("0 or 1 = ${0 or 1}")
        println("1 or 0 = ${1 or 0}")
        println("1 or 1 = ${1 or 1}")
    }

    fun xorOperator() {
        // Switch bits off
        println("------------- XOR --------------")
        println("0 xor 0 = ${0 xor 0}")
        println("0 xor 1 = ${0 xor 1}")
        println("1 xor 0 = ${1 xor 0}")
        println("1 xor 1 = ${1 xor 1}")
    }

    fun onBit(n: Int, position: Int) {

        val onMask: Int = (1 shl position)
        println("onMask = ${onMask.to32bitString()}")

        println(n or onMask)
    }

    fun offBit(n: Int, position: Int) {

        // .inv(), 1's compliment like not operator. reverse bits 0 to 1 and 1 to 0
        val offMask: Int = (1 shl position).inv()
        println("offMask = ${offMask.to32bitString()}")

        println(n and offMask)
    }

    fun toggleBit(n: Int, position: Int) {

        val toggleMask: Int = (1 shl position)
        println("toggleMask = ${toggleMask.to32bitString()}")

        println(n xor toggleMask)
    }

    fun checkBit(n: Int, position: Int) {

        val checkMask: Int = (1 shl position)
        println("checkMask = ${checkMask.to32bitString()}")

        println(((n and checkMask) == 0))
    }
}

fun Int.to32bitString(): String =
    Integer.toBinaryString(this).padStart(Int.SIZE_BITS, '0')









