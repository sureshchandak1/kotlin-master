package `object`

/*
*  - Class and its Single Object is created at once.
*  - No constructors are allowed (init block is allowed)
*  - You can inherit class/interface
*  - Singleton Pattern
* */
fun main() {
    LikeObject.incrementTwitterLikes()
    LikeObject.incrementTwitterLikes()
    LikeObject.incrementTwitterLikes()
    LikeObject.incrementFBLikes()
    LikeObject.incrementFBLikes()
    LikeObject.display()

    // Object expression (Creating anonymous objects)
    val obj = object : Cloneable {
        override fun clone() {
            println("I am clone")
        }
    }
    obj.clone()

    val person = object : Person("Kotlin") {
        override fun fullName() {
            super.fullName()
            println("Anonymous - $name")
        }
    }
    person.fullName()

    MyClass.MyObject.print()

}

object LikeObject {
    private var twitterLikes = 0
    private var fbLikes = 0

    fun incrementTwitterLikes() = ++twitterLikes
    fun incrementFBLikes() = ++fbLikes
    fun display() = println("Twitter Likes = $twitterLikes, Facebook Likes = $fbLikes")
}

interface Cloneable {
    fun clone() {  }
}

open class Person(internal val name: String) {
    open fun fullName() = println("Full name - $name")
}

class MyClass {
    object MyObject {
        fun print() {
            println("Hello, I am print from object")
        }
    }
}



