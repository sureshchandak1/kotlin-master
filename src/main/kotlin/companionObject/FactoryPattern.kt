package companionObject

fun main(args: Array<String>) {
    val pizza1 = Pizza.Factory.create("Peppy Paneer")
    println(pizza1)

    // Here I am calling via Factory reference - don't want to use Factory ref
    // Now after defining that as companion
    val pizza2 = Pizza.create("Tomato")
    println(pizza2)

    // We want everyone to call this create method if they want Pizza
    // for that we will mark the constructor as private
//    val pizza3 = Pizza() // Now everyone needs to call create method

}

class Pizza private constructor(private val type: String, private val toppings: String) {

    companion object Factory {
        fun create(pizzaType: String) : Pizza {
            return when (pizzaType) {
                "Tomato" -> Pizza("Tomato", "Tomato, Cheese")
                "Peppy Paneer" -> Pizza("Paneer Farm", "Paneer, Cheese Burst, Tomato, Onion")
                else -> Pizza("Basic", "Onion, Cheese")
            }
        }
    }

    override fun toString(): String {
        return "Pizza(type='$type', toppings='$toppings')"
    }

}



