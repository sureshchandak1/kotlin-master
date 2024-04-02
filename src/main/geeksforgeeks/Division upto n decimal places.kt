fun main() {
    var x = 22
    var y = 7
    var n = 15
    precisionCompute(x, y, n)

    x = 22
    y = 7
    n = 10
    precisionCompute(x, y, n)

    x = 22
    y = 7
    n = 5
    precisionCompute(x, y, n)

    x = 22
    y = 7
    n = 2
    precisionCompute(x, y, n)

    x = 22
    y = 7
    n = 0
    precisionCompute(x, y, n)
}

private fun precisionCompute(x: Int, y: Int, n: Int) {

    // Base cases
    var x = x
    var y = y
    if (y == 0) {
        print("Infinite")
        return
    }
    if (x == 0) {
        print("0")
        return
    }
    if (n <= 0) {
        // Since n <= 0, don't compute after
        // the decimal
        print(x / y)
        return
    }


    // Handling negative numbers
    if (((x > 0) && (y < 0)) || ((x < 0) && (y > 0))) {
        print("-")
        x = if (x > 0) x else -x
        y = if (y > 0) y else -y
    }


    // Integral division
    var d = x / y


    // Now one by print digits after dot
    // using school division method.
    for (i in 0..n) {
        print(d)
        x -= (y * d) // x = x - (y * d)

        if (x == 0) break

        x *= 10 // x = x * 10
        d = x / y

        if (i == 0) print(".")
    }

    println()
}


