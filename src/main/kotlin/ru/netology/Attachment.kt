package ru.netology

interface Attachment {
    val type: Any
}

class doc(override val type: Any = "documents") : Attachment
class docAttachment() : Attachment {
    override val type = emptyArray<Attachment>()
    fun add (id: Int){

    }
//    val id: Int
//        get() = TODO()
    val title: String
        get() = TODO()
    val size: Int
        get() = TODO()
    val ext: String
        get() = TODO()
}

class video(override val type: Any = "video") : Attachment
class videoAttachment() : Attachment {
    override val type = emptyArray<Attachment>()
    val id: Int
        get() = TODO()
    val title: String
        get() = TODO()
    val duration: Int
        get() = TODO()
    val views: String
        get() = TODO()
}

class audio(override val type: Any = "audio") : Attachment
class audioAttachment() : Attachment {
    override val type = emptyArray<Attachment>()
    val id: Int
        get() = TODO()
    val artist: String
        get() = TODO()
    val title: String
        get() = TODO()
    val date: Int
        get() = TODO()
}

class link(override val type: Any = "link") : Attachment
class linkAttachment() : Attachment {
    override val type = emptyArray<Attachment>()
    val url: String
        get() = TODO()
    val title: String
        get() = TODO()
    val description: String
        get() = TODO()
    val caption: String
        get() = TODO()
}

class photo(override val type: Any = "photo") : Attachment
class photoAttachment() : Attachment {
    override val type = emptyArray<Attachment>()
    val id: Int
        get() = TODO()
    val album_id: Int
        get() = TODO()
    val text: String
        get() = TODO()
    val date: Int
        get() = TODO()

}




