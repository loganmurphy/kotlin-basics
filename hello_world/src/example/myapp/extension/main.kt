package example.myapp.extension


fun String.hasSpaces(): Boolean {
    val found = this.find { it == ' ' }
    return found != null
}


/* another example with simplified syntax with an explicit return type */
fun String.hasDashes(): Boolean = find { it == ' ' } != null


/* extensions can only be called on public class members */
open class AquariumPlant(val color: String, private val size: Int)

/* this is a valid extension because color is public */
fun AquariumPlant.isRed() = color == "red"

/* size is a private property so this will throw a compilation error */
//fun AquariumPlant.isBig() = size > 50

val AquariumPlant.isGreen: Boolean
    get() = color == "green"

class GreenLeafyPlant(size: Int): AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")

fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun main() {
    println("Does this have spaces?".hasSpaces())
    println("Does this have ---".hasDashes())

    val plant = GreenLeafyPlant(size = 20)
    plant.print()
    println("\n")

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()
    println(aquariumPlant.isGreen)
    println(aquariumPlant.pull())

    val nullPlant: AquariumPlant? = null
    println(nullPlant.pull())
}