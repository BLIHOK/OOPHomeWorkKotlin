package ru.netology.reports

import ru.netology.service.WallService

data class Report(
    val ownerId: String,
    val commentId: Int,
    val reason: Reason
) {
    data class Reason(
        val map: Map<Int, String> = mapOf(
            (0 to "спам"),
            (1 to "экстремизм;"),
            (3 to "материал для взрослых;"),
            (4 to "оскорбление")
        ),
    )
}