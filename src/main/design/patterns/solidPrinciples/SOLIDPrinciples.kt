package solidPrinciples

/*
*         --------------------
*         S.O.L.I.D Principles
*         --------------------
*  S -> Single Responsibility Principle
*       A class should de one thing and therefore it should have only a single reason to change
*  O -> Open-Closed Principle
*       A class should be open for extension but closed to modification
*  L -> Liskov Substitution Principle
*       Derived or child classes must be substitutable for their base or parent classes
*  I -> Interface Segregation Principle
*       Classes should not be forced to implement a function they do not need
*  D -> Dependency Inversion Principle
*       High-level classes should not depend on low-level classes. Both should depend upon abstractions.
* */
fun main(args: Array<String>) {
    val circle: I2DShape = Circle(5.0)
    val rectangle: I2DShape = Rectangle(4.0, 5.0)
    val cube: I3DShape = Cube(5.0)
    calculateArea(circle)
    calculateArea(rectangle)

    val printer: IPrinter = Printer()
    printer.print(circle)
    printer.print(cube)
}

private fun calculateArea(shape: I2DShape) {
    println(shape.area())
}



