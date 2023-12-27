package ru.netology.service

import ru.netology.PostNotFoundException
import ru.netology.ReportException
import ru.netology.data.Comment
import ru.netology.data.Post
import ru.netology.notes.Note
import ru.netology.reports.Report

object WallService {
    private var nextId = 1
    private val posts = mutableListOf<Post>()
    private val comments = mutableListOf<Comment>()
    private var commentCount = 1
    private var report = mutableListOf<Report>()
//    private val note = mutableListOf< Note<T,E> >()

    fun makeReport(userId: String, commentsId: Int, reason: Int): Report {
        val userIdError = comments.find { it.fromId == userId } ?: throw ReportException("Wrong user Id")
        val commentIdError = comments.find { it.commentId == commentsId } ?: throw ReportException("Wrong comment ID")
        val reasonError = Report.Reason(reason).reasonReport ?: throw ReportException("Wrong reason")
        report.add(Report(userId, commentsId, Report.Reason(reason)))
        return report.last()
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        val exist = posts.find { it.id == postId }
        if (exist == null) {
            throw PostNotFoundException("Post not exist")
        } else {
            comments.add(comment)
            comment.commentId = commentCount++
            comment.fromPostId = postId
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
        comments.clear()
        commentCount = 1
        report.clear()
    }

}
