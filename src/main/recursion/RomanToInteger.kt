fun main() {
    val obj = RomanToInteger()
    val s = "MCMXCIV"
    println("$s = ${obj.romanToInteger(s)}")
}

class RomanToInteger {

    private val map: MutableMap<Char, Int> = LinkedHashMap()
    init {
        map['I'] = 1
        map['V'] = 5
        map['X'] = 10
        map['L'] = 50
        map['C'] = 100
        map['D'] = 500
        map['M'] = 1000
    }

    internal fun romanToInteger(s: String): Int {
        return romanToInteger(s, 0)
    }

    private fun romanToInteger(s: String, index: Int): Int {
        if (index == s.length) {
            return 0
        }
        return getNumber(s, index) + romanToInteger(s.substring(index + 1))
    }

    private fun getNumber(s: String, index: Int): Int {
        if (index + 1 == s.length) {
            return map[s[index]]!!
        }

        return if (map[s[index]]!! >= map[s[index + 1]]!!) {
            map[s[index]]!!
        } else {
            -map[s[index]]!!
        }
    }

}