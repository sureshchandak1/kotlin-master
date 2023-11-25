package Interface

/*
*  - Interfaces can contain declarations of abstract methods, as well as method implementations
*  - A property declared in an interface can either be abstract or provide implementations for accessors
* */
fun main(args: Array<String>) {
    dragObjects(arrayOf(
        Circle(4.0),
        Square(4.0),
        Triangle(3.0, 4.0),
        Player("Smiley")
    ))
}

fun dragObjects(objects: Array<Draggable>) {
    for (obj in objects) {
        obj.drag()
    }
}

interface Draggable {
    val dragSpeed: Int get() = 10
    fun drag()
}

interface Cloneable {
    fun clone() {  }
}

abstract class Shape : Draggable, Cloneable {
    final override val dragSpeed: Int
        get() = 20
    abstract fun area() : Double
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
    override fun drag() = println("Circle is dragging")
}

class Square(val side: Double) : Shape() {
    override fun area(): Double = side * side
    override fun drag() = println("Square is dragging")
}

class Triangle(val base: Double, val height: Double) : Shape() {
    override fun area(): Double = 0.5 * base * height
    override fun drag() = println("Triangle is dragging")
}

class Player(val name: String) : Draggable {
    override val dragSpeed: Int
        get() = 15
    override fun drag() = println("$name is dragging")
}




