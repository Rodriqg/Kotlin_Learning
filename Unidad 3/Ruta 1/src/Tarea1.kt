//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val evento1 = Event1(
        "Estudiar Kotlin",
        "Comprometerse a estudiar Kotlin al menos 15 minutos al día.",
        "Noche",
        15
    )
    println(evento1)
}

data class Event1(
    val title: String,
    val description: String?,
    val daypart: String,
    val durationInMinutes: Int
)