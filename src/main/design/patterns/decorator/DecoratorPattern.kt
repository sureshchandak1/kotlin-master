package decorator

fun main() {
    val basePizza: IPizza = BasePizza()
    basePizza.prepare()
    println("----------------------------")
    val pepperoniPizza: IPizza = PepperoniPizza(basePizza)
    pepperoniPizza.prepare()
    println("----------------------------")
    val onionPizza = OnionPizza(basePizza)
    onionPizza.prepare()
    println("----------------------------")
    val capsicumPizza = CapsicumPizza(basePizza)
    capsicumPizza.prepare()
    println("----------------------------")

    val pizza = OnionPizza(CapsicumPizza(PepperoniPizza(BasePizza())))
    pizza.prepare()
}

private interface IPizza {
    fun prepare()
}

private class BasePizza : IPizza {
    override fun prepare() {
        println("Pizza prepared")
    }
}

private abstract class PizzaDecorator protected constructor(private val pizza: IPizza) : IPizza {

    override fun prepare() {
        pizza.prepare()
    }
}

private class PepperoniPizza(pizza: IPizza) : PizzaDecorator(pizza) {
    override fun prepare() {
        super.prepare()
        println("Adding Pepperoni Topping")
    }
}

private class OnionPizza(pizza: IPizza) : PizzaDecorator(pizza) {
    override fun prepare() {
        super.prepare()
        println("Adding Onion Topping")
    }
}

private class CapsicumPizza(pizza: IPizza) : PizzaDecorator(pizza) {
    override fun prepare() {
        super.prepare()
        println("Adding Capsicum Topping")
    }
}