// Valid Triangle
/*   Conditions-----
*    A + B > C
*    B + C > A
*    C + A > B
* */

fun main() {
    val a = readln()
    val b = readln()
    val c = readln()

    println(isValidTriangle(a.toInt(), b.toInt(), c.toInt()))
}

private fun isValidTriangle(a: Int, b: Int, c: Int) : Boolean = (a + b) > c && (b + c) > a && (c + a) > b





