package factory

fun main(args: Array<String>) {
    val waiter = Waiter()
    var pizza: IPizza = waiter.getPizza()
    pizza.eat()
    pizza = waiter.getPizza("NonVeg")
    pizza.eat()
}

private interface IPizza { // Product
    fun eat()
}

private class VegPizza : IPizza {
    override fun eat() {
        println("Eating veg pizza")
    }
}

private class NonVegPizza : IPizza {
    override fun eat() {
        println("Eating non-veg pizza")
    }
}

private interface IPizzaChef { // Factory
    fun preparePizza(): IPizza
}

private class VegPizzaChef : IPizzaChef {
    override fun preparePizza(): IPizza {
        return VegPizza()
    }

}

private class NonVegPizzaChef : IPizzaChef {
    override fun preparePizza(): IPizza {
        return NonVegPizza()
    }

}

private class Waiter { // Client
    fun getPizza(type: String = "") : IPizza {
        val chef: IPizzaChef = when (type) {
            "NonVeg" -> NonVegPizzaChef()
            else -> VegPizzaChef()
        }
        return chef.preparePizza()
    }
}