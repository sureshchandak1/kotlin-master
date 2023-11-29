package nested

fun main() {
    val nestedOuter = NestedOuter()
    val nested = NestedOuter.Nested()
    nested.foo()

    val innerOuter = InnerOuter()
    val inner = innerOuter.Inner()
    inner.foo()
}

class NestedOuter {
    private val bar: Int = 1
    class Nested {
        fun foo() = println("I am a Nested class")
    }
}

// A nested class marked as inner can access the members of its outer class.
class InnerOuter {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = println("I am a Inner class with bar = $bar")
    }
}






