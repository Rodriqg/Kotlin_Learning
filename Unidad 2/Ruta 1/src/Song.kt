class Song(
    val title: String,
    val artist: String,
    val year: Int,
    val playCount: Int
) {
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, interpretada por $artist, se lanzó en $year")
    }
}

fun main() {
    val song = Song(
        "Imagine",
        "John Lennon",
        1971,
        5000
    )

    println(song.isPopular)
    song.printDescription()
}