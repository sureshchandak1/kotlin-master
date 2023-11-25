package polymorphism

/*
*  Parent can hold a reference to its child
*
* */
fun main() {
    val circle: Circle = Circle(4.0)
    val square: Square = Square(4.0)

    println(circle.area())
    println(square.area())

    val circle2: Shape = Circle(4.0)
    val square2: Shape = Square(4.0)

    println(circle2.area())
    println(square2.area())

    val shapes: Array<Shape> = arrayOf(Circle(4.0), Square(4.0), Triangle(3.0, 4.0))
    calculateAreas(shapes)

    printArea(Shape())
    printArea(Circle(4.0))
}

fun printArea(shape: Shape) {
    println(shape.area())
}

fun calculateAreas(shapes: Array<Shape>) {
    for (shape in shapes) {
        println(shape.area())
    }
}

open class Shape {
    open fun area() : Double {
        return 0.0
    }

    override fun toString(): String {
        return "I am Shape"
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

class Square(val side: Double) : Shape() {
    override fun area(): Double {
        return side * side
    }
}

class Triangle(val base: Double, val height: Double) : Shape() {
    override fun area(): Double {
        return 0.5 * base * height
    }
}

/*
*       Any
*        ^
*       Shape
*        ^
*       Circle
* */
