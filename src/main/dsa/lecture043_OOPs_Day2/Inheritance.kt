package lecture043_OOPs_Day2

private open class A {

    open fun abc() {
        println("A - abc")
    }

}

private open class B {

    open fun abc() {
        println("B - abc")
    }

}

private class C : A() {

}

fun main() {
    val c = C()
    c.abc()
}