package solidPrinciples

internal interface IShape {

}

internal interface I2DShape : IShape {
    fun area() : Double
}

internal interface I3DShape : IShape {
    fun volume() : Double
}

internal class Circle(private val radius: Double) : I2DShape {

    override fun area() : Double {
        return Math.PI * radius * radius
    }

}

internal class Rectangle(private val length: Double,
                         private val breadth: Double) : I2DShape {

    override fun area() : Double {
        return length * breadth
    }

}

internal class Square(private val side: Double) : I2DShape {

    override fun area() : Double {
        return side * side
    }

}

internal class Cube(private val side: Double) : I3DShape {

    override fun volume(): Double {
        return side * side * side
    }

}