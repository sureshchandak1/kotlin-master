package sealedClass

import java.io.File
import javax.sql.DataSource

/*
*  - To declare a sealed class or interface, put the sealed modifier before its name
* */
fun main() {
    val tile: Tile = Red("Mushroom", 25)
    val points = when (tile) {
        is Red -> tile.points * 2
        is Blue -> tile.points * 5
    }
    println(points)
}

sealed class Tile
class Red(val type: String, val points: Int) : Tile()
class Blue(val points: Int) : Tile()


sealed interface Error {
    sealed class IOError : Error {
        class FileReadError(val file: File): IOError()
        class DatabaseError(val source: DataSource): IOError()
        data object RuntimeError : IOError()
    }
}





