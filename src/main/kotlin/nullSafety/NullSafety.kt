package nullSafety

/*
*  - not-null assertion operator (!!)
*    converts any value to a non-nullable type and throws an exception if the value is null
* */
fun main() {
    var name: String = "" // Not allow to assign null
    var gender: String? = null // allow to assign null

    if (gender != null) {
        println(gender.uppercase())
    }

    println(gender?.uppercase())

    gender?.let {
        println("Line 1")
        println("Line 2 $gender")
        println("Line 3 $it")
    }

    // ?: -> Elvis Operator (If value is null then set default value)
    val selectedValue: String = gender ?: "NA"

    // not-null assertion operator (!!)
    val value: String = gender!!.uppercase() // here throw NullPointerException

    val a: Double? = 10.0
    val b: Int? = a as? Int // Safe casts

}