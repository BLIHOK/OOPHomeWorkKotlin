package ru.netology

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
    val attach: MutableList<Attachment> = mutableListOf(
        docAttachment(documents = Documents(1, "Жизнь Гекельбери Фина", 192, "pdf")),
        videoAttachment(video = Video(2, "Чужой", 117, 1)),
        audioAttachment(audio = Audio(3, "Стинг", "Desert Rose", 2000)),
        linkAttachment(link = Link("www.LifeAfterAndroid.com", "VeryGood", "Some Descritpion", "Вася")),
        photoAttachment(photo = Photo(5, 10, "Какой-то текс", 1996))
    )
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

object WallService {
    private var nextId = 1
    val posts = mutableListOf<Post>()

    fun add(post: Post): Post {
        val postCopy = post.copy(likes = post.likes.copy())
        postCopy.id = nextId++
        posts.add(postCopy)
        return postCopy
    }

    fun update(post: Post): Boolean {
        val existingPostIndex = posts.indexOfFirst { it.id == post.id }
        if (existingPostIndex != -1) {
            posts[existingPostIndex] = post
            return true
        }
        return false
    }

    fun likeById(postId: Int, userId: String) {
        val post = posts.find { it.id == postId }
        if (post != null) {
            post.likes.addLike(userId)
        }
    }

    fun unlikeById(postId: Int, userId: String) {
        val post = posts.find { it.id == postId }
        if (post != null) {
            post.likes.removeLike(userId)
        }
    }

    fun getById(postId: Int): Post? {
        return posts.find { it.id == postId }
    }

    fun clear() {
        posts.clear()
        nextId = 1
    }

}

fun main(args: Array<String>) {
    val likes = Post.Likes(quantity = 0, users = mutableListOf())
    val post = Post(
        1, 1, 2000, "Привет",
        reposts = 0, views = 0,
        postType = "Простой", canDelete = true,
        canEdit = true, markedAsAds = false,
        isFavorite = false, likes = likes
    )
    val userId = "Юзер1"


//    val post2 = Post(ownerId = 2, date = 2010, text = "Добрый день", likes = likes)
//    val userId2 = "Юзер2"
//
//
//    val post3 = Post(ownerId = 3, date = 2012, text = "Добрый вечер", likes = likes)
//    val userId3 = "Юзер3"
//
//
//    val post4 = Post(date = null, text = null, canDelete = null, likes = likes)
//    val userId4 = "Юзер4"
//
    val post5 = Post(likes = likes, attach = mutableListOf())
    val userId5 = "Юзер5"
//
//    WallService.add(post)
//    WallService.likeById(post.id, userId)
//
//    WallService.add(post2)
//    WallService.likeById(post2.id, userId2)
//
//    WallService.add(post3)
//    WallService.likeById(post3.id, userId3)
//
//    WallService.add(post4)
//    WallService.likeById(post4.id, userId4)

    WallService.add(post5)
    WallService.likeById(post5.id, userId5)

    println(post)
    println(post.likes)
//    println(post2)
//    println(post2.likes)
//    println(post3)
//    println(post3.likes)
//    println(post4)
//    println(post4.likes)
//    println(post5)
    println(post5.likes)

//    val updatedPost = Post(
//        id = 1,
//        ownerId = 1,
//        date = 0,
//        text = "Новый привет",
//        reposts = 0,
//        views = 0,
//        postType = "Обновленный",
//        canDelete = true,
//        canEdit = true,
//        markedAsAds = false,
//        isFavorite = false,
//        likes = likes
//    )
//
//    val isUpdated = WallService.update(updatedPost)
//    if (isUpdated) {
//        println(true)
//    } else {
//        println(false)
//    }
//
//    val retrievedPost = WallService.getById(1)
//    println(retrievedPost)
//
//    WallService.unlikeById(post.id, userId)
//
//    println(post.likes)
}