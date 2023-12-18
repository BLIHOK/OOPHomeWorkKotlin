package ru.netology.data

data class Post(
    var id: Int = 0,
    val ownerId: Int = 0,
    val date: Int? = 0,
    val text: String? = "",
    val reposts: Int = 0,
    val views: Int = 0,
    val postType: String = "",
    val canDelete: Boolean? = false,
    val canEdit: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val likes: Likes,
    val attachment: Attachment
) {

    data class Likes(
        var quantity: Int = 0,
        val users: MutableList<String> = mutableListOf()
    ) {
        fun addLike(user: String) {
            quantity++
            users.add(user)
        }

        fun removeLike(user: String) {
            if (users.contains(user)) {
                users.remove(user)
                quantity = users.size
            }
        }
    }
}