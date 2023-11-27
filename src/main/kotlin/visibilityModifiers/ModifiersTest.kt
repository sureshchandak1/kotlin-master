package visibilityModifiers

class ModifiersTest {
    val a: A = A()
    internal val c: C = C()
}

fun modifiersTest() {
    val a: A = A()
    val c: C = C()
    gn()
}