package example.myapp.generics
import example.myapp.extension.hasSpaces

open class WaterSupply(var needsProcessing: Boolean)

class TapWater: WaterSupply(true) {
    fun addChemicalCleaners() { needsProcessing = false }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true) {
    fun filter() { needsProcessing = false }
}

/* generic Aquarium class, by default is nullable */
class Aquarium<T>(val waterSupply: T)

/* explicitly nullable */
class NullableAquarium<T: Any?>(val waterSupply: T)

/* non-nullable */
class NonNullableAquarium<T: Any /*Any is a generic constraint*/ >(val waterSupply: T)

/* explicitly typed */
class ExplicitAquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>){
        /* throw IllegalStateException if condition fails */
        check(!waterSupply.needsProcessing) { "water supply needs processing first" }

        if(waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
            println("adding water from $waterSupply")
        }
    }
}

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}

fun genericsExample() {
    val aquarium = Aquarium<TapWater>(TapWater())

    /* you can also leave out the type declaration and opt for it to be inferred */
    val inferredTypeAquarium = Aquarium(TapWater())

    println(aquarium.waterSupply.needsProcessing)
    aquarium.waterSupply.addChemicalCleaners()
    println(aquarium.waterSupply.needsProcessing)

    println(inferredTypeAquarium.waterSupply.needsProcessing)
    inferredTypeAquarium.waterSupply.addChemicalCleaners()
    println(inferredTypeAquarium.waterSupply.needsProcessing)

    val anotherAquarium = Aquarium("string")
    println(anotherAquarium.waterSupply)

    val nullAquarium = Aquarium(null)
    if (nullAquarium.waterSupply == null) {
        println("waterSupply is null!")
    }


    val explicitAquarium = ExplicitAquarium(LakeWater())
    explicitAquarium.waterSupply.filter()

    val cleaner = TapWaterCleaner()

    val outAquarium = ExplicitAquarium(TapWater())
    outAquarium.waterSupply.addChemicalCleaners()
    addItemTo(outAquarium)
    outAquarium.addWater(cleaner)
}

fun addItemTo(aquarium: ExplicitAquarium<WaterSupply>) = println("item added")

fun main() {
    /* importing and using an extension method */
//    println(" ".hasSpaces())
    genericsExample()
}