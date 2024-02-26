package lecture043_OOPs_Day2

/*
*  Types:
*  1. Compile-time polymorphism (Method overloading or Operator overloading)
*  2. Run-time polymorphism
* */
fun main() {

}

// Compile-time polymorphism
private class Test {

    fun sayHello() {
        println("Hello")
    }

    fun sayHello(name: String) {
        println("Hello $name")
    }

}