package ru.netology

sealed class Attachment(val type: String)

data class docAttachment(val documents: Documents) : Attachment ("documents")


data class Documents(
    val id: Int = 1,
    val title: String = "Жизнь Гекельбери Фина",
    val size: Int = 192,
    val ext: String = "pdf"
)

data class videoAttachment(val video: Video) : Attachment ("video")

data class Video(
    val id: Int = 2,
    val title: String = "Чужой",
    val duration: Int = 117,
    val views: Int = 1
)

data class audioAttachment(val audio: Audio) : Attachment ("audio")

data class Audio(
    val id: Int = 3,
    val artist: String = "Стинг",
    val title: String = "Desert Rose",
    val date: Int = 2000
)

data class linkAttachment(val link: Link) : Attachment ("link")

data class Link(
    val url: String = "www.LifeAfterAndroid.com",
    val title: String = "VeryGood",
    val description: String = "Some Descritpion",
    val caption: String = "Вася"
)

data class photoAttachment(val photo: Photo) : Attachment ("photo")

data class Photo(
    val id: Int = 5,
    val album_id: Int = 10,
    val text: String = "Какой-то текс",
    val date: Int = 1996
)
