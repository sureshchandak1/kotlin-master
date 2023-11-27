package companionObject

/*
*  - Only one companion object is allowed per class
* */
fun main() {
    MyClass.print()
    MyClass.AnotherObject.print()
}

class MyClass {
    companion object MyObject {
        @JvmStatic
        fun print() {
            println("Hello, I am print from MyObject")
        }
    }

    object AnotherObject {
        fun print() {
            println("Hello, I am print from AnotherObject")
        }
    }
}