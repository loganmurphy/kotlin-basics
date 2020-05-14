package example.myapp

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

// object keyword signifies a singleton class
object GoldColor: FishColor {
    override val color = "gold"
}

class PrintingFishAction(private val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}

class Shark: FishAction, FishColor  {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

/* the keyword by indicates a delegate should be used */
class Plecostomus(fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor


