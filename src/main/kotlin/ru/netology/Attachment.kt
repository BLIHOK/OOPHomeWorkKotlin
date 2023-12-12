package ru.netology

interface Attachment {
    val type: String
}

data class docAttachment(
    override val type: String = "documents",
    val documents: Documents
) : Attachment


data class Documents(
    val id: Int = 1,
    val title: String = "Жизнь Гекельбери Фина",
    val size: Int = 192,
    val ext: String = "pdf"
)

data class videoAttachment(
    override val type: String = "video",
    val video: Video
) : Attachment

data class Video(
    val id: Int = 2,
    val title: String = "Чужой",
    val duration: Int = 117,
    val views: Int = 1
)

data class audioAttachment(
    override val type: String = "audio",
    val audio: Audio
) : Attachment

data class Audio(
    val id: Int = 3,
    val artist: String = "Стинг",
    val title: String = "Desert Rose",
    val date: Int = 2000
)

data class linkAttachment(
    override val type: String = "link",
    val link: Link
) : Attachment

data class Link(
    val url: String = "www.LifeAfterAndroid.com",
    val title: String = "VeryGood",
    val description: String = "Some Descritpion",
    val caption: String = "Вася"
)

data class photoAttachment(
    override val type: String = "photo",
    val photo: Photo
) : Attachment

data class Photo(
    val id: Int = 5,
    val album_id: Int = 10,
    val text: String = "Какой-то текс",
    val date: Int = 1996
)
