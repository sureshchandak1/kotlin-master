fun main() {
    println(timeConversion("07:05:45PM"))
    println(timeConversion("12:01:00AM"))
}

private fun timeConversion(s: String): String {
    val getZone = s.substring(8, 10) // AM, PM
    val getTime = s.substring(0, 8)  // hh:mm:ss
    val getHour = s.substring(0, 2)  // hh
    val getMinutes = s.substring(2, 8) // :mm:ss

    return if (getZone == "AM") {
        if (getHour == "12") "00$getMinutes" else getTime
    } else {
        val sum = getHour.toInt() + 12
        if (getHour == "12") getTime else "$sum$getMinutes"
    }
}





