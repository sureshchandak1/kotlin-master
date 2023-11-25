package abstractclass

/*
*  - Class can't be instantiated (not allow to create abstract class object)
*  - Abstract class can have both abstract & not abstract properties and methods
*  - If a class has abstract method or property then class must be declared as abstract
* */
fun main(args: Array<String>) {
//    val shape: Shape = Shape() // not allow to create abstract class object
    val shape1: Shape = Circle(4.0)
    println(shape1.area())
    shape1.display()

    val shape2: BaseShape = Circle(4.0)
//    println(shape2.area()) // not allow to call area method because area method is not part of BaseShape class
//    shape2.display() // not allow to call display method because display method is not part of BaseShape class

}

// If you not allow to create BaseShape class object then simply class as abstract
abstract class BaseShape : Any() {

}

abstract class Shape : BaseShape() {
    val name: String = ""
    abstract fun area() : Double
    abstract fun display()
}

class Circle(val radius: Double) : Shape() {
    override fun area() = Math.PI * radius * radius

    override fun display() {
        println("Circle is getting displayed")
    }

}