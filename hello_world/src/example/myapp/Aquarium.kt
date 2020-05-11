package example.myapp
import java.lang.Math.PI

open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    init {
       println("aquarium initializing")
    }

    constructor(numberOfFish: Int): this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1

        // calculate needed height
        height  = (tank / (length * width)).toInt()
    }

    open var volume: Int
        get() = width * height * length / 1000 // 1000 cm^3 = 1l
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var water: Double = 0.0
        get() = volume * 0.9

    open val shape: String = "rectangle"

    fun getPercentFull(): Double = water / volume * 100.0

    fun printSize() {
        println("""
            Shape: $shape
            Length: $length cm
            Width: $width cm
            Height: $height cm
            Volume: $volume l
            Water: $water l (${getPercentFull()}% full)
        """)
    }
}

class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
    // ellipse area = pi * r1 * r2
    get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
    set(value) {
        height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
    }

    override  var water = volume * 0.8

    override  val shape = "cylinder"
}