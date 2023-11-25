package inheritance

/*
*  - All classes in Kotlin have a common superclass, Any, which is the default superclass for a class with no supertypes declared
*    eg: class Example // Implicitly inherits from Any
*  - Any has three methods: equals(), hashCode(), and toString(). Thus, these methods are defined for all Kotlin classes.
*  - By default, Kotlin classes are final – they can't be inherited. To make a class inheritable, mark it with the open keyword:
*    eg: open class Base(p: Int) // Class is open for inheritance
*        class Derived(p: Int) : Base(p)
* */

/*
*  Car is a Vehicle, Truck is a Vehicle // Vehicle is parent class
*  Square is a Shape, Circle is a Shape // Shape is parent class
*  Cat is an Animal, Dog is an Animal // Animal is parent class
*  Saving Account, Current Account, Credit Card Account // Account is parent class
*  Full Time Employee, Part Time Employee // Employee is parent class
* */

fun main() {
    val objChild = Child()
    objChild.myMethod()
    objChild.myMethod2()
}

open class Parent {
    val name: String = ""

    init {
        println("Parent's constructor is called")
    }

    fun myMethod() {
        println("I am in Parent")
    }
}

class Child : Parent() {
    val name2: String = ""

    init {
        println("Child's constructor is called")
    }

    fun myMethod2() {
        println("I am in Child")
    }
}



