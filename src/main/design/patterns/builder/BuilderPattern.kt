package builder

fun main(args: Array<String>) {
    val mobileShop = MobileShop()
    val phone = mobileShop.createSamsungPhone()
    println(phone)
}

private class MobileShop {
    fun createSamsungPhone() : CellPhone {
        return SamsungPhoneBuilder().setOs("Android").setCamera(20).build()
    }
}

private interface ICellPhoneBuilder {
    fun build() : CellPhone
    fun setOs(os: String): ICellPhoneBuilder
    fun setProcessor(processor: String?): ICellPhoneBuilder
    fun setScreenSize(screenSize: Double): ICellPhoneBuilder
    fun setBattery(battery: Int): ICellPhoneBuilder
    fun setCamera(camera: Int): ICellPhoneBuilder

}

private class SamsungPhoneBuilder : ICellPhoneBuilder {

    private val brand = "Samsung"
    private var os: String = ""
    private var processor: String? = null
    private var screenSize = 0.0
    private var battery = 0
    private var camera = 0

    override fun build(): CellPhone {
        return CellPhone(
            brand = brand,
            os = os,
            processor = processor,
            screenSize = screenSize,
            battery = battery,
            camera = camera
        )
    }

    override fun setOs(os: String): ICellPhoneBuilder {
        this.os = os
        return this
    }

    override fun setProcessor(processor: String?): ICellPhoneBuilder {
        this.processor = processor
        return this
    }

    override fun setScreenSize(screenSize: Double): ICellPhoneBuilder {
        this.screenSize = screenSize
        return this
    }

    override fun setBattery(battery: Int): ICellPhoneBuilder {
        this.battery = battery
        return this
    }

    override fun setCamera(camera: Int): ICellPhoneBuilder {
        this.camera = camera
        return this
    }

}

private data class CellPhone(
    private val brand: String,
    private val os: String,
    private val processor: String?,
    private val screenSize: Double,
    private val battery: Int,
    private val camera: Int
)



