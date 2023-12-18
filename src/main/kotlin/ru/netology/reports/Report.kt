package ru.netology.reports

data class Report(
    val userId: String,
    val commentId: Int,
    val reason: Reason
) {
    data class Reason(
        var type: Int = 0,
        var reasonReport:String? = when (type) {
            1 -> "спам"
            2 -> "экстремизм"
            3 -> "материал для взрослых"
            4 -> "оскорбление"
            else -> null
        }
    )
}