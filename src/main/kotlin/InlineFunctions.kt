fun main() {
    calculateTimeAndRun {
        loop(10000000)
    }

    calculateTimeAndRun {
        loop(10000000)
    }

}

private inline fun calculateTimeAndRun(fn: () -> Unit) {
    val start = System.currentTimeMillis()
    fn()
    val end = System.currentTimeMillis()
    println("Time taken ${ end - start } ms")
}

private fun loop(n: Long) {
    for (i in 1..n) {
        //
    }
}

inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {

}


