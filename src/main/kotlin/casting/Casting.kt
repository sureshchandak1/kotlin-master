package casting

fun main() {

    val player1: Draggable = Player("A")
    (player1 as Player).sayMyName()

    val player2: Draggable = Player("B")
    if (player2 is Player) {
        player2.sayMyName()
    }

    val arr: Array<Draggable> = arrayOf(
        Circle(4.0),
        Square(4.0),
        Triangle(3.0, 4.0),
        Player("Smiley")
    )

    for (obj in arr) {
        when (obj) {
            is Circle -> {
                println("Radius - ${obj.radius}, Area - ${obj.area()}")
            }

            is Square -> {
                println("Side - ${obj.side}, Area - ${obj.area()}")
            }

            is Triangle -> {
                println("Base - ${obj.base}, Height - ${obj.height}, Area - ${obj.area()}")
            }

            is Player -> {
                obj.sayMyName()
            }
        }
    }
}

interface Draggable {
    fun drag()
}

abstract class Shape : Draggable {
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
    override fun drag() = println("$name is dragging")
    fun sayMyName() = println("Hey my name is - $name")
}


