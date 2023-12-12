package ru.netology

interface Attachment {
    val type: String
}

data class docAttachment(
    override val type: String = "documents",
    val documents: Documents
) : Attachment


data class Documents(
    val id: Int,
    val title: String,
    val size: Int,
    val ext: String
)

data class videoAttachment(
    override val type: String = "video",
    val video: Video
) : Attachment

data class Video(
    val id: Int,
    val title: String,
    val duration: Int,
    val views: Int

)

data class audioAttachment(
    override val type: String = "audio",
    val audio: Audio
) : Attachment

data class Audio(
    val id: Int,
    val artist: String,
    val title: String,
    val date: Int
)

data class linkAttachment(
    override val type: String = "link",
    val link: Link
) : Attachment

data class Link(
    val url: String,
    val title: String,
    val description: String,
    val caption: String
)

data class photoAttachment(
    override val type: String = "photo",
    val photo: Photo
) : Attachment

data class Photo(
    val id: Int,
    val album_id: Int,
    val text: String,
    val date: Int
)

