package overriding

/*
*      Overriding methods
*  - open keyword is required if want to override method
*  - final keyword is prevent for re-overriding
*      Overriding properties
*  - open keyword is required if want to override property
*  - also override a val property with a var property, but not vice versa
* */
fun main() {
    val mobile = Mobile("General")
    mobile.display()

    val onePlus = OnePlus("SmartPhone")
    onePlus.display()

    val onePlus10T = OnePlus10T("SmartPhone")
    onePlus10T.display()
    println(onePlus10T.toString())

    onePlus10T.powerOff()

//    val mobile1: Mobile = OnePlus("SmartPhone")
//    mobile1.display()
}

open class Mobile(val type: String) {
    open val name: String = ""
    open val size: Int = 5

    fun makeCall() = println("Calling from mobile")
    open fun powerOff() = println("Shutting down")
    open fun display() = println("Simple mobile display")
}

open class OnePlus(type: String) : Mobile(type) {

    override val name: String
        get() = "OnePlus"

    final override val size: Int
        get() = 6

    override fun display() = println("OnePlus display")

    final override fun powerOff() {
        println("OnePlus Shut Down")
        super.powerOff()
    }
}

class OnePlus10T(type: String) : OnePlus(type) {

    override val name: String
        get() = "OnePlus 10T"

    override fun display() = println("OnePlus 10T display")

    override fun toString(): String {
        return "Name - $name, Size - $size"
    }

}