package bridge

fun main() {
    var engine: Engine = ElectricEngine()
    var vehicle: Vehicle = Car(engine)
    vehicle.refill()
    vehicle = Bike(engine)
    vehicle.refill()

    engine = PetrolEngine()
    vehicle = Car(engine)
    vehicle.refill()
    vehicle = Bike(engine)
    vehicle.refill()
}

private interface Engine {
    fun refill() : String
}

private abstract class Vehicle(protected val engine: Engine) {
    abstract fun refill()
}

private class Car(engine: Engine) : Vehicle(engine) {
    override fun refill() {
        println("Car: ${engine.refill()}")
    }
}

private class Bike(engine: Engine) : Vehicle(engine) {
    override fun refill() {
        println("Bike: ${engine.refill()}")
    }
}

private class ElectricEngine : Engine {
    override fun refill(): String {
        return "Charged engine to 100%"
    }
}

private class PetrolEngine : Engine {
    override fun refill(): String {
        return "Refueled engine to 5 liters"
    }
}