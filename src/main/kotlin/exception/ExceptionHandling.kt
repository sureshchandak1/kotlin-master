package exception

import java.lang.IllegalArgumentException

/*
*  -> Checked Exception:
*     Exceptions that are typically set on methods and checked at the compile time,
*     for example IOException, FileNotFoundException etc
*  -> UnChecked Exception:
*     Exceptions that are generally due to logical errors and checked at the run time,
*     for example NullPointerException, ArrayIndexOutOfBoundException etc
*
*  In Kotlin, we have only unchecked exceptions and can be caught only at run time
*
* */
fun main() {
    val arr = arrayOf(1, 2, 3)

    try {
        println(arr[1]) // println(arr[5])
    } catch (e: NullPointerException) {
        println("Please handle null value")
    } catch (e: Exception) {
        println("Please check the array index")
    } finally {
        println("I will execute no matter what")
    }

    try {}
    catch (_: Exception) {}

    try {}
    finally {}

    createUserList(5)
    createUserList(-2)
}

private fun createUserList(count: Int) {
    if (count < 0) {
        // Exception raise
        throw IllegalArgumentException("Count must be greater than 0")
    } else {
        println("User list created containing $count users")
    }
}


