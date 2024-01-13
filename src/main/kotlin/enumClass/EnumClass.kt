package enumClass

fun main(args: Array<String>) {
    val day = Day.SUNDAY
    println(day)
    println(day.number)

    for (obj: Day in Day.entries) {
        obj.printFormattedDay()
    }
}

// Each enum constant is an object
// Modifier 'open' is not applicable to 'enum class'
enum class Day(val number: Int) {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    fun printFormattedDay() {
        println("Day is $this")
    }
}

/*
* Not allow to extend enum class to another enum class
enum class Monday : Day {

}*/


