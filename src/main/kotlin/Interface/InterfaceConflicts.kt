package Interface

fun main() {
    val a: A = D()
    a.foo()
    a.bar()
}

interface A {
    fun foo() { println("A") }
    fun bar()
}

interface B {
    fun foo() { println("B") }
    fun bar() { println("B - bar") }
}

class C : A {
    override fun bar() { println("C - bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
        println("D")
    }

    override fun bar() {
        super<B>.bar()
        println("D - bar")
    }
}