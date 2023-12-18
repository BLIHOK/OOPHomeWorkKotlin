package ru.netology.data

data class Comment(
    var commentId: Int = 0,
    var fromId: String ="",
    var fromPostId: Int = 0,
    val date : Int = 2023,
    var text: String = ""
)
