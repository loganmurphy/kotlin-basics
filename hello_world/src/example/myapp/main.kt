package example.myapp

fun buildAquarium() {
    val myAquarium = Aquarium(numberOfFish = 25)
    myAquarium.volume = 70
    myAquarium.printSize()

    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()

    myTower.printSuperWater()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()

    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main() {
    buildAquarium()
//    makeFish()
}