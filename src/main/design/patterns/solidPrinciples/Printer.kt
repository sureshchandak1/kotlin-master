package solidPrinciples

internal interface IPrinter {
    fun print(shape: IShape)
}

internal class Printer : IPrinter {

    override fun print(shape: IShape) {
        println(shape)
    }
}