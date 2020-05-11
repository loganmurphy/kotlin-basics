package example.myapp

fun buildAquarium() {
    val myAquarium = Aquarium(numberOfFish = 25)
    myAquarium.volume = 70
    myAquarium.printSize()

    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

fun main() {
    buildAquarium()
}