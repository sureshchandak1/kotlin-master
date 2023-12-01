package abstractFactory

fun main(args: Array<String>) {

    var waiter = Waiter()

    var pizza: IPizza = waiter.getPizza()
    var burger: IBurger = waiter.getBurger()
    pizza.eat()
    burger.eat()

    println("--------------------------------")

    waiter = Waiter("NonVeg")
    pizza = waiter.getPizza()
    burger = waiter.getBurger()
    pizza.eat()
    burger.eat()
}

private interface IPizza { // ProductA
    fun eat()
}

private class VegPizza : IPizza { // ConcreateProduct1A
    override fun eat() {
        println("Eating veg pizza")
    }
}

private class NonVegPizza : IPizza { // ConcreateProduct2A
    override fun eat() {
        println("Eating non-veg pizza")
    }
}

private interface IBurger { // ProductB
    fun eat()
}

private class VegBurger : IBurger { // ConcreateProduct1B
    override fun eat() {
        println("Eating veg burger")
    }
}

private class NonVegBurger : IBurger { // ConcreateProduct2B
    override fun eat() {
        println("Eating non-veg burger")
    }
}

private interface IChef { // Factory
    fun preparePizza(): IPizza
    fun prepareBurger(): IBurger
}

private class VegChef : IChef {
    override fun preparePizza(): IPizza {
        return VegPizza()
    }

    override fun prepareBurger(): IBurger {
        return VegBurger()
    }

}

private class NonVegChef : IChef {
    override fun preparePizza(): IPizza {
        return NonVegPizza()
    }

    override fun prepareBurger(): IBurger {
        return NonVegBurger()
    }

}

private class Waiter(preference: String = "") { // Client

    private val foodFactory: IChef

    init {
        foodFactory = when(preference) {
            "NonVeg" -> NonVegChef()
            else -> VegChef()
        }
    }

    fun getPizza() : IPizza {
        return foodFactory.preparePizza()
    }

    fun getBurger() : IBurger {
        return foodFactory.prepareBurger()
    }

}



