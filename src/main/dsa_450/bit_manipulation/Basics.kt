package bit_manipulation

fun main() {
    val n = readln().toInt()

    println(
        "The bit at the 3rd position from LSB is: " +
                (if (getBit(n, 3)) '1' else '0')
    )

    println(
        "The value of the given number " +
                "after setting the bit at " +
                "LSB is: " + setBit(n, 0)
    )

    println(
        ("The value of the given number " +
                "after clearing the bit at " +
                "LSB is: " + clearBit(n, 0))
    )
}

// Function to get the bit at the ith position
private fun getBit(num: Int, i: Int): Boolean {
    // Return true if the ith bit is  set. otherwise return false
    return ((num and (1 shl i)) != 0)
}

// Function to set the ith bit of the given number num
private fun setBit(num: Int, i: Int): Int {
    // Sets the ith bit and return the updated value
    return num or (1 shl i)
}

// Function to clear the ith bit of the given number num
private fun clearBit(num: Int, i: Int): Int {

    val mask = (1 shl i).inv() // Create the mask for the ith bit unset

    return num and mask // Return the updated value
}







