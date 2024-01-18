package `when`

fun main() {
    val amount = readln()
    findNoteCount(amount.toInt())
}

private fun findNoteCount(am: Int) : Int {

    var amount = am
    var count = 0

    if (amount <= 0) {
        return 0
    }

    if (amount >= 100) {
        val count100 = amount / 100
        count += count100
        amount -= (count100 * 100)
        println("100 Notes = $count100")
    }
    if (amount >= 50) {
        val count50 = amount / 50
        count += count50
        amount -= (count50 * 50)
        println("50 Notes = $count50")
    }
    if (amount >= 20) {
        val count20 = amount / 20
        count += count20
        amount -= (count20 * 20)
        println("20 Notes = $count20")
    }
    if (amount >= 1) {
        val count1 = amount / 1
        count += count1
        println("1 Notes = $count1")
    }

    println("Total Notes = $count")
    return count
}