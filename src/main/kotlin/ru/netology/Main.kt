package ru.netology

import ru.netology.data.*
import ru.netology.notes.Note
import ru.netology.notes.Parametrs.BoolExist
import ru.netology.notes.Parametrs.Id
import ru.netology.notes.Parametrs.Text
import ru.netology.service.WallService


fun main(args: Array<String>) {
    val post = Post(
        1, 1, 2000, "Привет",
        reposts = 0, views = 0,
        postType = "Простой", canDelete = true,
        canEdit = true, markedAsAds = false,
        isFavorite = false, likes = Post.Likes(), attachment = docAttachment(Documents())
    )
    val userId = "Юзер1"


    val post2 = Post(
        ownerId = 2,
        date = 2010,
        text = "Добрый день",
        likes = Post.Likes(),
        attachment = audioAttachment(Audio())
    )
    val userId2 = "Юзер2"


//    val post3 = Post(ownerId = 3, date = 2012, text = "Добрый вечер", likes = likes, attachment = linkAttachment(Link()))
//    val userId3 = "Юзер3"
//
//
//    val post4 = Post(date = null, text = null, canDelete = null, likes = likes)
//    val userId4 = "Юзер4"
//

//    val post5 = Post(likes = likes, attachment = videoAttachment(Video()))
//    val userId5 = "Юзер5"
//
    WallService.add(post)
    WallService.likeById(post.id, userId)

    WallService.add(post2)
    WallService.likeById(post.id, userId2)

//    WallService.add(post3)
//    WallService.likeById(post3.id, userId3)
//
//    WallService.add(post4)
//    WallService.likeById(post4.id, userId4)

//    WallService.add(post5)
//    WallService.likeById(post5.id, userId5)

//    println(post)
    println(post.likes)

//    println(post2)
    println(post2.likes)
//    println(post3)
//    println(post3.likes)
//    println(post4)
//    println(post4.likes)
//    println(post5)
//    println(post5.likes)
//    isClass(videoAttachment(Video()))

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
//    val comment1 = Comment(fromId = userId, text = "My first comment")
//    WallService.createComment(2, comment1)
//    println(comment1)

//    val comment2 = Comment(fromId = userId, text = "Иван Федорович Рубентшейн")
//    WallService.createComment(2, comment2)
//    println(post2)
//    println(comment2)
//
//    val report1 = Report(userId = userId, commentId = comment2.commentId, reason = Report.Reason(1))
//    WallService.makeReport(userId, comment2.commentId, report1.reason.type)
//    println(report1)

    val note1 = Note(Text(""), Id(0), BoolExist(true))
    note1.add(Text("A"))
    println(note1.get())
//    note1.add(Text("B"))
//    println(note1)
//    note1.edit(Id(0), listOf(Text("C")))
//    note1.add(Text("Edit"))
//    println(note1)
//    note1.delete(Id(0))
//    println(note1)

}