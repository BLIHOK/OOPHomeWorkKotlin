package ru.netology.service

import ru.netology.PostNotFoundException
import ru.netology.data.Comment
import ru.netology.data.Post
import ru.netology.isPostExist
import ru.netology.reports.Report

object WallService {
    private var nextId = 1
    private val posts = mutableListOf<Post>()
    private val comments = mutableListOf<Comment>()
    private var commentCount = 1
    private var report = mutableListOf<Report>()

//    fun makeReport(ownerId: String, commentsId: Int, reason: Report.Reason) {
//        val ownerError = comments.find { it.fromId == ownerId }
//        val commentError = ownerError
//        if (ownerError == null) {
//            if (ownerError)
//        }
//        throw Error("Не удалось отправить репорт. Не указан или неверно указан: ownerId")
//    }if (commentError == null)
//    {
//        println("Репорт отправлен")
//
//        println("Не удалось отправить репорт. Не указан или неверно указан:  commentId")
//        println("Не удалось отправить репорт. Не указан или неверно указан: reason")
//    }

    //    fun createComment(postId: Int, comment: Comment): Comment {
//        val exist = posts.find { it.id == postId }
//        if (exist == null) {
//            throw PostNotFoundException("Post not exist")
//        } else {
//            comments.add(comment)
//            comment.commentId = commentCount++
//            comment.fromPostId = postId
//        }
//        return comments.last()
//    }
    fun createComment(postId: Int, comment: Comment): Comment {
        val exist = posts.find { it.id == postId }
        try {
            isPostExist(exist)
            comments.add(comment)
            comment.commentId = commentCount++
            comment.fromPostId = postId
        } catch (e: PostNotFoundException) {
            e.printStackTrace()
//            throw PostNotFoundException("Post not exist, check Post Id")
//            println(e)
//            System.exit(1)
        }
        return comments.last()
    }


    fun add(post: Post): Post {
        post.id = nextId++
        posts.add(post)
        return post
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