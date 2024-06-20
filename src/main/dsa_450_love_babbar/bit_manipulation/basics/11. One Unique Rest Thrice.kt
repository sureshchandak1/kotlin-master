package bit_manipulation.basics

fun main() {
    var arr = intArrayOf(51, 57, 51, 57, 63, 38, 57, 63, 63, 51)
    println(findUnique(arr))

    arr = intArrayOf(0,1,0,1,0,1,99)
    println(findUnique(arr))
}

private fun findUnique(arr: IntArray): Int {

    var _3n = Int.MAX_VALUE
    var _3n1 = 0
    var _3n2 = 0

    for (value in arr) {
        val commonWith3n = value and _3n
        val commonWith3n1 = value and _3n1
        val commonWith3n2 = value and _3n2

        _3n = _3n and commonWith3n.inv() // off in 3n
        _3n1 = _3n1 or commonWith3n // on in 3n1

        _3n1 = _3n1 and commonWith3n1.inv()
        _3n2 = _3n2 or commonWith3n1

        _3n2 = _3n2 and commonWith3n2.inv()
        _3n = _3n or commonWith3n2

    }

    return _3n1
}