fun main() {

    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

    val event_list = mutableListOf(event1, event2, event3, event4, event5, event6)

    println(daypartCount(Daypart.MORNING, event_list))
    println(daypartCount(Daypart.EVENING, event_list))
    println(daypartCount(Daypart.AFTERNOON, event_list))

    println("Segunda forma")
    event_list.groupBy { it.daypart }.forEach {
        println("${ it.key.toString()[0]}${it.key.toString().drop(1).lowercase()}: ${it.value.size}")
    }

}

fun daypartCount (daypart: Daypart, eventList: List<Event>): String {
    val event = eventList.filter {
        it.daypart == daypart
    }
    return "${daypart}: ${event.size}"
}

