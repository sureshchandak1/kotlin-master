package visibilityModifiers

/*
*  - There are four visibility modifiers in Kotlin: private, protected, internal, and public
*  - The default visibility is public
*
*  -> If you don't use a visibility modifier, public is used by default,
*     which means that your declarations will be visible everywhere.
*  -> If you mark a declaration as private,
*     it will only be visible inside the file that contains the declaration.
*  -> If you mark it as internal, it will be visible everywhere in the same module.
*  -> The protected modifier is not available for top-level declarations.
*
*  - If you override a protected or an internal member and do not specify the visibility explicitly,
*    the overriding member will also have the same visibility as the original.
*
* */
fun main(args: Array<String>) {
    val objA = A()
    val objB = B()

    // objA.p  objA.r
    // objB.p  objB.r

}

open class A {
    public val p = 10 // public by default
    private val q = 20
    internal val r = 30
    protected val s = 40
}
private class B : A() {
    init {
        println(p)
//        println(q) // not allow outside class
        println(r)
        println(s)
    }
}
internal class C

val b = 20

fun gn() {}

private fun foo() {  } // visible inside only this file Modifiers.kt

public var bar: Int = 5 // property is visible everywhere
    private set         // setter is visible only in Modifiers.kt

internal val baz = 6    // visible inside the same module

open class Outer {
    private val a = 1
    protected open val b = 2
    internal open val c = 3
    val d = 4  // public by default

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible

    override val b = 5   // 'b' is protected
    override val c = 7   // 'c' is internal
}

class Unrelated(o: Outer) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
}



