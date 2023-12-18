package ru.netology

import ru.netology.data.Post
import ru.netology.reports.Report

class PostNotFoundException(message: String) : RuntimeException(message)

fun isPostExist(post: Post?) = post ?: throw PostNotFoundException("Post not exist, check Post Id")


class reportException(message: String) : RuntimeException()

fun ownerIdIsExist(ownerId: Int, commentId: Int, reason: Report.Reason) = ownerId ?: commentId ?: reason ?: throw reportException("error")